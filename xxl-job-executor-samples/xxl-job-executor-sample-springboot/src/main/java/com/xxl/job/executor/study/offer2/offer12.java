package com.xxl.job.executor.study.offer2;



/**
 * @author ：wang xiaofeng
 * @date ：Created in 2022-11-16 18:12
 * @description：删除链表中的节点
 */
public class offer12 {
    public static void main(String[] args) {
        ListNode listNode = ListNode.getInstance();
        removeNode(listNode,2);
        System.out.println(listNode);
    }

    public static ListNode removeNode(ListNode listNode,int target){
        ListNode current = listNode;
        if(listNode.val == target){
            return listNode.next;
        }
        while (listNode.next != null && listNode.next.val%3 == 0){
            if(listNode.next.next != null) {
                listNode.next = listNode.next.next;
            }else {
                listNode.next = null;
            }
            listNode = listNode.next;
        }
        return current;
    }



}
