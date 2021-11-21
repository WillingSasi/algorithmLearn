package dynamicProgramming;

/**
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 * 1.暴力循环法，查找每个区间的最大利润
 * 2.动态规划，每天的两种状态持有和不持有股票，那点在写出动态规划递推公式
 * 3.动态规划增强版，只记录最大利润的数字，减少dp数组空间复杂度从N到1
 * 4.贪心算法，直接累加每天正利润的区间和
 * 5.贪心算法，从左开始，始终取最小，再计算右-左就是利润，始终记录最大利润
 */
public class StockProfit {

    public static void main(String[] args) {
        int[] prices = {7,1,2,3,1,8,2};
        System.out.println(StockProfit1(prices));
        System.out.println(StockProfit2(prices));
//        System.out.println(StockProfit3(prices));
        System.out.println(StockProfit4(prices));
        System.out.println(StockProfit5(prices));
    }

    /**
     *1.暴力循环法，查找每个区间的最大利润
     * @param prices
     * @return
     */
    public static int StockProfit1(int[] prices) {
        int len = prices.length;
        int maxProfit = 0;

        for (int i = 0;i < len-1;i++) {
            for (int j = 1;j < len;j++) {
                maxProfit = Math.max(maxProfit, prices[j]-prices[i]);
            }
        }

        return maxProfit;
    }

    /**
     *2.动态规划，每天的两种状态持有和不持有股票，那点在写出动态规划递推公式
     * 以后每天的利润其实都和前一天的状态有关，所以能一直回溯到第一天状态，也就是已知的数据
     * @param prices
     * @return
     */
    public static int StockProfit2(int[] prices) {
        int len = prices.length;
        //dp记录每天的利润，2中情况，当天不持有股票，当天持有股票，再细分情况, 0不持有，1持有
        int[][] dp = new int[len][2];

        //第1天不持有，就是还没买，那利润就是0
        dp[0][0] = 0;
        //第1天持有，就是刚买入，就是钱花了，此时没利润，还没了第一天的股票钱，所以记为负的
        dp[0][1] = -prices[0];

        for (int i = 1;i < len;i++) {
            //Math.max只记录当天能取得的最大利润，遍历完最后一天就是所能取得最大利润
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
            dp[i][1] = Math.max(-prices[i], dp[i-1][1]);
        }

        return Math.max(dp[len-1][0], 0);
    }

    /**
     * 3.动态规划增强版，只记录最大利润的数字，减少dp数组空间复杂度从N到1
     * @param prices
     * @return
     */
//    public static int StockProfit3(int[] prices) {
//        int len = prices.length;
//        //dp记录每天的利润，2中情况，当天不持有股票，当天持有股票，再细分情况, 0不持有，1持有
//        int[][] dp = new int[len][2];
//
//        //第1天不持有，就是还没买，那利润就是0
//        dp[0][0] = 0;
//        //第1天持有，就是刚买入，就是钱花了，此时没利润，还没了第一天的股票钱，所以记为负的
//        dp[0][1] = -prices[0];
//
//        for (int i = 1;i < len;i++) {
//            //Math.max只记录当天能取得的最大利润，遍历完最后一天就是所能取得最大利润
//            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
//            dp[i][1] = Math.max(-prices[i], dp[i-1][1]);
//        }
//
//        return Math.max(dp[len-1][0], 0);
//    }

    /**
     *4.贪心算法，直接累加每天正利润的区间和
     * @param prices
     * @return
     */
    public static int StockProfit4(int[] prices) {
        int len = prices.length;
        int i = 1;
        int j = len-1;
        int maxProfit = 0;

        while (i < j) {
            if ((prices[i] - prices[i-1]) <= 0) {
                i++;
            }else if ((prices[j] - prices[j-1]) <= 0) {
                j--;
            } else {
                break;
            }
        }

        while (i <= j) {
            maxProfit += prices[i] - prices[i-1];
            i++;
        }

        return Math.max(maxProfit, 0);
    }

    /**
     *5.贪心算法，从左开始，始终取最小，再计算右-左就是利润，始终记录最大利润
     * @param prices
     * @return
     */
    public static int StockProfit5(int[] prices) {
        int len = prices.length;
        int leftLow = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int i = 0;i < len;i++) {
            leftLow = Math.min(leftLow, prices[i]);
            maxProfit = Math.max(prices[i] - leftLow, maxProfit);
        }

        return maxProfit;
    }
}
