public class mcm {
        public int solve(int[] A) {
            int n = A.length;
            int[][] m = new int[n][n];
            int i, j, k, L, q;
            for (i = 1; i < n; i++)
                m[i][i] = 0;
            for (L = 2; L < n; L++) {
                for (i = 1; i < n - L + 1; i++) {
                    j = i + L - 1;
                    m[i][j] = Integer.MAX_VALUE;
                    // try to divide at every i<=k<=j-1 
                    for (k = i; k <= j - 1; k++) {
                        q = m[i][k] + m[k + 1][j] + A[i - 1] * A[k] * A[j];
                        if (q < m[i][j])
                            m[i][j] = q;
                    }
                }
            }
            return m[1][n - 1];
        }
    }
    
/*
 * class TUF{
static int f(int arr[], int i, int j, int[][] dp){
    
    // base condition
    if(i == j)
        return 0;
        
    if(dp[i][j]!=-1)
        return dp[i][j];
    
    int mini = Integer.MAX_VALUE;
    
    // partioning loop
    for(int k = i; k<= j-1; k++){
        
    int ans = f(arr,i,k,dp) + f(arr, k+1,j,dp) + arr[i-1]*arr[k]*arr[j];
        
    mini = Math.min(mini,ans);
        
    }
    
    return mini;
}


static int matrixMultiplication(int[] arr, int N){
    
    int dp[][]= new int[N][N];
    
    for(int row[]:dp)
    Arrays.fill(row,-1);
    
    int i =1;
    int j = N-1;
    
    
    return f(arr,i,j,dp);
    
    
}
 */
