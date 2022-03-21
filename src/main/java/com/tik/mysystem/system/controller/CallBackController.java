package com.tik.mysystem.system.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.tik.mysystem.system.entity.InvoicingCallbackResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


@RestController
@RequestMapping("/callBack")
@Slf4j
public class CallBackController {

    /**
     * 异步开票回调接口
     *
     * @param content
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "test", method = RequestMethod.POST)
    private InvoicingCallbackResponseDto callBack(@RequestBody String content) throws Exception {

        log.info("回调结果：{}", content);
        JSONObject jsonObject = JSONObject.parseObject(content);
        Map<String, Object> map = JSON.parseObject(content, Map.class);
        boolean signature = true;
        if (!signature) {
            System.out.println("签名校验失败");
        }
        //log.info("解密后：{}", SM4Utils.decryptCbc(jsonObject.get("business_data").toString(), "F128D3E9D04243EB"));
        return new InvoicingCallbackResponseDto(InvoicingCallbackResponseDto.SUCCESS_CODE, "");
    }
}
