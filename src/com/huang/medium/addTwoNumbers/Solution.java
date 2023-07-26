package com.huang.medium.addTwoNumbers;

import com.huang.utils.ListNode;

public class Solution {
    /**
     *  int n1 = l1 != null ? l1.val : 0;
     *  int n2 = l2 != null ? l2.val : 0;
     *  还有一个技巧就是创建了新的链表结构存储
     *  head = tail = new ListNode(sum % 10);创建新链表传入
     * @param args
     */
    public static void main(String[] args) {
//        int[] y = { 5,6,4 };
//        int[] x = { 7,2,7 };
        int[] y = { 9,9,9,9 };
        int[] x = { 9 };
//        int[] y = { 5,6,4 };
//        int[] x = { 2,4,3 };
//        int[] y = { 5 };
//        int[] x = { 5 };
        ListNode l1 = ListNode.createLinkedList(x);
        ListNode l2 = ListNode.createLinkedList(y);
        ListNode listNode = addTwoNumbers(l1, l2);
        ListNode.printLinkedList(listNode);
    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode tem1 = l1;
        ListNode tem2 = l2;
        int record = 0;
        int len1 = 0;
        int len2 = 0;

        while (tem1 != null){
            tem1 = tem1.next;
            len1++;
        }
        while (tem2 != null){
            tem2 = tem2.next;
            len2++;
        }
        if(len1 > len2){
            tem1 = l2;
            tem2 = l1;
        }else {
            tem1 = l1;
            tem2 = l2;
        }
        ListNode listNode = tem2;
        while (tem1!= null || tem2 != null){
//            int r = 0;
            if(tem1!= null && tem2 != null){
                tem2.val = tem1.val + tem2.val + record;
            }else {
                tem2.val =  tem2.val + record;
            }
            if(tem2.val > 9){
                record = 1;
            }else {
                record = 0;
            }
            tem2.val = tem2.val%10 ;
            if(tem1 != null){
                tem1 = tem1.next;
            }
            tem2 = tem2.next;
        }
//        return listNode;
        if(record == 1){
            ListNode tem3 = listNode;
            int record1 = 0;
            while (tem3 != null){
                if(tem3.next == null){
                    if(len1 == len2){
                        tem3.next = new ListNode(1,null);
                        break;
                    }else {
                        if(tem3.val == 0){
                            tem3.next = new ListNode(1,null);
                        }else {
                            tem3.val = tem3.val + 1;
                        }
                        break;
                    }
                }
                tem3 = tem3.next;
            }
        }
        return listNode;
    }

}
