public class regularExpressMatch {
        // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
        public int isMatch(final String A, final String B) {
            int m = A.length();
            int n = B.length();
    
            // Initialize the dp array
            boolean[][] dp = new boolean[m + 1][n + 1];
            dp[0][0] = true; // Two empty strings match
    
            // Fill the first row of the dp array
            for (int j = 1; j <= n; j++) {
                if (B.charAt(j - 1) == '*') {
                    dp[0][j] = dp[0][j - 1]; // '*' can match an empty sequence
                }
            }
    
            // Fill the dp array using dynamic programming
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    if (A.charAt(i - 1) == B.charAt(j - 1) || B.charAt(j - 1) == '?') {
                        // Characters match or '?' matches any single character
                        dp[i][j] = dp[i - 1][j - 1];
                    } else if (B.charAt(j - 1) == '*') {
                        // '*' can match an empty sequence or one or more characters
                        dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                    }
                }
            }
    
            // Return 1 if the entire A matches B, 0 otherwise
            return dp[m][n] ? 1 : 0;
        }
    }
    

