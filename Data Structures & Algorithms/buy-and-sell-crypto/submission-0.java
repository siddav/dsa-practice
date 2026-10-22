class Solution {
    public int maxProfit(int[] prices) {
        int min_so_far = prices[0];
        int profit = 0;
        for(int i=1;i<prices.length;i++) {
            min_so_far = Math.min(min_so_far, prices[i]);
            profit = Math.max(profit, prices[i] - min_so_far);
        }
        return profit;
    }
}
