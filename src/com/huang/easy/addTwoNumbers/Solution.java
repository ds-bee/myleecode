package com.huang.easy.addTwoNumbers;

import com.huang.utils.ListNode;

import java.util.ArrayList;

//class ListNode {
//     int val;
//     ListNode next;
//     ListNode() {}
//     ListNode(int val) { this.val = val; }
//     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
// }

public class Solution {
    public static void main(String[] args) {
        int[] x = { 7,2,4,3 };
        int[] y = { 5,6,4 };
        ListNode l1 = ListNode.createLinkedList(x);
        ListNode l2 = ListNode.createLinkedList(y);
        ListNode listNode = addTwoNumbers(l1, l2);
        ListNode.printLinkedList(listNode);

    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node = reversalNode(l1);
        ListNode.printLinkedList(node);
        ListNode node1 = reversalNode(l2);
        int length = 0;
        int length1 = 0;
        while (node != null){
            length++;
            node = node.next;
        }
        while (node1 != null){
            length1++;
            node1 = node1.next;
        }
        ListNode listNode1 = l1;
        ListNode listNode2 = l2;

        if(length > length1){
            while (listNode2 != null){
                if(node.val + node1.val > 10){
                    listNode1.val = node.val + node1.val - 10;
                }else {
                    listNode1.val = node.val + node1.val;
                }
                listNode2 = listNode2.next;
                listNode1 = listNode1.next;
            }
            return l1;
        }
        if(length < length1){
            while (listNode1 != null){
                if(node.val + node1.val > 10){
                    listNode2.val = node.val + node1.val - 10;
                }else {
                    listNode2.val = node.val + node1.val;
                }
                listNode2 = listNode2.next;
                listNode1 = listNode1.next;
            }
            return l2;
        }
        return null;
    }
     //链表 反转
//     public static ListNode reversalNode(ListNode node){
//         ListNode node1 = node;
//         ListNode node2 = null;
//         ArrayList<ListNode> listNodes = new ArrayList<>();
//         while (node1 != null){
////              if(node1.next.next != null){
////                   ListNode node2 = node.next.next;
////              }
//              listNodes.add(node1);
//              node1 = node1.next;
//         }
//         node2 = listNodes.get(listNodes.size() - 1);
//         ListNode node3 = node2;
//         for (int i = listNodes.size() - 1; i > 0; i--) {
//             node2.next = listNodes.get(i - 1);
//             node2 = node2.next;
//         }
//         return node3;
//     }

    public static ListNode reversalNode(ListNode head) {
        int n = 0; //记录链表长度
        ListNode pre = head;
        //求链表的长度
        while(pre!=null){
            ++n;
            pre = pre.next;
        }
        //从头结点开始交换，需要交换n-1次
        for(int i=n-1;i>0;--i){
            pre = head;
            //每个节点需要交换i次
            for(int j=0;j<i&&pre!=null;++j){
                int val = pre.val;
                pre.val = pre.next.val;
                pre.next.val = val;
                pre = pre.next;
            }
        }
        return head;
    }




//    public ArrayList<Integer> addList(ArrayList<Integer> list , ListNode node){
//        while (node != null){
//            list.add(node.val);
//            node = node.next;
//        }
//        return list;
//    }
}
