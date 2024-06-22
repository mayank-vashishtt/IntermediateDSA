import java.util.Arrays;

public class coinsuminfinite {




    int[][] dp;
    int MOD = 1000007; // Define the MOD value for large results

    public int f(int idx, int cur_value, int[] coin, int max_value) {
        if (cur_value == max_value) {
            return 1; // Found a valid combination
        }

        if (idx == coin.length) {
            return 0; // Reached the end of the coin array
        }

        if (dp[idx][cur_value] != -1) {
            return dp[idx][cur_value];
        }

        // Do not take this coin
        int ans1 = f(idx + 1, cur_value, coin, max_value) % MOD;

        // Try to take this coin
        int ans2 = 0;
        if (coin[idx] + cur_value <= max_value) {
            ans2 = f(idx, cur_value + coin[idx], coin, max_value) % MOD;
        }

        return dp[idx][cur_value] = (ans1 + ans2) % MOD;
    }

    public int coinchange2(int[] coin, int max_value) {
        dp = new int[coin.length][max_value + 1];

        for (int i = 0; i < coin.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        return f(0, 0, coin, max_value);
    }
}

    

