package com.fd.solution;

import java.util.List;
import java.util.Stack;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 */
public class LinkAdd {


    public static void main(String[] args) {

//        // 1 -> 2 -> 3  321
//        ListNode listNode1 = new ListNode(1);
//        listNode1.setNext(new ListNode(2)).setNext(new ListNode(3));
//        // 6 -> 5 -> 4  456
//        ListNode listNode2 = new ListNode(6);
//        listNode2.setNext(new ListNode(5)).setNext(new ListNode(4));

//        // 2 -> 4 -> 3  342
//        ListNode listNode1 = new ListNode(2);
//        listNode1.next = new ListNode(4);
//        listNode1.next.next = (new ListNode(3));
//        // 5 -> 6 -> 4  465
//        ListNode listNode2 = new ListNode(5);
//        listNode2.next = (new ListNode(6));
//        listNode2.next.next = (new ListNode(4));


        // 5
        ListNode listNode1 = new ListNode(5);
        // 5
        ListNode listNode2 = new ListNode(5);

        ListNode listNode = addTwoNumbers(listNode1, listNode2);

        while (listNode != null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }


    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        if (l1 == null ) return l2;
        if (l2 == null ) return l1;

        ListNode tail = new ListNode(0);     // 指针指向链表的队尾
        ListNode head = tail;
        int val;
        int carryBit = 0;   // 进位

        while (l1 != null || l2 != null || carryBit !=0){       // carryBit !=0 才能满足，否则把进位给丢失了
            val = carryBit + (l1 == null ? 0:l1.val) + (l2 == null ? 0:l2.val);
            carryBit = val/10;
            val = val%10;                       // 0 、 10 的余数都是0

            ListNode temp = new ListNode(val);
            tail.next = temp;
            tail = temp;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        return head.next;
    }

  public static class ListNode {


      int val;
      ListNode next;
      ListNode(int x) { val = x; }

  }

}
