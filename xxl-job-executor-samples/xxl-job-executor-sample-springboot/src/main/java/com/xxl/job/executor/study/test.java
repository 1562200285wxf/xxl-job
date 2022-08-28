package com.xxl.job.executor.study;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author ：wang xiaofeng
 * @date ：Created in 2022-08-28 14:42
 * @description：
 */
public class test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int index = Integer.valueOf(str);
        for (int i = 0; i < index; i++) {
            String str1 = sc.nextLine();
            System.out.println(ttt(str1));
        }

    }
    public static String ttt(String numbers){
        String[] strs = numbers.split(" ");
        if(judgeCopy(strs,0) || judgeCopy(strs,3)){
            if(judgeCopy(strs,3)){
                if(strs[0].charAt(0)>strs[3].charAt(0)){
                    return "Alice";
                }else return "Bob";
            }else return "Bob";
        }else {
            if(!judgeCopy2(strs,0).equals("0") || !judgeCopy2(strs,3).equals("0")){
                if(!judgeCopy2(strs,0).equals("0")){
                    if(judgeCopy2(strs,0).charAt(0)>judgeCopy2(strs,3).charAt(0)){
                        return "Alice";
                    }else return "Bob";
                }else return "Bob";
            }else  if(max(strs,0)>max(strs,3)){
                return "Alice";

            }else return "Bob";
        }
    }

    public static boolean judgeCopy(String[] strs,int index){
        int middle = index++;
        if(strs[index].equals(strs[middle]) &&
                strs[middle].equals(strs[middle++])){
            return true;
        }else return false;
    }

    public static String judgeCopy2(String[] strs,int index){

        Set<String> set = new HashSet<>();
        int middle = index++;
        set.add(strs[index]);
        if(set.contains(strs[index++])){
            return strs[index++];
        }else {
            set.add(strs[index++]);
        }
        if(set.contains(strs[middle++])){
            return strs[middle++];
        }else {
           return "0";
        }
    }

    public static int max(String[] strs,int index){
        String max = strs[index];
        if(max.charAt(0)<strs[index++].charAt(0)){
            max = strs[index++];
        }
        int middle = index++;
        if(max.charAt(0)<strs[middle++].charAt(0)){
            max = strs[middle++];
        }
        return max.charAt(0);
    }
}
