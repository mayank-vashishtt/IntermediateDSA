import java.util.Arrays;

public class houseRobber {


    int[] dp;

    public int f(int idx, int[] A){
        int n = A.length;

        if(idx >= n) return 0 ; 

        if(dp[idx] !=  -1){
            return dp[idx];
        }


        int ans1 = A[idx] + f(idx+2,A);
        
        int ans2 = f(idx+1,A);

        return dp[idx] =  Math.max(ans1,ans2);
    }
    public int solve(int[] A) {

        dp = new int[A.length];

        Arrays.fill(dp,-1);

        return f(0,A);
    }
}


