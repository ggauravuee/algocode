package dynamic;

public class RecursiveStairCase
{
  private int maxNumberOfStairCases = Integer.MAX_VALUE;
  private long[] memoizeValues;

  public RecursiveStairCase(int maxNumberOfStairCases)
  {
    if (maxNumberOfStairCases <=0) throw new IllegalArgumentException("Stair case should have at least steps.");
    this.maxNumberOfStairCases = maxNumberOfStairCases;

    // TBD - can be moved to init method
    this.memoizeValues =  new long[maxNumberOfStairCases + 1]; // index 0 value is not used at all

    this.memoizeValues[0] = 0; // not used
    this.memoizeValues[1] = 1;

    if (maxNumberOfStairCases >1) this.memoizeValues[2] = 2;
  }

  //  recursive
   public long getPossibleStepCount(int numberOfStairCases)
   {
     if (numberOfStairCases == 0) throw new IllegalArgumentException("Stair case can't have zero steps.");

     if (numberOfStairCases > maxNumberOfStairCases)
       throw new IllegalArgumentException("Stair case count is more than max count:" + maxNumberOfStairCases);

     if (numberOfStairCases == 1) return 1;
     if (numberOfStairCases == 2) return 2;

//     return  memoizeValues[numberOfStairCases] =  memoizeValues[numberOfStairCases -1] + memoizeValues[numberOfStairCases -2];
//     if (memoizeValues[numberOfStairCases] == 0)
       return getPossibleStepCount(numberOfStairCases -1)
             + getPossibleStepCount(numberOfStairCases - 2);
/*
     else
       return memoizeValues[numberOfStairCases];*/
   }

  // non recursive - dynamic programming
  public long getPossibleStepCount_BottomUP(int numberOfStairCases)
  {
    if (numberOfStairCases == 0) throw new IllegalArgumentException("Stair case can't have zero steps.");

    if (numberOfStairCases > maxNumberOfStairCases)
      throw new IllegalArgumentException("Stair case stepCounts is more than max stepCounts:" + maxNumberOfStairCases);

    if (numberOfStairCases == 1) return 1;
    if (numberOfStairCases == 2) return 2;

    long[] stepCounts = new long[numberOfStairCases +1]; // index 0 is non used
    stepCounts[0] = 0l;
    stepCounts[1] = 1l;
    stepCounts[2] = 2l;

    for (int i = 3; i <= numberOfStairCases; i++)
    {
      stepCounts[i] = stepCounts[i-1] + stepCounts[i-2];
    }

    return stepCounts[numberOfStairCases];

  }
}
