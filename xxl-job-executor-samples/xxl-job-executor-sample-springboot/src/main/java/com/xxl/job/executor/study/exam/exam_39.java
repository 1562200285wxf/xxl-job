package com.xxl.job.executor.study.exam;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author ：wang xiaofeng
 * @date ：Created in 2022-12-28 10:55
 * @description：解压报文
 */
public class exam_39 {
    public static void main(String[] args) {
        de("3[m2[c]]");
    }

    public static List<String> to(String str){
        List<String> result = new ArrayList<>();
        String[] strings = str.split("");
        for (String string : strings) {
            char c = string.charAt(0);
            if (!Character.isDigit(c)){
                result.add(String.valueOf(c));
            }else {
                if(result.size()!=0){
                    //如果栈不为空，且最后一位元素包含数字，则最后一位是数字
                    String s = result.get(result.size()-1);
                    if(Character.isDigit(s.charAt(0))) {
                        result.add(String.valueOf(Integer.valueOf(s) * 10 + Integer.valueOf(c)));
                    }else {
                        result.add(string);
                    }
                }else result.add(string);
            }

        }
        return result;
    }



    public static void de(String str){
        Stack<Character> stack = new Stack<>();
        String res = "";
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(c != ']'){
                stack.push(c);
            }else {
                StringBuilder stringBuilder = new StringBuilder("");
                while (stack.size()!=0 && !Character.isDigit(stack.lastElement())){
                    if(stack.lastElement() == '['){
                        stack.pop();
                        break;
                    }
                    stringBuilder.append(stack.pop());
                }
                stringBuilder= stringBuilder.reverse();
                int num = 0;
                while (stack.size()!=0 && Character.isDigit(stack.lastElement())){
                    int a = stack.pop()-'0';
                    num*=10;
                    num+=a;
                }
                res = stringBuilder+res;
                res = dou(num,res);
            }
        }
        System.out.println(res);
    }

    public static String dou(int num, String String) {
        String temp = "";
        for (int i = 0; i < num; ++i) {
            temp += String;
        }
        return temp;
    }
}
