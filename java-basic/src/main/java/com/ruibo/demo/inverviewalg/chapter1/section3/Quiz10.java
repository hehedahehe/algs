package com.ruibo.demo.inverviewalg.chapter1.section3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 编写一个过滤器InfixToPostfix
 * 将算术表达式由中序表达式转为后序表达式
 *
 */
public class Quiz10 {
    /**
     *            +
     *         /    \
     *        /      *
     *       / \     /  \
     *      *   -   3    -
     *      ....
     *      思路1：构造二叉树，进行后续遍历。采用递归的方式，自顶向下。
     *      思路2：直接遍历，采用队列/栈结构，自底向上处理。
     * @param args
     */
    public static void main(String[] args) {
        String inFixCase = "2*3/(2-1)+3*(4-1)";
        String postFixCase = "23*21-/341-*+";
    }



    public static class InfixToPostfix{
        public static String infixToPostFix(String inFixCase){
            //1. 操作数栈
            Stack<String> operandsStack = new Stack<>();
            //2. 操作符栈
            Stack<String> operatorStack = new Stack<>();
            //3. 中间结果操作数队列
            Queue<String> tempOperandsQueue = new LinkedList<>();
            /**
             * 1. 遍历解析生成中间结果
             * 2. 遍历中间结果生成最终结果
             */
            String[] items = inFixCase.split("");
            for (int i = 0; i < items.length; i++) {
                String item = items[i];
                if(Tools.isOperand(item)){
                    operandsStack.push(item);
                }else if(Tools.isOperator(item)){
                    operatorStack.push(item);
                }else if(Tools.isInvoker(item)){
                    //invoker

                }else {
                    //"("左括号不做处理
                }
            }
            return "";
        }
    }


}
