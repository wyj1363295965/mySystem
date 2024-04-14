package com.tik.mysystem.algorithm;

public class CostLowestMain {


    //    给你一个整数数组 cost ，其中 cost 是从楼梯第 i 个台阶向上爬需要支付的费用。一旦你支付此费用，即可选择向上爬一个或者两个台阶。
//
//    你可以选择从下标为 0 或下标为 1 的台阶开始爬楼梯。
//
//    请你计算并返回达到楼梯顶部的最低花费。
    public static void main(String[] args) {
        int[] cost = new int[]{10, 15, 20};
        System.out.println(costLowest(cost));
    }


    private static int costLowest(int[] cost) {
        int len = cost.length;
        for (int i = 2; i < len; i++) {
            cost[i] = Math.min(cost[i - 1], cost[i - 2] + cost[i]);
        }
        return Math.min(cost[len - 1], cost[len - 2]);
    }
}
