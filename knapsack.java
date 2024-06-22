import java.util.Arrays;

public class knapsack {


    int[][] dp;

    public int f(int idx, int cur_wt, int[] cost,int[] wt, int max_wt ){

        if(idx == cost.length || cur_wt == max_wt){
            return 0 ;
        }

        if(dp[idx][cur_wt] != -1){
            return dp[idx][cur_wt];
        }

        // do not take this 
        int ans1 = f(idx + 1,cur_wt,cost,wt,max_wt);


        // try to take this 
        int ans2 = 0 ; 
        if(wt[idx] + cur_wt <= max_wt){
            ans2 = cost[idx] + f(idx + 1,cur_wt + wt[idx],cost,wt,max_wt);
        }

        return  dp[idx][cur_wt] = Math.max(ans1,ans2);
    }
    public int solve(int[] cost, int[] wt, int max_wt) {

        dp = new int[cost.length][max_wt + 1];

        for(int i =0 ; i<cost.length ; i++){
            Arrays.fill(dp[i], -1);
        }

        return f(0,0,cost,wt,max_wt);
    }
}

    
 