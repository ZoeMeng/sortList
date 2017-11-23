package com.zoe.AlgorithmsDemo;
/*
Sort a linklist list in O(n log n) time using constant space complexity

 */
public class sortListSolution {
    public ListNode sortList(ListNode head){
        if(head == null)
            return head;
        ListNode mid = getMiddle(head);//get the middle node of the list

        //断开
        ListNode midNext = mid.next;
        mid.next = null;

        //排序，合并
        return mergeTwoLists(head,midNext);
    }

    public ListNode getMiddle(ListNode head){
        if(head == null || head.next == null) //空或只有一个
            return head;
        ListNode fast,slow;
        fast = slow = head;

        //快2步，慢1步
        while(fast.next != null && fast.next.next != null){
            //偶数时取第一个
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;

    }

    /*
    * 实现合并两个已经排序的链表
    * @param l1
    * @param l2
    * @return
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2){
        //特殊情况
        if(l1 == null)
            return l2;
        if(l2 == null)
            return l1;
        ListNode first = l1.next, second = l2.next;
        ListNode res, newHead;
        if(l1.val < l2.val){
            newHead = res = l1;
            second = l2;
        }else{
            newHead = res = l2;
            second = l1;
        }

        while (first != null || second != null){
            if(first == null){//第一条链表没另
                res.next = second;
                return newHead;
            }
            else if(second == null){
                res.next = second;
                return newHead;
            }
            else if(first.val < second.val){
                res.next = first;
                first = first.next;
                res = res.next;
            }else{
                res.next = second;
                second = second.next;
                res = res.next;
            }

        }
        return newHead;

    }
}
