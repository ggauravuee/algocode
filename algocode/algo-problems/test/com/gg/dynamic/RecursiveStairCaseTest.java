package com.gg.dynamic;

import dynamic.RecursiveStairCase;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RecursiveStairCaseTest
{
  private static RecursiveStairCase recursiveStairCase;

  @BeforeAll
  public static void setup()
  {
    recursiveStairCase = new RecursiveStairCase(10000);
  }

  @Test
  void getPossibleStepCount_1()
  {
    int numberOfStairCases = 1;
    int expectedCount = 1;
    assertCountEquals(numberOfStairCases, expectedCount);
  }

  @Test
  void getPossibleStepCount_2()
  {
    assertCountEquals(2, 2);
  }

  @Test
  void getPossibleStepCount_3()
  {
    assertCountEquals(3, 3);
  }

  @Test
  void getPossibleStepCount_4()
  {
    assertCountEquals(4, 5);
  }

  @Test
  void getPossibleStepCount_5()
  {
    assertCountEquals(5, 8);
  }

  @Test
  void getPossibleStepCount_8()
  {
    assertCountEquals(8, 34);
  }

  @Test
  void getPossibleStepCount_100()
  {
    assertCountEquals(100, 1298777728820984005l);
  }


  private void assertCountEquals(int numberOfStairCases, long expectedCount)
  {
    long possibleStepCount = recursiveStairCase.getPossibleStepCount(numberOfStairCases);
    System.out.println("possibleStepCount for number Of Stair Cases="+ numberOfStairCases + " can be :"+ + possibleStepCount);
    assertEquals(expectedCount, possibleStepCount);

    long possibleStepCount_bottomUP = recursiveStairCase.getPossibleStepCount_BottomUP(numberOfStairCases);
    System.out.println("[Bottom UP] possibleStepCount for number Of Stair Cases="+ numberOfStairCases + " can be :"+ + possibleStepCount_bottomUP);
    assertEquals(expectedCount, possibleStepCount_bottomUP);
  }

}