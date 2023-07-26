package com.huang.easy.isPalindrome;

import com.huang.utils.ListNode;

import java.util.Stack;

import static com.huang.utils.ListNode.createLinkedList;

public class solution {
    public static void main(String[] args) {
//        int[] arr = {1,2,2,1};
        int[] arr = {1,2,2};
//        int[] arr = {1,2};
        ListNode linkedList = createLinkedList(arr);
        System.out.println(isPalindrome(linkedList));

    }

    public static boolean isPalindrome(ListNode head) {
        int len = 0;
        ListNode tem = head;
        while (tem != null){
            len++;
            tem = tem.next;
        }
        Stack<Integer> stack = new Stack<Integer>();

        tem = head;
        int reord = 0;
        while (tem != null){
            if(reord < len /2){
                stack.push(tem.val);
            }
            if(reord >= len/2 + len%2){
                Integer pop = stack.pop();
                if(!pop.equals(tem.val)){
                    return false;
                }
            }
            reord++;
            tem = tem.next;
        }
        return true;
    }
}
