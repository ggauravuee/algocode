package com.leetcode.problem.logic.medium;

import org.junit.Test;

import static org.junit.Assert.*;

public class GroupGivenTheGroupSizeTest
{
  private GroupGivenTheGroupSize groupGivenTheGroupSize = new GroupGivenTheGroupSize();

  @Test
  public void groupThePeople()
  {
    /*
        Input: groupSizes = [2,1,3,3,3,2]
    Output: [[1],[0,5],[2,3,4]]
     */

    int[] groupSizes = {2,1,3,3,3,2};
    groupGivenTheGroupSize.groupThePeople(groupSizes);
    //[3,3,3,3,3,1,3]


  }

  @Test
  public void groupThePeople_2()
  {

    int[] groupSizes = {3,3,3,3,3,1,3};
    groupGivenTheGroupSize.groupThePeople(groupSizes);
    //[3,3,3,3,3,1,3]


  }
}