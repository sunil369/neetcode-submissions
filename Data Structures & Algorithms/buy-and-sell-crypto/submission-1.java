class Solution {
    public int maxProfit(int[] prices) {
        int res = 0;
        int maxPrice = prices[prices.length-1];
        for (int i=prices.length-2; i>=0; i--) {
            res = Math.max(res, maxPrice-prices[i]);
            maxPrice = Math.max(maxPrice,prices[i]);
        }
        return res;
    }
}
