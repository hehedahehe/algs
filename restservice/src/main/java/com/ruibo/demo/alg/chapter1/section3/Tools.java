package com.ruibo.demo.alg.chapter1.section3;

public class Tools {
    public static String buildTempResult(String n1, String n2, String op) {
        return "(" + n1 + op + n2 + ")";
    }

    public static boolean isOperand(String a) {
        return !isInvoker(a) && !isOperator(a);
    }

    public static boolean isOperator(String a) {
        return "+".equals(a) || "-".equals(a) || "*".equals(a)||"/".equals(a);
    }

    public static boolean isInvoker(String a) {
        return ")".equals(a);
    }
}
