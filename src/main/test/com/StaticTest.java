package com;

import com.tik.mysystem.MainApplication;
import com.tik.mysystem.algorithm.SingletonDemo3;
import com.tik.mysystem.system.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@Slf4j
@SpringBootTest(classes = MainApplication.class)
public class StaticTest {

    private final RestTemplate restTemplate = new RestTemplate();

    static final HttpHeaders headers = new HttpHeaders();

    {
        headers.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_PDF_VALUE);
    }


    @Test
    public void pdfCode() {
        String pdfUrl = "";

        try {
            ResponseEntity<byte[]> response = restTemplate.exchange(
                    pdfUrl,
                    HttpMethod.HEAD,
                    new HttpEntity<byte[]>(headers),
                    byte[].class);
            System.out.println(response.getStatusCode());
        } catch (Exception e) {
            log.info("失败：{}", e.getMessage(), e);
        }
    }

    @Test
    public void test1() {
        User uniqueUser1 = SingletonDemo3.INSTANCE.getInstance();
        User uniqueUser2 = SingletonDemo3.INSTANCE.getInstance();
        System.out.println(uniqueUser1 == uniqueUser2);
    }

}
