package com.tik.mysystem.system.service;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.tik.mysystem.system.entity.NuoNuoKpPo;
import com.tik.mysystem.util.UUIDUtil;
import lombok.extern.slf4j.Slf4j;
import nuonuo.open.sdk.NNOpenSDK;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Future;

@Service
@Slf4j
public class NuoNuoSdkService {

    //private


    NNOpenSDK sdk = NNOpenSDK.getIntance();
    String queryInvoiceResultMethod = "nuonuo.ElectronInvoice.queryInvoiceResult"; // API方法名
    String resultContent = "{\"isOfferInvoiceDetail\": " +
            "\"1\",\"orderNos\": [],\"serialNos\": [\"21110315210101516052\"]}";


    //String taxnum = "339901999999500"; // 授权企业税号
    String taxnum = "440300L80116750";
    String code = "4475b3a927a6568e9706998629ad428c";
    String token = "366100f6187024a7906ba51jpboz4zgi"; // 访问令牌
    String taxnum1 = "91440300MA5FGTNB2D";
    String code1 = "dc4f6b578fdd07d928af6dffcfc4be54";
    String token1 = "0c8ab0afe4899bfa33c41a1wtslw5uoi";
    String appKey = "16505906";
    String appSecret = "2C23B2C893A64136";
    String method = "nuonuo.ElectronInvoice.requestBillingNew"; // API方法名

    String content = "{\"order\":{\"invoiceDetail\":[" +
            "{\"specType\":\"\"," +
            "\"taxExcludedAmount\":\"89.38\"," +
            "\"invoiceLineProperty\":\"0\"," +
            "\"favouredPolicyName\":\"\"," +
            "\"num\":\"1\"," +
            "\"withTaxFlag\":\"1\"," +
            "\"tax\":\"11.62\"," +
            "\"favouredPolicyFlag\":\"0\"," +
            "\"taxRate\":\"0.13\"," +
            "\"unit\":\"双\"," +
            "\"deduction\":\"\"," +
            "\"price\":\"101\"," +
            "\"zeroRateFlag\":\"\"," +
            "\"goodsCode\":\"1040204020000000000\"," +
            "\"selfCode\":\"\"," +
            "\"goodsName\":\"鞋\"," +
            "\"taxIncludedAmount\":\"101\"}]," +
            "\"buyerTel\":\"\"," +
            "\"listFlag\":\"0\"," +
            "\"pushMode\":\"2\"," +
            "\"departmentId\":\"\"," +
            "\"clerkId\":\"\"," +
            "\"checker\":\"皇甫静晶\"," +
            "\"remark\":\"\"," +
            "\"payee\":\"杜丹丹\"," +
            "\"buyerAddress\":\"\"," +
            "\"buyerTaxNum\":\"\"," +
            "\"invoiceType\":\"1\"," +
            "\"invoiceLine\":\"p\"," +
            "\"email\":\"\"," +
            "\"salerAccount\":\"中国工商银行股份有限公司深圳太古城支行4000111209100122246\"," +
            "\"orderNo\":\"20190801120207971529\"," +
            "\"salerTel\":\"0755-86542181\"," +
            "\"buyerName\":\"刘裕民\"," +
            "\"invoiceDate\": \"2021-12-01 12:30:00\"," +
            "\"invoiceCode\":\"\"," +
            "\"invoiceNum\":\"\"," +
            "\"salerAddress\":\"深圳市南山区粤海街道大冲社区科发路19号华润置地大厦D座NL171NL201号商铺\"," +
            "\"clerk\":\"肖旭\"," +
            "\"buyerPhone\":\"18689499705\"," +
            "\"buyerAccount\":\"\"," +
            "\"productOilFlag\":\"0\"," +
            "\"salerTaxNum\":\"" + taxnum + "\"," +
            "\"listName\":\"详见销货清单\"," +
            "\"proxyInvoiceFlag\":\"0\"}}";
    String url = "https://sdk.nuonuo.com/open/v1/services"; // SDK请求地址
    String senid = UUID.randomUUID().toString().replace("-", ""); // 唯一标识，由企业自己生成32位随机码


    private static NuoNuoKpPo nuoNuoKpPo;

    static {
        nuoNuoKpPo = new NuoNuoKpPo();
        //nuoNuoKpPo.setOrder();
    }


    /**
     * 开票方法
     */
    @Async("taskExecutor")
    public Future<String> requestBilling1(CountDownLatch latch) {
        try {
            JSONObject contentJson = JSONObject.parseObject(content);
            JSONObject order = contentJson.getJSONObject("order");
            String orderNo = UUIDUtil.getUuid();
            order.put("orderNo", "4EF40056271B4D90");
            contentJson.put("order", order);
            log.info("开票数据：{}", contentJson);
            String result = sdk.sendPostSyncRequest(url, senid, appKey, appSecret, token, taxnum, method, contentJson.toJSONString(), 5);
            //System.out.println(result);
            latch.countDown();
            return new AsyncResult<>(result);
        } catch (Exception e) {
            latch.countDown();
            log.error("开票异常：{}", e.getMessage(), e);
        }

        return new AsyncResult<>("");
    }


    public void requestBilling2() {
        JSONObject contentJson = JSONObject.parseObject(content);
        int i = (int) (Math.random() * 900) + 100;
        JSONObject order = contentJson.getJSONObject("order");
        String orderNo = order.getString("orderNo").substring(0, order.getString("orderNo").length() - 3) + i;

        order.put("orderNo", orderNo);
        contentJson.put("order", order);
        String result = sdk.sendPostSyncRequest(url, senid, appKey, appSecret, token, taxnum, method, contentJson.toJSONString());
        System.out.println(result);
    }


    @Async("taskExecutor")
    public Future<String> queryResultSync(String serialNos, CountDownLatch latch) {
        JSONObject contentJson = JSONObject.parseObject(resultContent);
        contentJson.put("serialNos", Lists.newArrayList(serialNos));
        String senid = UUID.randomUUID().toString().replace("-", ""); // 唯一标识，32位随机码，无需修改，保持默认即可
        String kpResult = sdk.sendPostSyncRequest(url, senid, appKey, appSecret, token, taxnum, queryInvoiceResultMethod, contentJson.toJSONString(), 5);
        //System.out.println(result);
        latch.countDown();
        return new AsyncResult<>(kpResult);
    }

    /**
     * 查询开票结果
     */
    public void queryResult() {
        //第一次 21110315210101516052
        NNOpenSDK sdk = NNOpenSDK.getIntance();
        String method = "nuonuo.ElectronInvoice.queryInvoiceResult"; // API方法名
        String content = "{\"isOfferInvoiceDetail\": " +
                "\"1\",\"orderNos\": [],\"serialNos\": [\"\"]}";
        String senid = UUID.randomUUID().toString().replace("-", ""); // 唯一标识，32位随机码，无需修改，保持默认即可
        String result = sdk.sendPostSyncRequest(url, senid, appKey, appSecret, token1, taxnum, method, content);
        System.out.println(result);
    }

    public void getToken() {

        String json = NNOpenSDK.getIntance().getISVToken(appKey, appSecret, code, taxnum, "http://127.0.0.1");
        System.out.println(json);
    }

    public void refreshToken() {
        String json = NNOpenSDK.getIntance().refreshISVToken(appKey, appSecret, taxnum, "http://127.0.0.1");
        System.out.println(json);
    }

    //{"access_token":"370743d065d1e97e3c12431h3rycceki","refresh_token":"f3b224232664559247884ad67881e628","oauthUser":"{\"userName\":\"339901999999500\",\"registerType\":\"1\"}","expires_in":86400,"userId":"8A0F455FEA704743998C9F6967EA2633"}


    public void getPdf() {
        NNOpenSDK sdk = NNOpenSDK.getIntance();
        String method = "nuonuo.ElectronInvoice.getPDF"; // API方法名
        String content = "{\"inTaxAmount\": \"1288.80\",\"exTaxAmount\": \"687.99\",\"invoiceNo\": \"00130865\",\"invoiceCode\": \"125999915630\"}";
        String senid = UUID.randomUUID().toString().replace("-", ""); // 唯一标识，32位随机码，无需修改，保持默认即可
        String result = sdk.sendPostSyncRequest(url, senid, appKey, appSecret, token, taxnum, method, content);
        System.out.println(result);
    }

    public void getCode() {

    }
}
