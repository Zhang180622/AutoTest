package com.apitest.demo2.common;

import org.apache.commons.codec.digest.DigestUtils;

public class Utils {

    public static String encryptMd5(String string){
        return DigestUtils.md5Hex(string);
    }


}
