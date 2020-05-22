package com.fd.solution;

public class LinkAdd {


    public static void main(String[] args) {

        // 1 -> 2 -> 3  321
        ListNode listNode1 = new ListNode(1);
        listNode1.setNext(new ListNode(2)).setNext(new ListNode(3));
        // 6 -> 5 -> 4  456
        ListNode listNode2 = new ListNode(6);
        listNode2.setNext(new ListNode(5)).setNext(new ListNode(4));

        boolean flag = false;
        ListNode temp1;
        ListNode temp2;
        int v1,v2;
        do {

            v1 = temp1.val;
            v2 = temp2.val;
        }while ( temp1.next!= null && temp2 != null);




    }

  public static class ListNode {


      int val;
      ListNode next;
      ListNode(int x) { val = x; }

      public ListNode setNext(ListNode next) {
          this.next = next;
          return this.next;
      }
  }

}
