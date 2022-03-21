package com;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.tik.mysystem.MainApplication;
import com.tik.mysystem.system.service.NuoNuoSdkService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MainApplication.class)
@Slf4j
public class NuoNuoSdkTest {

    @Autowired
    private NuoNuoSdkService nuoSdkService;

    @Test
    public void test1() {
        try {
            int kpCount = 2;
            List<Future<String>> list = new ArrayList<>();
            long start = System.currentTimeMillis();
            CountDownLatch latch = new CountDownLatch(kpCount);
            for (int i = 0; i < kpCount; i++) {
                Future<String> future = nuoSdkService.requestBilling1(latch);
                list.add(future);
            }
            latch.await();
            log.info("请求开票执行完毕耗时，{}秒", (System.currentTimeMillis() - start) / 1000);
            Thread.sleep(1000 * 60);
            CountDownLatch latchResult = new CountDownLatch(list.size());
            List<Future<String>> resultList = new ArrayList<>();
            long kpStart = System.currentTimeMillis();
            int kptjsb = 0;//开票提交失败
            for (Future<String> future : list) {
                String kpResult = future.get();
                if (StringUtils.isBlank(kpResult)) {
                    kptjsb += 1;
                    log.error("开票提交异常：{}", kpResult);
                    latchResult.countDown();
                    continue;
                }
                JSONObject kpResultObject = JSONObject.parseObject(kpResult);
                if (!Objects.equals("E0000", kpResultObject.getString("code"))) {
                    kptjsb += 1;
                    log.error("开票提交失败：{}", kpResult);
                    latchResult.countDown();
                    continue;
                }
                JSONObject resultObject = kpResultObject.getJSONObject("result");
                log.info("开票提交结果：{}", resultObject.toJSONString());
                Future<String> result = nuoSdkService.queryResultSync(resultObject.getString("invoiceSerialNum"), latchResult);
                resultList.add(result);
            }
            latchResult.await();
            log.info("获取开票结果完毕耗时，{}秒", (System.currentTimeMillis() - kpStart) / 1000);
            if (CollectionUtils.isEmpty(resultList)) {
                log.warn("开票提交成功为0");
                return;
            }
            int kpwc = 0;//开票完成（ 最终状 态）
            int kpz = 0;//开票中-+
            int kpcgqzz = 0;//开票成功签章中
            int kpsb = 0;//开票失败
            int kpcgqzsb = 0;//开票成功签章失败
            int yzf = 0;//发票已作废
            int other = 0;
            for (Future<String> future : resultList) {
                JSONObject kpResultObject = JSONObject.parseObject(future.get());
                JSONArray resultArray = kpResultObject.getJSONArray("result");
                JSONObject resultObject = resultArray.getJSONObject(0);
                log.info("开票结果：" + resultObject.getString("statusMsg"));
                log.info(resultObject.toJSONString());
                if (Objects.equals("2", resultObject.getString("status"))) {
                    kpwc += 1;
                } else if (Objects.equals("20", resultObject.getString("status"))) {
                    kpz += 1;
                } else if (Objects.equals("21", resultObject.getString("status"))) {
                    kpcgqzz += 1;
                } else if (Objects.equals("22", resultObject.getString("status"))) {
                    kpsb += 1;
                } else if (Objects.equals("31", resultObject.getString("status"))) {
                    yzf += 1;
                } else {
                    other += 1;
                }
            }
            log.info("开票提交失败" + kptjsb);
            log.info("开票完成" + kpwc);
            log.info("开票中" + kpz);
            log.info("开票成功签章中" + kpcgqzz);
            log.info("开票失败" + kpsb);
            log.info("开票成功签章失败" + kpcgqzsb);
            log.info("发票已作废" + yzf);
            log.info("其他" + other);
        } catch (Exception e) {
            log.error("异常：{}", e.getMessage());
        }

    }

    @Test
    public void queryResultSync() {
        CountDownLatch latchResult = new CountDownLatch(1);
        //21120210210603245669
        Future<String> result = nuoSdkService.queryResultSync("21120711415603890583", latchResult);
        try {
            log.info(result.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test2() {
        nuoSdkService.requestBilling2();
    }

    @Test
    public void queryResult() {
        nuoSdkService.queryResult();
    }

    @Test
    public void getToken() {
        nuoSdkService.getToken();
    }

    @Test
    public void getPdf() {
        nuoSdkService.getPdf();
    }
}
