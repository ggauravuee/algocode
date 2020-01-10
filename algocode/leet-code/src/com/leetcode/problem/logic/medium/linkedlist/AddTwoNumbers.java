package com.leetcode.problem.logic.medium.linkedlist;

import org.w3c.dom.ls.LSException;

public class AddTwoNumbers
{
  public ListNode addTwoNumbers(ListNode l1, ListNode l2)
  {


/*    if ( l1 != null ) {
      l1 = l1.next; // first value node
    }else
      return l2;

    if ( l2 != null ) {
      l2 = l2.next; // first value node
    } else {
      return l1;
    }*/

    ListNode head = new ListNode(0);
    ListNode currentNode = head;
    int carryover = 0;

    while (l1 != null && l2 != null)
    {
        int sum = l1.val + l2.val + carryover;
        carryover = sum / 10;
        int sumNumber = sum % 10;

        currentNode.next = new ListNode(sumNumber);
        currentNode = currentNode.next;

        l1 = l1.next;
        l2 = l2.next;

        // (243, 345), (243, 3), (3, 345), (0,0)
        if (l1 != null && l2 == null)
          l2 = new ListNode(0);  //padding to make length of both numbers same

        if (l2 != null && l1 == null)
          l1 = new ListNode(0);  //padding to make length of both numbers same
    }

    if (carryover > 0) // TODO: add a node in result list
    {
      currentNode.next = new ListNode(carryover);
    }

    return head.next;
  }
}
