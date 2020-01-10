package com.leetcode.problem.logic.easy;

import org.junit.Assert;
import org.junit.Test;

public class SubtractProductAndSumOfDigitsTest
{
  private static SubtractProductAndSumOfDigits obj = new SubtractProductAndSumOfDigits();

  @Test
  public void subtractProductAndSum_1()
  {
    Assert.assertEquals(15, obj.subtractProductAndSum(234));

  }

}