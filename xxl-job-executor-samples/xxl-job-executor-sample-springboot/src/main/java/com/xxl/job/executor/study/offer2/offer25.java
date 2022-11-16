package com.xxl.job.executor.study.offer2;

import java.util.Stack;

/**
 * @author ：wang xiaofeng
 * @date ：Created in 2022-11-16 16:39
 * @description：链表反转
 */
public class offer25 {

    public static void main(String[] args) {

    }

    public ListNode revert(ListNode head){
        if(head.next == null || head == null ){
            return null;
        }
        ListNode cur = revert(head.next);
        head.next.next = head;
        //隔绝当前节点与下一个节点的联系，
        head.next = null;
        return cur;
    }


    private class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
