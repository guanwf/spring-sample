package com.github.spring.demo.core.utils;

public class AssertUtils {

    public static void notNull(final Object obj) {
        if (obj == null) {
            throw new RuntimeException("argument invalid,Please check");
        }
    }

}
