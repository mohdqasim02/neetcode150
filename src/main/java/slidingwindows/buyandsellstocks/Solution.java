package slidingwindows.buyandsellstocks;

class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;

        int i = 0;
        int j = 1;

        while (i < j && j < prices.length) {
            if (prices[i] >= prices[j]) {
                i = j;
                j = i + 1;
            } else {
                maxProfit = Math.max(prices[j] - prices[i], maxProfit);
                j++;
            }
        }

        return maxProfit;
    }
}
