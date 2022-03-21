package com.tik.mysystem.util;

import java.util.UUID;

public class UUIDUtil {

    public static String getUuid() {
        return UUID.randomUUID().toString().replaceAll("-", "").toUpperCase().substring(0, 16);
    }
}
