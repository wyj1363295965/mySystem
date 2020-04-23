package com.tik.mysystem;


import com.tik.mysystem.system.mybatisPlus.UserMapper;
import com.tik.mysystem.system.entity.mybatisPlus.MybatisUser;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.runner.RunWith;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class DaoTest {


    @Autowired
    private UserMapper userMapper;

    @Test
    public void test1() {

    }

    @Test
    public void test2() {
        System.out.println(("----- selectAll method test ------"));
        List<MybatisUser> userList = userMapper.selectList(null);
        Assert.assertEquals(5, userList.size());
        userList.forEach(System.out::println);
    }

    @Test
    public void test3() {

    }

    @Test
    public void test4() {
//        List<InternalPath> path = broConnRepository.findById("9ee0e618-2c60-4265-a7ae-051172f5e673");
//        for (Map<String, MapValue> map : list) {
//
//            for (Map.Entry<String, MapValue> entry : map.entrySet()) {
//                System.out.println(entry.getKey() + "    " + entry.getValue());
//            }
//        }
//        System.out.println(list);

//        List<BroConn> list = broConnRepository.findById("9ee0e618-2c60-4265-a7ae-051172f5e673");
//
//        System.out.println(list);

//        Iterator nodeIterator = path.get(1).nodes().iterator();
//        while (nodeIterator.hasNext()) {
//            Node node = (Node) nodeIterator.next();
//            System.out.println(node.id() + "+++++++++++++++++" + node.asMap());
//
//        }
    }
}
