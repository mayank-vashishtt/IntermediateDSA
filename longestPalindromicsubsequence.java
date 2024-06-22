public class longestPalindromicsubsequence {

        public int solve(String A) {
            int n = A.length();
            int[][] dp = new int[n][n];
    
            // Single character is a palindrome of length 1
            for (int i = 0; i < n; i++) {
                dp[i][i] = 1;
            }
    
            // Build the dp table
            for (int length = 2; length <= n; length++) {
                for (int i = 0; i <= n - length; i++) {
                    int j = i + length - 1;
                    if (A.charAt(i) == A.charAt(j)) {
                        dp[i][j] = dp[i + 1][j - 1] + 2;
                    } else {
                        dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                    }
                }
            }
    
            // The length of the longest palindromic subsequence in A
            return dp[0][n - 1];
        }
    
       
    }
    

