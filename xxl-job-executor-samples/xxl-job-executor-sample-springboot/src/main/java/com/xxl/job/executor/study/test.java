package com.xxl.job.executor.study;

import java.util.Scanner;

/**
 * @author ：wang xiaofeng
 * @date ：Created in 2022-08-27 17:16
 * @description：
 */
public class test {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int sourceLength = Integer.valueOf(str.split(" ")[0]);
        int targetLength = Integer.valueOf(str.split(" ")[1]);
        String source = sc.nextLine();
        String target = sc.nextLine();
        System.out.println(strStr1(source,target,sourceLength,targetLength));
    }

    public static int strStr1(String source, String target,int sourceLength,int targetLength){
        String[] str1 = source.split("");
        String[] str2 = target.split("");
        int index = 0;
        int count = 0;
        while (index<sourceLength){
            count = count+judge(str1,str2,index,targetLength);
            index++;
        }
        return count;
    }

    public static int judge(String[] str1 ,String[] str2,int sourceIndex,int targetLength){
        int index = 0;
        while (index<targetLength){
            if(!str2[index].equals("*") && !str1[sourceIndex].equals(str2[index])){
                return 0;
            }else {
                if(index != targetLength-1){
                    index++;
                    sourceIndex++;
                }else {
                    if (str2[index].equals("*") || str1[sourceIndex].equals(str2[index])) {
                        return 1;
                    } else return 0;
                }
            }
        }
        return 0;
    }
}
