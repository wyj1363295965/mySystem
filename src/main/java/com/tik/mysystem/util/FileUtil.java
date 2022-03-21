package com.tik.mysystem.util;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.Base64;

public class FileUtil {
    /**
     * 文件转base64编码字符串
     *
     * @param file 文件
     * @return base64编码字符串
     * @throws IOException
     */
    public static String encodeFile(File file) throws IOException {
        byte[] readFileToByteArray = FileUtils.readFileToByteArray(file);
        return Base64.getEncoder().encodeToString(readFileToByteArray);
    }

    /**
     * 文件转base64编码字符串
     *
     * @param filePath 文件路径
     * @return base64编码字符串
     * @throws IOException
     */
    public static String encodeFile(String filePath) throws IOException {
        return encodeFile(new File(filePath));
    }
}
