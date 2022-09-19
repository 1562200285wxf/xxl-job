package com.xxl.job.executor.study.calculatiion;

import java.util.Scanner;

/**
 * @author ：wang xiaofeng
 * @date ：Created in 2022-09-06 20:50
 * @description：
 */
public class Armstrong {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str = sc.next();
        int num1 = Integer.valueOf(str.split("=")[1]);
        int num=sc.nextInt();
        if(num>9 || num<1){
            return;
        }
        int max = (int)Math.pow(10,num);
        int init = num>1?max/10:0;
        int[] a = new int[1000];
        int i,p,j,sum=0;
        for(i=init;i<max;i++)
        {
            p=am(i,a);
            for(j=0,sum=0;j<p;j++)
            {
                sum=sum+(int)Math.pow(a[j],p);
            }
            if(sum==i)
                System.out.println(i);
        }
    }
    public static int am(int n,int a[])
    {
        int i,p=0;
        int[] lp = new int[1000];
        for(i=0,p=0;;i++)
        {
            a[i]=n%10;
            n=n/10;
            lp[i]=n;
            p++;
            if(lp[i]==0)
                break;
        }
        return p;
    }
}
