import java.util.Arrays;

public class minimumPath {
    

    int[][] dp ;
    public int f(int row, int col , int[][] grid){

        if(row == grid.length - 1  && col == grid[0].length -1){
            return grid[row][col];
        }

        if (dp[row][col] != -1){
            return dp[row][col];
        }

        // right
        int ans1 = Integer.MAX_VALUE;
        if(col + 1 < grid[0].length){
            ans1 = f(row,col+1,grid);

        }

        // down
        int ans2 = Integer.MAX_VALUE;
        if(row + 1<grid.length){
            ans2 = f(row+1,col,grid);

        }

        return dp[row][col] = grid[row][col] + Math.min(ans1,ans2);
    }
    public int minPathSum(int[][] grid) {

        dp = new int[grid.length][grid[0].length];

        for(int i =0 ; i<grid.length ; i++){
            Arrays.fill(dp[i],-1);
        }

        return f(0,0,grid);
        
    }
}
