package com.study.util;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class CommonUtil {
    public static String NVL(Object value) {
        String result = "";

        if (value != null) {
            result = value.toString();
        }

        return result;
    }

    public static String NVL(Object value, String defaultValue) {
        String result = defaultValue;

        if (value != null) {
            result = value.toString();
        }

        return result;
    }

    public static int NVL(Object value, int defaultValue) {
        int result = defaultValue;

        if (value instanceof Integer) {
            result = (Integer) value;
        } else if (value instanceof BigDecimal) {
            result = ((BigDecimal) value).intValue();
        }

        return result;
    }

    public static double NVL(Object value, double defaultValue) {
        double result = defaultValue;

        if (value instanceof Double) {
            result = (Double) value;
        }

        return result;
    }

    public static boolean NVL(Object value, boolean defaultValue) {
        boolean result = defaultValue;

        if (value instanceof Boolean) {
            result = (boolean) value;
        }

        return result;
    }
}
