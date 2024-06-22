import java.util.Arrays;

public class palidromePartioning {

    int[] dp;

    // Helper function to check if a string is a palindrome
    public boolean valid(String word) {
        int i = 0;
        int j = word.length() - 1;
        while (i <= j) {
            if (word.charAt(i) != word.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    // Recursive function to find the minimum cut needed
    public int f(int idx, String A) {
        if (idx == A.length()) {
            return 0;
        }

        if (dp[idx] != -1) {
            return dp[idx];
        }

        String curWord = "";
        int ans = Integer.MAX_VALUE;
        for (int i = idx; i < A.length(); i++) {
            curWord += A.charAt(i);
            if (valid(curWord)) {
                ans = Math.min(1 + f(i + 1, A), ans);
            }
        }
        return dp[idx] = ans;
    }

    // Main function to calculate the minimum cuts needed for palindromic partitioning
    public int minCut(String A) {
        dp = new int[A.length()]; // Correctly initialize dp array
        Arrays.fill(dp, -1); // Fill dp array with -1
        return f(0, A) - 1; // Subtract 1 to get the minimum cuts
    }
}

 
// string builder is better than string to optimise
