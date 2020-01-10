package com.leetcode.problem.logic.medium;

/*
PROBLEM: - Decode Ways

https://leetcode.com/problems/decode-ways/
A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Given a non-empty string containing only digits, determine the total number of ways to decode it.

Example 1:

Input: "12"
Output: 2
Explanation: It could be decoded as "AB" (1 2) or "L" (12).
Example 2:

Input: "226"
Output: 3
Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
 */

public class DecodeWays
{

  // non recursive - dynamic program
  public int numDecodings_bottomup(String s) {
    long startTimeMillis = System.currentTimeMillis();
    int[] memo = new int[s.length() +1]; // index 0 is not used
    memo[0] = 0;

    if(s.length() >1) {
      memo[1] = 1;
    }

    int result = numDecodings_bottomup(s, s.length(), memo);
    System.out.println("Execution time for input :" + s + " is :" + (System.currentTimeMillis() - startTimeMillis) );
    return result;
  }

  private int numDecodings_bottomup(String s, int marker, int[] memo)
  {
    if (s == null || s.isEmpty()) return 1; // ? base condition

    //s = s.trim();
    //01 0r 0 -> result =0

    if (s.startsWith("0")) return 0;
    if (s.length() ==1) return 1;

    if (memo[marker] !=0) return memo[marker];

    int length = s.length();
    if (length == 1) return 1;

    String firstTwoDigits = s.substring(0, 2);
    // TBD
    // 27124 -> 2 + 7124
    if (firstTwoDigits.compareTo("26") > 0)
    {
      memo[marker] = numDecodings_bottomup(s.substring(1, length), length-1,memo );
      return memo[marker];
    }
    else
    {
      // 26124
      memo[marker] = numDecodings_bottomup(s.substring(1, length), length-1,memo )
              + numDecodings_bottomup(s.substring(2, length), length-2,memo );
      return numDecodings(s.substring(1, length)) + numDecodings(s.substring(2, length));
    }
  }

  // ========== Efficient dynamic programming code - less time and space ==================
  // ====================================================================
  public int numDecoding_DP_Efficient(String s){
    if (s == null ||s.isEmpty()) return 1;

    char[] chars = s.toCharArray();
    int length = chars.length;
    if (chars[0] == '0') return 0;

    int lookupArray[] = new int[ length + 1];
    lookupArray[0] = 1;
    lookupArray[1] = chars[0] =='0' ? 0 : 1; // 01 -> 0

    for (int i = 2; i <= length; i++)
    {

      char first = chars[i-2] ;
      char second = chars[i-1] ;

      lookupArray[i] = lookupArray[i-1];
      if (first == 1 || ( first ==2 && second < '7')){
        lookupArray[i] += lookupArray[i-2];
      }
      // what if first is '0'

    }

    return lookupArray[length];

    /*    char[] cs = s.toCharArray();
    if(cs[0]=='0')
      return 0;
    int[] dp = new int[cs.length+1];
    dp[0]=1;
    dp[1]=1;
    for(int i=2;i<dp.length;i++){
      if(cs[i-2]=='0'&&cs[i-1]=='0')
        return 0;
      if(cs[i-1]=='0'&&cs[i-2]>'2')
        return 0;
      else if(cs[i-1]=='0')
        dp[i]=dp[i-2];
      else if(cs[i-2]=='0')
        dp[i]=dp[i-1];
      else if((cs[i-2]-'0')*10+(cs[i-1]-'0')<=26)
        dp[i]=dp[i-1]+dp[i-2];
      else
        dp[i]=dp[i-1];
    }
    return dp[dp.length-1];*/
  }

  //  ---------------- Recursive -----------
  public int numDecodings(String s)
  {
    if (s == null || s.isEmpty()) return 1; // ?

    //s = s.trim();
    //01 0r 0 -> result =0

    if (s.startsWith("0")) return 0;

    if (s.length() == 1) return 1;

//    if(s.equals("10")) return 1;

/*    if(s.length() == 2){
      // 10, 110,230
      if (s.endsWith("0")) return 1;
      // 12 or 27
      if (s.compareTo("26") > 0)
      {
        return 1;
      }
      else
      {
        return 2;
      }
    }*/

    String firstTwoDigits = s.substring(0, 2);
    // TBD
    // 27124 -> 2 + 7124
    if (firstTwoDigits.compareTo("26") > 0)
    {
      return numDecodings(s.substring(1, s.length()));
    }
    else
    {
      // 26124
      return numDecodings(s.substring(1, s.length())) + numDecodings(s.substring(2, s.length()));
    }
  }

}
