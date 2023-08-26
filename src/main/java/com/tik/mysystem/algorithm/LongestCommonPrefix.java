package com.tik.mysystem.algorithm;

public class LongestCommonPrefix {

    /**
     * 最长公共前缀
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"flower", "fl"}));
    }

    private static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length < 1) {
            return "";
        }
        String first = strs[0];
        for (int i = 0; i < first.length(); i++) {
            char c = first.charAt(i);
            for (int j = 1; j < strs.length; j++) {
                String temp = strs[j];
                if (i == temp.length() || c != temp.charAt(i)) {
                    return first.substring(0, i);
                }
            }
        }
        return first;
    }
}
