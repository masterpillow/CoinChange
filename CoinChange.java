import java.util.Arrays;

public class CoinChange {

    /**
     * Dynamic Programming coin change algorithm.
     * Finds the minimum number of coins needed to make the given amount.
     *
     * dp[i] represents the minimum number of coins needed to make amount i.
     * Use amount+1 as "infinity" — no valid solution needs more than amount coins.
     *
     * @param coins  array of coin denominations
     * @param amount target amount
     * @return minimum number of coins needed, or -1 if impossible
     */
    public static int DPCoinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];

        // Fill with "infinity" sentinel value
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for (int currentAmount = 1; currentAmount <= amount; currentAmount++) {
            for (int coin : coins) {
                if (coin <= currentAmount) {
                    dp[currentAmount] = Math.min(
                            dp[currentAmount],
                            dp[currentAmount - coin] + 1
                    );
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = {1, 5, 10, 25};
        int amount = 63;

        int result = DPCoinChange(coins, amount);
        System.out.println("Minimum coins needed: " + result);
    }
}