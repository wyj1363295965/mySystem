package com;

import com.tik.mysystem.MainApplication;
import com.tik.mysystem.properties.WxProperties;
import com.tik.mysystem.util.aes.AesException;
import com.tik.mysystem.util.aes.WXBizMsgCrypt;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MainApplication.class)
public class EcodeTest {

    @Autowired
    private WxProperties wxProperties;

    @Test
    public void test1() throws AesException {
        //WXBizMsgCrypt wxcpt = new WXBizMsgCrypt(wxProperties.getToken(), wxProperties.getEncodingAesKey(), wxProperties.getCorpId());
        WXBizMsgCrypt wxcpt = new WXBizMsgCrypt("AX2NIMz6lxqCcc9jbg1oSzU3g", "grJC3ewbuKP5pbiheeDGI1VbBImp9YKCa3zxT1C9J1f", "wwdaa1d03fe0ce906c");
        //wxcpt.VerifyURL("", "", "", "");
        System.out.println(wxcpt);
    }

    @Test
    public void test() {
        String data = "<xml><ToUserName><![CDATA[wwdaa1d03fe0ce906c]]></ToUserName><FromUserName><![CDATA[sys]]></FromUserName><CreateTime>1631067332</CreateTime><MsgType><![CDATA[event]]></MsgType><Event><![CDATA[change_contact]]></Event><ChangeType><![CDATA[update_user]]></ChangeType><UserID><![CDATA[4403012641]]></UserID><Name><![CDATA[王亚杰1]]></Name></xml>";


    }
}
