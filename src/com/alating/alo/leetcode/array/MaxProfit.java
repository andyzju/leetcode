package com.alating.alo.leetcode.array;

/**
 * 买卖股票的最佳时期
 */
public class MaxProfit {


    /**
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {

        if(prices==null || prices.length==0){
            return 0;
        }

        int minPrice = Integer.MAX_VALUE;
        int maxProfit=Integer.MIN_VALUE;

        for(int i=0;i<prices.length;i++){

            if(prices[i]<minPrice){
                minPrice=prices[i];
            }

            if((prices[i]-minPrice)>maxProfit){
                maxProfit=prices[i]-minPrice;
            }
        }

        return maxProfit;

    }


}
