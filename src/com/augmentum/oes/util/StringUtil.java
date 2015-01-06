package com.augmentum.oes.util;

public class StringUtil {
    public static String getQId(int id) {
        String s = String.valueOf(id);
        s = "000000" + s;
        s = "Q" + s.substring(s.length()-7, s.length());
        return s;
    }
}
