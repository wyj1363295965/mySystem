package com.tik.mysystem.algorithm;


/**
 * 二分查找
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] nums = new int[]{};
        System.out.println(binarySearch(new int[]{-1, 0, 3, 5, 9, 12}, 9));
    }

    private static int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            int num = nums[mid];
            if (num == target) {
                return mid;
            } else if (num > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }
}
