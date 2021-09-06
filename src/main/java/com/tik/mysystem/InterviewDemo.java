package com.tik.mysystem;

import com.google.common.collect.Lists;

import java.util.*;

public class InterviewDemo {

    public static void main(String[] args) {
        Map<String, Integer> source = new HashMap<>();
        //添加数据，题中已给

        source.put("10120410=结息", 1);
        source.put("10120410=退汇", 1);
        source.put("10120410=结息", 2);
        source.put("10120410=退汇", 2);

        //输入科目号和关键词
        String number = "10120410";
        String content = "已结息，可退费";
        List<String> contents = new ArrayList<>();//存放切割content的字符，“已”，“已结”，“结息”，。。。。
        List<Integer> result = new ArrayList<>();
        for (String oneContent : contents) {
            result.add(source.get(number + oneContent));
        }

        Integer min = Collections.min(result);
    }
}
