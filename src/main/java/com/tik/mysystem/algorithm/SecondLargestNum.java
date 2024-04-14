package com.tik.mysystem.algorithm;


//求最大和第二大的数
public class SecondLargestNum {

    public static void main(String[] args) {
        int[] ints = {1, 22, 3, 45, 7, 8, 0};
        int[] ints1 = {1, 2, 39, 45, 70, 0, 0};
        secondLargestNum(ints);
        secondLargestNum(ints1);
    }

    private static void secondLargestNum(int[] arr) {
        int a1 = 0;//最大数
        int a2 = 0;//第二大的数

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > a1) {
                a2 = a1;
                a1 = arr[i];
                continue;
            }
            //arr[i]!=a1过滤重复情况，按需添加
            if (arr[i] > a2 && arr[i] != a1) {
                a2 = arr[i];
            }
        }
        System.out.println(a1);
        System.out.println(a2);
        System.out.println("====================");
    }
}
