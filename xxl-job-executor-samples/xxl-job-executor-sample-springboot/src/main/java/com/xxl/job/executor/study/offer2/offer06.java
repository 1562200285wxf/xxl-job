package com.xxl.job.executor.study.offer2;

import java.util.Stack;

/**
 * @author ：wang xiaofeng
 * @date ：Created in 2022-11-16 16:39
 * @description：链表反转  stack的使用
 */
public class offer06 {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.pop();
        System.out.println(stack);
    }
}
