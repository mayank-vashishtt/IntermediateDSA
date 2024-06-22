public class stairs {
    static final int MOD = 1000000007;

    public int climbStairs(int A) {
        if (A <= 1) return 1;

        int[] dp = new int[A + 1];
        dp[0] = 1; // 1 way to reach step 0 (base case)
        dp[1] = 1; // 1 way to reach step 1 (base case)

        for (int i = 2; i <= A; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % MOD; // Apply modulo operation here
        }

        return dp[A];
    }
}
