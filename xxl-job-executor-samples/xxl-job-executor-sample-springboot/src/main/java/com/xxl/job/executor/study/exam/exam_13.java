package com.xxl.job.executor.study.exam;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author ：wang xiaofeng
 * @date ：Created in 2022-12-26 18:44
 * @description：字符串加密算法
 */
public class exam_13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] strings = str.split("");
        System.out.print(reverse(str.charAt(0),1));
        if(strings.length>1){
            System.out.print(reverse(str.charAt(1),2));
        }
        if(strings.length>2){
            System.out.print(reverse(str.charAt(2),4));
        }if(strings.length>3) {
            Stack<Integer> stack = new Stack<>();
            stack.push(1);
            stack.push(2);
            stack.push(4);
            for (int i = 3; i < str.length(); i++) {
                int third = stack.pop();
                int second = stack.pop();
                int first = stack.pop();
                int index = first + second + third;
                char c = reverse(str.charAt(i), index);
                System.out.print(c);
                stack.push(second);
                stack.push(third);
                stack.push(index);
            }
        }
    }

    public static char reverse(char str,int index){
        if(str+index<='z'){
            return (char)(str+index);
        }else return (char)((str+index)%26+'a');
    }
}
