package com.tik.mysystem.algorithm;

import org.apache.commons.collections.MapUtils;

import java.util.*;

public class FinallyDemo {
    int idx;

    public static void main(String[] args) {
        System.out.println(demo1().idx);
        System.out.println(demo2());

    }

    public static FinallyDemo demo1() {
        FinallyDemo finallyDemo = new FinallyDemo();
        finallyDemo.idx = 20;
        try {
            finallyDemo.idx = (int) 10L;
            return finallyDemo;
        } catch (Exception e) {
            finallyDemo.idx = 30;
            return finallyDemo;
        } finally {
            finallyDemo.idx = 40;
        }
    }

    public static int demo2() {
        int a = 20;
        try {
            System.out.println(a / 0);
            a = 10;
            return a;
        } catch (Exception e) {
            a = 30;
            return a;
        } finally {
            a = 40;
        }
    }

    class DateBean {
        private Date startTime;
        private Date endTime;

        public Date getStartTime() {
            return startTime;
        }

        public void setStartTime(Date startTime) {
            this.startTime = startTime;
        }

        public Date getEndTime() {
            return endTime;
        }

        public void setEndTime(Date endTime) {
            this.endTime = endTime;
        }

        public DateBean() {
        }

        public DateBean(Date startTime, Date endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }
    }

    private Set<DateBean> code1(List<DateBean> dateList) {
        Set<DateBean> dateBeans = new HashSet<>();
        for (DateBean mydate : dateList) {
            Date startTime = mydate.getStartTime();
            Date endTime = mydate.getEndTime();
            //第一个时间
            if (dateBeans.size() == 0) {
                dateBeans.add(new DateBean(startTime, endTime));
            }
            HashMap<Date, Date> tempMap = new HashMap<>();
            Iterator<DateBean> iterator = dateBeans.iterator();
            while (iterator.hasNext()) {
                DateBean next = iterator.next();
                Date start = next.getStartTime();
                Date end = next.getEndTime();
                if (startTime.after(end) || endTime.before(start)) {
                    dateBeans.add(new DateBean(startTime, endTime));
                } else if (startTime.before(start) && endTime.before(end)) {
                    dateBeans.add(new DateBean(startTime, end));
                    iterator.remove();
                } else if (startTime.before(start) && endTime.before(start)) {
                    dateBeans.add(new DateBean(startTime, endTime));
                    iterator.remove();
                } else if (startTime.before(end) && endTime.after(end)) {
                    dateBeans.add(new DateBean(start, endTime));
                }
            }
        }
        return dateBeans;
    }
}
