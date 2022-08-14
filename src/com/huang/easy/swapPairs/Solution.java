package com.huang.easy.swapPairs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
public class Solution {

    public ListNode swapPairs(ListNode head) {
        ListNode node = head;
//        ListNode listNode = node;
////        listNode = listNode.next;
////        node.next = node.next.next;
////        listNode.next = node;
//
//        node = node.next;
//        listNode.next = listNode.next.next;
//        node.next = listNode;
        ListNode listNode1 = changeNode(node);

//        if(tem == null){
//            return head;
//        }else {
//            changeNode(tem);
//            swapPairs(tem.next.next.next);
//        }
        return listNode1;

    }

    public static ListNode changeNode(ListNode node){
        if(node == null || node.next == null){
            return node;
        }
//        ListNode listNode = node;
//        System.out.println(listNode.val);
//        listNode.next = listNode.next.next;
//
//        System.out.println(listNode.next.val);
//        node = node.next;
//        node.next = listNode;
//        System.out.println(node.val);
//        System.out.println(node.next.val);System.out.println(node.next.next.val);
//        System.out.println(node.next.next.next.val);

//        ListNode tem = node.next;
//        node.next = node.next.next;
//        tem.next = node;
//        node = tem;

        ListNode listNode = node;
//        listNode = listNode.next;
//        node.next = node.next.next;
//        listNode.next = node;
        System.out.println(node);
        node = node.next;//这里地址变了吗 果然是这里调用时地址变了,但是好像没变，这里有问题，需要去问问人
        System.out.println(node);
        listNode.next = listNode.next.next;
        node.next = listNode;
        System.out.println(node.next);
        System.out.println(node.next.next);System.out.println(node.next.next.next);
        //为什么这里一定要有人来接收呀
//        node.next.next = changeNode(node.next.next);
        changeNode(node.next.next);
        return node;
    }


}
