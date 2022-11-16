package com.xxl.job.executor.study.calculatiion;

/**
 * @author ：wang xiaofeng
 * @date ：Created in 2022-10-28 18:11
 * @description：链表反转
 */
public class ReverseListTest {

    public static void main(String[] args) {

    }


    public static int dec(int m,int n){
        if(m<=0 || n <=0){
            return 0;
        }
        int y = n-3*m;
        int x = 4*m-n;
        return x*y;
    }

}
