package com.ruibo.alg.chapter1.section3;

import java.util.Stack;
import java.util.regex.Pattern;

/**
 * 编写一段程序，从标准输入得到一个缺少左括号的表达式
 * 并打印出补全括号之后的中序表达式
 * 假定
 * 1+2)*3-4)*5-6)))
 * 你的程序应该输出
 * （（1+2）*（（3-4）*（5-6）））
 *
 *
 * （（3-4）*（5-6））
 * 3-4）*5-6））
 */
public class Quiz9 {

    /**
     * 思路：
     * 采用三个栈进行模拟
     * 1. 中间操作数栈
     * 2. 操作数栈
     * 3. 指令栈
     *
     * @param args
     */
    public static void main(String[] args) {
        String testCase = "3-4)*5-6))";
        String[] chars = testCase.split("");
        Stack<String> operands = new Stack<>();
        Stack<String> operandsTemp = new Stack<>();
        Stack<String> operators = new Stack<>();
        String res = null;
        for (int i = 0; i < chars.length; i++) {
            String str = chars[i];
            if (isNum(str)) {
                operands.push(str);
                System.out.println(operands);
            } else if (isOperator(str)) {
                operators.push(str);
                System.out.println(operators);
            } else {
                //invoker 触发计算逻辑
                if (operands.size() > 0) {
                    String num2 = operands.pop();
                    String num1 = operands.pop();
                    String operator = operators.pop();
                    String tempResult = buildTempResult(num1, num2, operator);
                    operandsTemp.push(tempResult);
                    System.out.println(operandsTemp);
                } else {
                    while (operandsTemp.size() > 1) {
                        String tempResult2 = operandsTemp.pop();
                        String tempResult1 = operandsTemp.pop();
                        String operator = operators.pop();
                        String tempResult = buildTempResult(tempResult1, tempResult2, operator);
                        operandsTemp.push(tempResult);
                        i++; //写程序时容易漏掉
                    }
                    System.out.println(operandsTemp);
                    res = operandsTemp.pop();
                }
            }
        }

        System.out.println("==="+res);
    }

    private static String buildTempResult(String n1, String n2, String op) {
        return "(" + n1 + op + n2 + ")";
    }

    private static boolean isNum(String a) {
        return !isInvoker(a) && !isOperator(a);
    }

    private static boolean isOperator(String a) {
        return "+".equals(a) || "-".equals(a) || "*".equals(a);
    }

    private static boolean isInvoker(String a) {
        return ")".equals(a);
    }


}
