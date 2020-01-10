package com.gg.dynamic;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class RecursiveStairCaseGeneralTest
{
  private static RecursiveStairCaseGeneral recursiveStairCase = new RecursiveStairCaseGeneral(Integer.MAX_VALUE);

  @BeforeAll
  static void setUpClass()
  {

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
    assertCountEquals(2, 1);
  }

  @Test
  void getPossibleStepCount_3()
  {
    assertCountEquals(3, 2); //
  }

  @Test
  void getPossibleStepCount_4()
  {
    assertCountEquals(4, 3); // 1+ 2
  }

  @Test
  void getPossibleStepCount_5()
  {
    assertCountEquals(5, 5);
  }

  @Test
  void getPossibleStepCount_6()
  {
    assertCountEquals(6, 8);
  }

  @Test
  void getPossibleStepCount_7()
  {
    assertCountEquals(7, 12);
  }

  @Test
  void getPossibleStepCount_8()
  {
    assertCountEquals(8, 19);
  }

  @Test
  void getPossibleStepCount_100()
  {
    assertCountEquals(100, 1838428683303202003L);
  }

  private void assertCountEquals(int numberOfStairCases, long expectedCount)
  {
    long possibleStepCount_bottomUP = recursiveStairCase.getPossibleStepCount_BottomUP(numberOfStairCases);
    System.out.println("[Bottom UP] possibleStepCount for number Of Stair Cases="+ numberOfStairCases + " can be :"+ + possibleStepCount_bottomUP);
    assertEquals(expectedCount, possibleStepCount_bottomUP);
  }
}