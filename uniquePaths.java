import java.util.Arrays;

public class uniquePaths {


    int[][] dp ; 
    public int f(int row, int col, int m, int n){

        if(row == m -1 && col == n -1){
            return 1; 
        }

        if(dp[row][col] != -1){
            return dp[row][col];
        }


        
        int ans1 = 0 ;
        int ans2 = 0 ;
        // down
        if(row + 1 < m){
            ans1 = f(row + 1, col , m , n);
        }

        // right
       
        if(col + 1 < n){
            ans2 = f(row, col + 1 , m , n);
        }

        return dp[row][col] = ans1 + ans2; 
    }

    public int uniquePaths(int m, int n) {

        dp = new int[m][n];

        for(int i =0 ; i<m ; i++){
            Arrays.fill(dp[i],-1);
        }

        return f(0,0,m,n);
        
    }
}


// for obstacle one
/*
 *  if (row >= m || col >= n || obstacleGrid[row][col] == 1) {
            return 0;
        } this base case and in every codn == 0 
 */
