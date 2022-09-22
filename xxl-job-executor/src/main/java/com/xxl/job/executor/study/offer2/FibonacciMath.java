package com.xxl.job.executor.study.offer2;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：wang xiaofeng
 * @date ：Created in 2022-07-26 10:21
 * @description：费波列齐
 */
public class FibonacciMath {
    public static void main(String[] args) {
        System.out.println(fib1(48));
        System.out.println(fib(48));
    }
    public static Map<Integer,Integer> map = new HashMap<>();

    public static int fib(int n) {
        return fib1(n)%1000000007;
    }
    public static int fib1(int n) {
        if(n <=0){
            return 0;
        }else if(n == 1 || n==2){
            return 1;
        }else {
            if(map.containsKey(n-1) && map.containsKey(n-1)){
                return map.get(n-1)+map.get(n-2);
            }else {
                int fib1 = fib1(n-1);
                int fib2 = fib1(n-2);
                map.put(n-1,fib1);
                map.put(n-2,fib2);
                int result = fib1+fib2;
                map.put(n,result);
                return result;
            }
        }

    }

}
