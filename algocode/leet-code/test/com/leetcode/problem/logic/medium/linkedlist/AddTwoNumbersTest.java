package com.leetcode.problem.logic.medium.linkedlist;

import org.junit.Test;

import static org.junit.Assert.*;

public class AddTwoNumbersTest
{
  private AddTwoNumbers addTwoNumbers = new AddTwoNumbers();

  @Test
  public void addTwoNumbers()
  {
    // 342 + 465 = 708
    ListNode l1= new ListNode(2);
    l1.next = new ListNode(4);
    l1.next.next = new ListNode(3);

    ListNode l2 = new ListNode(5);
    l2.next = new ListNode(6);
    l2.next.next = new ListNode(4);

    ListNode sumListNode = addTwoNumbers.addTwoNumbers(l1, l2);

    while(sumListNode !=null)
    {
      System.out.println(sumListNode.val);
      sumListNode = sumListNode.next;
    }


  }
}