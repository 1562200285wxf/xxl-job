package com.xxl.job.executor.study.offer2;

import java.util.Scanner;

/**
 * @author ：wang xiaofeng
 * @date ：Created in 2022-09-01 17:35
 * @description：你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 */
public class offer92 {


    public static void main(String[] args) {
        int[] a = new int[] {3,4,5};

        System.out.println(digit(a));
    }


    private static int digit(int[] a ) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - 1 - i; j++) {
                if (compare(a[j], a[j + 1])) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
        for (int i : a) {
            result.append(i);
        }
        return Integer.valueOf(result.toString());
    }
    private static boolean compare(int a, int b) {// 比较大小，前大为true
        String s1 = a + "" + b;
        String s2 = b + "" + a;

        int result = s1.compareTo(s2);
        if (result < 0) {
            return true;
        }
        return false;
    }




      private class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

}
