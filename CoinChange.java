import java.util.Arrays;

public class CoinChange {

    /**
     * DP Coin Change (Bottom-Up)
     * min[0] = 0
     * min[i] = min(min[i - D[j]] + 1)
     * @param D array of coin denominations
     * @param n target amount
     * @return minimum number of coins, or -1 if impossible
     */
    public static int DPCoinChange(int[] D, int n) {

        int[] min = new int[n + 1];

        // initialize
        Arrays.fill(min, Integer.MAX_VALUE);
        min[0] = 0;

        // DP build
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < D.length; j++) {

                if (i >= D[j] && min[i - D[j]] != Integer.MAX_VALUE) {
                    int candidate = min[i - D[j]] + 1;

                    if (candidate < min[i]) {
                        min[i] = candidate;
                    }
                }
            }
        }

        // result
        if (min[n] == Integer.MAX_VALUE) {
            return -1;
        }

        return min[n];
    }

    public static void main(String[] args) {
        int[] D = {1, 5, 10, 22};
        int n = 45;

        int result = DPCoinChange(D, n);

        System.out.println("Minimum coins: " + result);
    }
}
