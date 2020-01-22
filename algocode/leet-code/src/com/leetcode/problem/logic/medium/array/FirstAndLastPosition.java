package com.leetcode.problem.logic.medium.array;

/*
https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/

Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
*/

public class FirstAndLastPosition
{
  public int[] searchRange( int[] nums, int target) {
    // int[] nums = [5,7,7,8,8,10]
    // int target = 8;
    // output [3,4]

    int[] range = {-1, -1};

    if(nums == null  || nums.length == 0)
      return range;

    int length = nums.length;

    if (length ==1){
      if (nums[0] == target)
        return new int[] {0,0};
      else
        return range;

    }

      // lower range
    range[0] = getFirstPosition(nums, target,0, length -1);


    if(range[0] > -1)
    {
      // only search if input has target
      // upper range
      range[1] = getLastPosition(nums, target, 0, length - 1);
    }

    return range;
  }

  private int getFirstPosition(int[] nums, int target, int lowerBound, int upperBound)
  {
    int lowerPosition = -1;

    if ( target > nums[upperBound] || target < nums[lowerBound]) return -1;

    int midValue;

    while ( upperBound > lowerBound)
    {
      int midPosition = (upperBound - lowerBound) /2;
      lowerPosition = lowerBound + midPosition; // absolte position in original array
      midValue = nums[lowerPosition];
      if (midValue < target){
        if (upperBound > lowerBound){

          lowerBound = lowerPosition +1; // TODO: array bounds check needed?
        }else
        {
          lowerBound = lowerPosition;
        }

      }else
      {
        upperBound = lowerPosition;
        //        lowerPosition = midPosition;
      }

      lowerPosition = lowerBound;

    }

    if(nums[lowerPosition] == target)
      return lowerPosition;
    else
      return -1;
  }

  private int getLastPosition(int[] nums, int target, int lowerBound, int upperBound)
  {
    int upperPosition = -1;

    if ( target > nums[upperBound] || target < nums[lowerBound]) return -1;

    int midValue;

    while ( upperBound > lowerBound)
    {
      int midPosition = (upperBound - lowerBound) /2 + 1;
      upperPosition = lowerBound + midPosition; // absolute position in original array
      midValue = nums[upperPosition];
      if (midValue <= target){
        lowerBound = upperPosition; // TODO: array bounds check needed?
      }else
      {
        if(upperPosition >= 1){
          upperBound = upperPosition -1;
        }else
        {
          upperBound = upperPosition;
        }

      }

      upperPosition = upperBound;
    }

    if(nums[upperPosition] == target)
      return upperPosition;
    else
      return -1;
  }
}
