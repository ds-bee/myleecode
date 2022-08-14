package com.huang.easy.removeNthFromEnd;

public class Solution {

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode tem = head;
        int length = 0;
        int real = 0;
        while (tem.next != null) {
            length++;

            tem = tem.next;
        }
        System.out.println(length);
        real = length - n;
        tem = head;
        length = 0;
        while (tem.next != null) {
            length++;
            if (length == real) {
                // tem.next = tem.next.next;
                tem = tem.next;
                break;
            }
            tem = tem.next;
        }
        return head;


    }
}
