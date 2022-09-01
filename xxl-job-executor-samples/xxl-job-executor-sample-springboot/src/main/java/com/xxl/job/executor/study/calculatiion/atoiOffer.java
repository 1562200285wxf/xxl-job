package com.xxl.job.executor.study.calculatiion;

/**
 * @author ：wang xiaofeng
 * @date ：Created in 2022-08-08 17:09
 * @description：
 */
public class atoiOffer {
    public static void main(String[] args) {
        System.out.println(myAtoi("words and 987"));
    }

    public static int myAtoi(String s) {

        char[] chars = s.toCharArray();
        int length = chars.length;
        int index = 0;
        StringBuilder stringBuilder = new StringBuilder();
        while (chars[index]>'9' || chars[index]<'0'){
            if(chars[index] == '-' || chars[index] == '+'){
                if(chars[index] == '-'){
                    stringBuilder.append(chars[index]);
                    index++;
                    break;
                }
                index++;
                break;
            }
            index++;
        }
        while (index<length){
            char c = chars[index];
            if(c<='9' && c>='0'){
                stringBuilder.append(c);
            }else break;
            index++;
        }
        return Integer.valueOf(stringBuilder.toString());
    }
}
