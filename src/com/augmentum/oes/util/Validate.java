package com.augmentum.oes.util;

public class Validate {

    public static boolean isEmpty(String string) {
        if ((string == null) || (string.trim().equals(""))) {
            return true;
        } else {
            return false;
        }
    }
}
