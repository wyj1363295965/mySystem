package com.tik.mysystem.algorithm;

public class SingnalDemo {


    /**
     * 输入
     */
    public static void main(String[] args) {
        int[][] ints = {{1, 2}, {3, 4}, {5, 6}};
        System.out.println(test1(3, 2, ints, 2, 2));

        System.out.println(test1(3, 2, "1 2 3 4 5 6 7 8", 2, 2));
    }

    public static int test1(int m, int n, int[][] numArray, int i, int j) {
        if (i > m || j > n) {
            return 0;
        }
        return numArray[i - 1][j - 1];
    }

    public static int test1(int m, int n, String tempArr, int i, int j) {
        if (i > m || j > n) {
            return 0;
        }
        String[] s = tempArr.split(" ");
        return Integer.parseInt(s[(i - 1) * (j - 1)]);
    }
}
