package com.huang.easy.getIntersectionNode;

import com.huang.utils.ListNode;

public class solution1 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode tem1 = headA;
        ListNode tem2 = headB;
        int len1 = 0;
        int len2 = 0;

        while (tem1 != null){
            len1++;
            tem1 = tem1.next;
        }
        while (tem2 != null){
            len2++;
            tem2 = tem2.next;
        }
        int len = len1>len2?len1 - len2:len2 - len1;
        tem1 = len1>len2?headA:headB; //长
        tem2 = len1>len2?headB:headA; //短
        while (len != 0){
            len--;
            tem1 = tem1.next;
        }
        while (tem2 != null){
            if(tem1 == tem2){
                return tem2;
            }
            tem1 = tem1.next;
            tem2 = tem2.next;
        }
        return null;
    }

}
