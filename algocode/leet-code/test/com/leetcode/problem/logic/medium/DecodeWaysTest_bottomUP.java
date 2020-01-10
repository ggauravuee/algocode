package com.leetcode.problem.logic.medium;

import static org.junit.Assert.assertEquals;

public class DecodeWaysTest_bottomUP
{
  private DecodeWays decodeWays = new DecodeWays();

  @org.junit.Test
  public void numDecodings_1()
  {
    String input = "1";

    assertEquals(1,decodeWays.numDecodings_bottomup(input));
  }

  @org.junit.Test
  public void numDecodings_2()
  {
    assertEquals(2,decodeWays.numDecodings_bottomup("12"));

    assertEquals(1,decodeWays.numDecodings_bottomup("27"));

    assertEquals(3,decodeWays.numDecodings_bottomup("124"));

    assertEquals(3,decodeWays.numDecodings_bottomup("226"));

    assertEquals(2,decodeWays.numDecodings_bottomup("227"));
  }

  @org.junit.Test
  public void numDecodings_3()
  {
    assertEquals(1,decodeWays.numDecodings_bottomup("9"));
    assertEquals(1,decodeWays.numDecodings_bottomup("10")); // ?

    assertEquals(0,decodeWays.numDecodings_bottomup("230")); // ?

    assertEquals(1,decodeWays.numDecodings_bottomup("91"));

    assertEquals(4,decodeWays.numDecodings_bottomup("2626"));
  }

  @org.junit.Test
  public void numDecodings_4()
  {
    assertEquals(5898240,decodeWays.numDecodings_bottomup("1787897759966261825913315262377298132516969578441236833255596967132573482281598412163216914566534565")); // 2,6,2,6 | 2,6,26|26,6,2 | 26,26
  }
}