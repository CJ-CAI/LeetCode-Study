/**
 * 最大利润
 *
 * @author CJ_CA
 * @date 2023/08/17
 */
public class maxProfit {
    public static void main(String[] args) {
        int[] prices = new int[]{7, 2, 5, 3, 6, 1};
        int MaxProfit = 0, MinPrice = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < MinPrice) {
                MinPrice = prices[i];
            } else if (prices[i] - MinPrice > MaxProfit) {
                MaxProfit = prices[i] - MinPrice;
            }
        }
        System.out.println(MaxProfit);
    }
}
