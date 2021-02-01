package Arrays;

/*
给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。

示例 1:
输入: [7,1,5,3,6,4]
输出: 7
解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
     随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。

示例 2:
输入: [1,2,3,4,5]
输出: 4
解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
     注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。
     因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。

示例 3:
输入: [7,6,4,3,1]
输出: 0
解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 */

public class BuyAndSellStocks {

    public static void main(String[] args) {
        int[] prices1 = {7, 1, 5, 3, 6, 4};
        int[] prices2 = {1, 2, 3, 4, 5};
        int[] prices3 = {7, 6, 4, 3, 1};
//        System.out.println(maxProfit(prices1));
//        System.out.println(maxProfit(prices2));
//        System.out.println(maxProfit(prices3));
//
//        System.out.println(maxProfit2(prices1));
//        System.out.println(maxProfit2(prices2));
//        System.out.println(maxProfit2(prices3));

        System.out.println(maxProfit(prices1));
        System.out.println(maxProfit2(prices1));
        System.out.println(maxProfit3(prices1));
        System.out.println(maxProfit4(prices1));
        System.out.println(maxProfit5(prices1));
    }

    //可以允许多次交易
    public static int maxProfit(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }
        //最低价格
        int low = prices[0];
        //利润值
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > low) {
                maxProfit += (prices[i] - low);
            }
            low = prices[i];
        }
        return maxProfit;
    }

    //只允许一次交易 动态规划
    public static int maxProfit2(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }
        //最低价格
        int low = prices[0];
        //利润值
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > low) {
                if (maxProfit < prices[i] - low) {
                    maxProfit = prices[i] - low;
                }
            } else {
                low = prices[i];
            }
        }
        return maxProfit;
    }

    //暴力解题
    public static int maxProfit3(int prices[]) {
        int maxprofit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int profit = prices[j] - prices[i];
                if (profit > maxprofit) {
                    maxprofit = profit;
                }
            }
        }
        return maxprofit;
    }


    //分治算法
    public static int maxProfit4(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int[] priceChange = new int[prices.length - 1];
        for (int i = 1; i < prices.length; i++) {
            priceChange[i - 1] = prices[i] - prices[i - 1];
        }
        return Math.max(findMaxSub(priceChange, 0, priceChange.length - 1), 0);
    }

    private static int findMaxSub(int[] priceChange, int left, int right) {
        if (left == right) {
            return priceChange[left];
        }
        int mid = (left + right) / 2;
        int maxCrossingSub = findMaxCrossingSub(priceChange, left, right, mid, mid + 1);
        int maxLeftSub = findMaxSub(priceChange, left, mid);
        int maxRightSub = findMaxSub(priceChange, mid + 1, right);
        return Math.max(maxCrossingSub, Math.max(maxLeftSub, maxRightSub));
    }

    private static int findMaxCrossingSub(int[] priceChange, int leftBound, int rightBound, int leftStart, int rightStart) {
        int leftSum = 0, maxLeftSum = Integer.MIN_VALUE;
        for (int i = leftStart; i >= leftBound; i--) {
            leftSum += priceChange[i];
            maxLeftSum = Math.max(leftSum, maxLeftSum);
        }
        int rightSum = 0, maxRightSum = Integer.MIN_VALUE;
        for (int i = rightStart; i <= rightBound; i++) {
            rightSum += priceChange[i];
            maxRightSum = Math.max(rightSum, maxRightSum);
        }
        return maxLeftSum + maxRightSum;
    }

    //动态规划
    public static int maxProfit5(int[] prices) {
        int len = prices.length;
        // 特殊判断
        if (len < 2) {
            return 0;
        }
        int[][] dp = new int[len][2];

        // dp[i][0] 下标为 i 这天结束的时候，不持股，手上拥有的现金数
        // dp[i][1] 下标为 i 这天结束的时候，持股，手上拥有的现金数

        // 初始化：不持股显然为 0，持股就需要减去第 1 天（下标为 0）的股价
        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        // 从第 2 天开始遍历
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
        }
        return dp[len - 1][0];
    }
}
