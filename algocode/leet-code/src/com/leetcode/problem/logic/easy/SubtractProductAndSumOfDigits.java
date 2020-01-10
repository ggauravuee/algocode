package com.leetcode.problem.logic.easy;

import java.util.ArrayList;
import java.util.List;

public class SubtractProductAndSumOfDigits
{
  public int subtractProductAndSum(int n) {
    Integer num = new Integer(n);

    List<Integer> digits = new ArrayList<>();

    digits.add(n%10);
    int remNum = n / 10;

    while (remNum > 0)
    {
      digits.add(remNum %10);
      remNum = remNum/10;
    }

    int product =1;
    int sum = 0;
    for (Integer digit : digits)
    {
      product = product * digit;
      sum = sum +digit;
    }

    return product -sum;
  }
}
