import java.util.Arrays;

public class interleavingStrings {


    int[][] dp;

    public int f(int idx1, int idx2, int idx3, String A, String B, String C) {
        if (idx3 == C.length()) {
            return (idx1 == A.length() && idx2 == B.length()) ? 1 : 0;
        }

        if (idx1 < A.length() && idx2 < B.length() && dp[idx1][idx2] != -1) {
            return dp[idx1][idx2];
        }

        int ans1 = 0;
        if (idx1 < A.length() && A.charAt(idx1) == C.charAt(idx3)) {
            ans1 = f(idx1 + 1, idx2, idx3 + 1, A, B, C);
        }

        int ans2 = 0;
        if (idx2 < B.length() && B.charAt(idx2) == C.charAt(idx3)) {
            ans2 = f(idx1, idx2 + 1, idx3 + 1, A, B, C);
        }

        if (idx1 < A.length() && idx2 < B.length()) {
            dp[idx1][idx2] = ans1 | ans2;
        }

        return ans1 | ans2;
    }

    public int isInterleave(String A, String B, String C) {
        dp = new int[A.length() + 1][B.length() + 1]; // Correct dimensions

        for (int i = 0; i <= A.length(); i++) {
            Arrays.fill(dp[i], -1);
        }

        return f(0, 0, 0, A, B, C);
    }
}


