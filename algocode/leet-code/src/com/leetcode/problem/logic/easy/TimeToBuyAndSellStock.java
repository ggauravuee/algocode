package com.leetcode.problem.logic.easy;

public class TimeToBuyAndSellStock
{
  // Problem - Best Time to Buy and Sell Stock
  /*
  Say you have an array for which the ith element is the price of a given stock on day i.
  If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock),
  design an algorithm to find the maximum profit.

  Input: [7,2,1,5,3,6,4]
  Output: 5
  Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
             Not 7-1 = 6, as selling price needs to be larger than buying price.

   */
  public static void main (String[] args){

    TimeToBuyAndSellStock timeToBuyAndSellStock = new TimeToBuyAndSellStock();

    int[] stockPrices = {7,2,1,5,3,6,4};

    int maxProfit = timeToBuyAndSellStock.maxProfit(stockPrices);

    System.out.println(maxProfit);

    // 2nd
    int[] stockPrices2 = {7,2,1};
    maxProfit = timeToBuyAndSellStock.maxProfit(stockPrices2);
    System.out.println(maxProfit);

  }

  public int maxProfit(int[] prices) {
    if ( prices.length <2)
      //throw new IllegalArgumentException("Less than two transactions");
      return 0;

    int priceBuy = prices[0];
    int maxProfit = 0;

    int currentProfit;
    // check for max positive maxProfit
    for (int i = 1; i < prices.length; i++)
    {
      currentProfit = prices[i] - priceBuy;
      if (currentProfit > maxProfit){
        maxProfit = currentProfit;
      }

      if (prices[i] < priceBuy)
        priceBuy= prices[i];
    }
    return maxProfit;

  }

}
