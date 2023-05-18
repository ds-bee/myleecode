package com.huang.utils;

// Definition for singly-linked list.
public class ListNode {
    public int val;
    public ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }



    public static ListNode createLinkedList(int[] arr) {// 将输入的数组输入到链表中
        if (arr.length == 0) {
            return null;
        }
        ListNode head = new ListNode(arr[0]);
        ListNode current = head;
        for (int i = 1; i < arr.length; i++) {// 过程
            current.next = new ListNode(arr[i]);
            current = current.next;
        }
        return head;
    }

    public static void printLinkedList(ListNode head) {// 将链表结果打印
        ListNode current = head;
        while (current != null) {
            System.out.printf("%d -> ", current.val);
            current = current.next;
        }
        System.out.println("NULL");
    }

//    public static void main(String[] args) {
//        int[] x = {1, 2, 3, 4, 5, 6};
//        ListNode list = createLinkedList(x);
//        printLinkedList(list);
//    }

}