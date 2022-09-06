package com.xxl.job.executor.study.oppo;

/**
 * @author ：wang xiaofeng
 * @date ：Created in 2022-09-02 21:38
 * @description：
 */
class MergeTwoList  {

    public static ListNode mergerTwoList(ListNode list1, ListNode list2){
        ListNode head = new ListNode(0);
        ListNode result = head;

        while(list1 != null && list2 != null){
            if(list1.val >= list2.val){
                head.next = list2;
                head = head.next;
                list2 = list2.next;
            }else{
                head.next = list1;
                head = head.next;
                list1 = list1.next;
            }
        }
        if(list1 == null){
            head.next = list2;
        }else{
            head.next = list1;
        }
        return result.next;
    }


    public static void main(String[] args){
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(5);
        head.next = node1;
        node1.next = node2;
        node3.next = node4;
        ListNode result = mergerTwoList(head, node3);
        while (result != null){
            System.out.println(result.val);
            result = result.next;
        }

    }
}


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
