package com.huang.medium.rotateRight;

import com.huang.utils.ListNode;

public class Solution {
    public static void main(String[] args) {
//        int[] y = { 1,2,3,4,5 };
//        int k = 2;
        int[] y = { 1,2,3 };
        int k = 2;
        ListNode l1 = ListNode.createLinkedList(y);
        ListNode listNode = rotateRight(l1, k);
        ListNode.printLinkedList(listNode);
    }
//    public static ListNode rotateRight(ListNode head, int k) {
//        if(head == null || head.next == null || k == 0){
//            return head;
//        }
//        ListNode tem = head;
//        int length = 0;
//        while (tem != null){
//            tem = tem.next;
//            length++;
//        }
//        tem = head;
//        k = k%length;
//        if(length == 2){
//            if(k == 1){
//                ListNode listNode = tem.next;
//                tem.next = null;
//                listNode.next = tem;
//                return listNode;
//            }
//        }
//        ListNode second = null;
//        for (int i = 0; i < k; i++) {
//            tem = tem.next;
//            if(i == k - 1){
//                second = tem.next;
//                tem.next = null;
//            }
//        }
//        ListNode third = second;
//        while ( second.next != null){
//            second = second.next;
////            if(second.next == null){
////                second.next =
////            }
//        }
//        second.next = head;
//        return third;
//
//    }
    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        ListNode tem = head;
        ListNode tem1 = head;
        int length = 0;
        while (tem != null){
//            if(tem1.next == null){
//                tem1.next = head;
//            }
            tem = tem.next;
//            tem1 = tem1.next;
            length++;
        }
        tem = head;

        for (int i = 0; i < length; i++) {
            if(i == length - 1){
                tem.next = tem1;
                break;
            }
            tem = tem.next;
        }

        k = k%length;
//        ListNode tem1 = head;
        ListNode tem3 = head;
        int record = 0;
        ListNode r = null;
        while (tem3!=null){
            tem3 = tem3.next;
            record++;
            if(record == length - k){
                r = tem3;
            }
            if(record == length + k){
                tem3.next = null;
                break;
            }

        }
        return r;
    }
    /**
     * 这里先使用将链表成环，然后在将环斩断的方法，这里主要是找到断的前一个
     */

    public ListNode rotateRight1(ListNode head, int k) {
        if (k == 0 || head == null || head.next == null) {
            return head;
        }
        int n = 1;
        ListNode iter = head;
        while (iter.next != null) {
            iter = iter.next;
            n++;
        }
        int add = n - k % n;
        if (add == n) {
            return head;
        }
        iter.next = head;
        while (add-- > 0) {
            iter = iter.next;
        }
        ListNode ret = iter.next;
        iter.next = null;
        return ret;
    }

}
