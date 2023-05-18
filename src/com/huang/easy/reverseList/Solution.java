package com.huang.easy.reverseList;

public class Solution {
public class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }


    public ListNode reverseList(ListNode head) {
        ListNode tem = head;
        int lenth = 0;
        while (tem != null){
            tem = tem.next;
            lenth++;
        }
        int[] ints = new int[lenth];
        tem = head;
        for (int i = 0; i < ints.length; i++) {
            ints[i] = tem.val;
            tem = tem.next;
        }
        tem = head;
        for (int i = ints.length - 1; i >= 0; i--) {
            tem.val = ints[i];
            tem = tem.next;
        }
        return head;

    }


}
