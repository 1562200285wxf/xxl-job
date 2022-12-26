package com.xxl.job.executor.study.exam;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author ：wang xiaofeng
 * @date ：Created in 2022-12-26 17:27
 * @description：最大括号深度
 */
public class exam_12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        Stack<Character> stack = new Stack<>();
        int max = 0;
        for (int i = 0; i < str.length() ; i++) {
            Character character = str.charAt(i);
            if(character == '(' || character == '[' || character == '{' ) {
                stack.push(character);
                max = Math.max(max, stack.size());
            }else {
                if (stack.size() == 0) {  // 第一个是右括号，直接break
                    break;
                }
                if (character == ')') {  // 判断括号是否匹配，匹配，则continue，不匹配直接break(这里放到最后整体break)
                    if (stack.pop() == '(') {
                        continue;
                    }
                } else if (character == ']') {
                    if (stack.pop() == '[') {
                        continue;
                    }
                } else {
                    if (stack.pop() == '{') {
                        continue;
                    }
                }
                break;
            }
        }
        System.out.println(max);
    }
}
