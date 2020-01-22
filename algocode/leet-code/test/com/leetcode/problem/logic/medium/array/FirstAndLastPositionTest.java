package com.leetcode.problem.logic.medium.array;

import org.junit.Test;

import static org.junit.Assert.*;

public class FirstAndLastPositionTest
{
  private FirstAndLastPosition firstAndLastPosition =  new FirstAndLastPosition();

  @Test
  public void searchRange_1()
  {
    int[] nums = new int[] {5,7,7,8,8,10};
//    or int[] nums = {5,7,7,8,8,10};
    int target = 8;
    // output [3,4]
    assertResult(nums, target, 3, 4);

  }

  @Test
  public void searchRange_2()
  {
    int[] input = {2,5,8,8,9,9,10,11};
    int target = 8;
    // output [2,3]
    assertResult(input, target, 2, 3);
  }

  @Test
  public void searchRange_3()
  {
    int[] input = {2,5,8,8,8,8,9,9,10,11};
    int target = 8;
    // output [2,5]
    assertResult(input, target, 2, 5);
  }

  @Test
  public void searchRange_4()
  {
    int[] input = new int[] {2,5,8,9,9,10,11};
    int target = 8;
    // output [2,2]
    assertResult(input, target, 2, 2);
  }

  @Test
  public void searchRange_5()
  {
    int[] input = new int[] {2,5,7,9,9,10,11};
    int target = 8;
    assertResult(input, target, -1, -1);
  }

  @Test
  public void searchRange_6()
  {
    int[] input = new int[] {9,9,10,11};
    int target = 8;
    assertResult(input, target, -1, -1);
  }

  @Test
  public void searchRange_7()
  {
    int[] input = {1,2,2,4,4,5,6};
    int target = 8;
    assertResult(input, target, -1, -1);
  }

  @Test
  public void searchRange_8()
  {
    int[] input = {};
    int target = 8;
    assertResult(input, target, -1, -1);
  }

  @Test
  public void searchRange_9()
  {
    int[] input = {1};
    int target = 1;
    assertResult(input, target, 0, 0);
  }

  @Test
  public void searchRange_10()
  {
    int[] input = {1,1,1};
    int target = 2;
    assertResult(input, target, -1, -1);
  }

  @Test
  public void searchRange_11()
  {
    int[] input = {1,3};
    int target = 1;
    assertResult(input, target, 0, 0);
  }

  private void assertResult(int[] input, int target, int firstPosition, int lastPosition)
  {
    int[] range = firstAndLastPosition.searchRange(input, target);
    assertNotNull(range);
    assertEquals(2, range.length);

    assertEquals(firstPosition, range[0]);
    assertEquals(lastPosition, range[1]);
  }
}