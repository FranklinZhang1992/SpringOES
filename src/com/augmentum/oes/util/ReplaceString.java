package com.augmentum.oes.util;

public class ReplaceString {

    public static String replaceString(String string) {
        string.replace("<", "&lt;").replace(">", "&gt;");
        return string;
    }

}
