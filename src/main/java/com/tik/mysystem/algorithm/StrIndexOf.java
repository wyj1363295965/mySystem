package com.tik.mysystem.algorithm;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;

@Slf4j
public class StrIndexOf {


    public static void main(String[] args) {
        System.out.println(strIndexOf("address", "re"));
        System.out.println(strIndexOf("address", "ww"));
        System.out.println(strIndexOf("address", "a"));
        System.out.println(strIndexOf("address", "s"));
        //System.out.println("addressf".substring(7,8));
        log.info("1");
        System.out.println(strIndexOf("addressf", "f"));
    }

    /**
     * strA包含strB的起始位置，strA=“address”,strB="re",return 3;不包含返回-1
     * strA和strB校验跳过，不符合返回0
     */
    static int strIndexOf(String strA, String strB) {

        if (StringUtils.isEmpty(strA) || StringUtils.isEmpty(strB)) {
            return 0;
        }
        for (int i = 0; i < strA.length(); i++) {
            for (int j = i + 1; j < strA.length() + 1; j++) {
                String tmp = strA.substring(i, j);
                //System.out.println(tmp);
                if (tmp.equals(strB)) {
                    return i;
                }
            }
        }
        return -1;
    }
}
