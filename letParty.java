import java.util.Arrays;

public class letParty {
    

    int mod = 10003;
    int[] dp;

    public int f(int A){

        if(A<=2){
            return A;
        }

        if(dp[A] != -1){
            return dp[A];
        }

        int ans1 = f(A-1);

        int ans2 = (A-1)%mod * f(A-2);

        return dp[A] = (ans1 + ans2)%mod;
    }

    public int solve(int A) {
        dp = new int[A+1];
        Arrays.fill(dp,-1);

        return f(A);


    }
}


