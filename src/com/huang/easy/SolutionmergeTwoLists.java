//package com.huang.easy;
//
//public class SolutionmergeTwoLists {
//    public void main(String[] args) {
//        ListNode l1 = new ListNode(new int[]{1, 2, 3});   //创建链表对象 l1 （对应有参 和 无参 构造方法）
//
//
//
//    }
//
//
//    public class ListNode {
//          int val;
//          int[] val1;
//
//        public ListNode(int[] val1) {
//            this.val1 = val1;
//        }
//
//        ListNode next;
//          ListNode() {}
//          ListNode(int val) { this.val = val; }
//          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//      }
//    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//        if (l1 == null) {
//            return l2;
//        } else if (l2 == null) {
//            return l1;
//        } else if (l1.val < l2.val) {
//            l1.next = mergeTwoLists(l1.next, l2);
//            return l1;
//        } else {
//            l2.next = mergeTwoLists(l1, l2.next);
//            return l2;
//        }
//    }
//}
//
//}
