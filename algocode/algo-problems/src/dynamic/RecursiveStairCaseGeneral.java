package dynamic;

public class RecursiveStairCaseGeneral
{
  // X = {1, 3,5} user can take any step in X and total steps are N
  private final int[] possibleStepSizes = {1,3,5};

  private int maxNumberOfStairCases;
  private long[] memoizeValues;

  public RecursiveStairCaseGeneral(int maxNumberOfStairCases)
  {
    if (maxNumberOfStairCases <=0) throw new IllegalArgumentException("Stair case should have at least steps.");
    this.maxNumberOfStairCases = maxNumberOfStairCases;
  }

  // non recursive - dynamic programming
  public long getPossibleStepCount_BottomUP(int numberOfStairCases)
  {
    if (numberOfStairCases <= 0) throw new IllegalArgumentException("Stair case should has at least one step.");

    if (numberOfStairCases > maxNumberOfStairCases)
      throw new IllegalArgumentException("Stair case stepCounts is more than max stepCounts:" + maxNumberOfStairCases);

    // boundary conditions
    if (numberOfStairCases == 1) return 1;
    if (numberOfStairCases == 2) return 1;
    if (numberOfStairCases == 3) return 2;

    long[] stepCounts = new long[numberOfStairCases +1]; // index 0 is non used
    stepCounts[0] = 1;
    stepCounts[1] = 1;
    stepCounts[2] = 1;
    stepCounts[3] = 2;

    if (numberOfStairCases >= 4) {
      stepCounts[4] = stepCounts[4 -1] + stepCounts[4-3];
    }

    if (numberOfStairCases >= 5) {
      stepCounts[5] = stepCounts[5 -1] + stepCounts[5-3] + 1; // or + stepCounts[5-5]
    }

    for (int i = 6; i <= numberOfStairCases; i++)
    {
      stepCounts[i] = stepCounts[i-1] + stepCounts[i-3] + stepCounts[i-5];
    }

    return stepCounts[numberOfStairCases];

  }
}
