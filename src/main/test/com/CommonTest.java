package com;

import com.google.common.collect.Lists;
import com.tik.mysystem.MainApplication;
import com.tik.mysystem.system.entity.User1;
import com.tik.mysystem.generator.mapper.FreightConfigMapper;
import com.tik.mysystem.system.hystrix.RequestCommand;
import com.tik.mysystem.system.service.ThreadPoolService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.stream.Collectors;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = MainApplication.class)
@Slf4j
public class CommonTest {

    @Autowired
    private FreightConfigMapper freightConfigMapper;
    @Autowired
    private ThreadPoolService threadPoolService;
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public static void main(String[] args) {
        double a = 0.211;
        double b = 0.30;
        System.out.println(a * b);

        Random random = new Random();
        Integer suffix = random.nextInt(10000);
        System.out.println(suffix);
    }

    @Test
    public void test1() throws ParseException {
        SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
        Date date = formater.parse("2021-4-06");
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int dayForWeek = 0;
        if (c.get(Calendar.DAY_OF_WEEK) == 1) {
            dayForWeek = 7;
        } else {
            dayForWeek = c.get(Calendar.DAY_OF_WEEK) - 1;
        }
        System.out.println(dayForWeek);
    }

    @Test
    public void test2() {
        User1 user1 = new User1(1, "1");
        User1 user2 = new User1(2, "2");
        User1 user3 = new User1(2, "3");
        User1 user4 = new User1(2, "4");
        List<User1> userList = Lists.newArrayList(user1, user2, user3, user4);
        userList.sort(Comparator.comparing(User1::getUsername).reversed());
        System.out.println(userList);
        Map<Integer, List<User1>> bomMap = userList.stream().collect(Collectors.groupingBy(User1::getId));
        bomMap.forEach((k, v) -> {
            String userName = v.get(0).getUsername();
            System.out.println(userName);
        });
    }

    @Test
    public void test3() {
        System.out.println(freightConfigMapper.selectByPrimaryKey(3));
    }

    @Test
    public void test4() {
        RequestCommand command = new RequestCommand("");
        String result = command.execute();
        System.out.println(result);
    }


    @Test
    public void test5() {
        Integer i = 3;
        System.out.println(Objects.equals(i, 3));
        for (int j = 0; j < 100; j++) {
            threadPoolService.tesTask1(j);
        }
    }


    @Test
    public void test6() throws Exception {
        List<Future<Integer>> list = new ArrayList<>();
        CountDownLatch latch = new CountDownLatch(100);
        log.info("开始时任务数：{}", latch.getCount());
        for (int j = 0; j < 100; j++) {
            Future<Integer> future = threadPoolService.tesTask2(j, latch);
            list.add(future);
        }
        try {
            latch.await();
            log.info("所有线程执行完毕，{}", latch.getCount());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (Future<Integer> future : list) {
            log.info(future.get().toString());
        }

    }

    @Test
    public void test7() throws Exception {
        rabbitTemplate.convertAndSend("myKey", "test");
    }
}
