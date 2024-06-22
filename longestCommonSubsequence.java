import java.util.Arrays;

public class longestCommonSubsequence {


    int[][] dp;
    public int f(int ptr1, int ptr2,String text1,String text2 ){

        if(ptr1 == text1.length() || ptr2 == text2.length()){
            return 0; 
        }

        if(text1.charAt(ptr1) == text2.charAt(ptr2)){
            return 1 + f(ptr1 + 1,ptr2+1,text1,text2);
        }

        if(dp[ptr1][ptr2] != -1){
            return dp[ptr1][ptr2];
        }
        int ans1 = f(ptr1 + 1,ptr2,text1,text2);
        int ans2 = f(ptr1,ptr2 + 1,text1,text2); 

        return dp[ptr1][ptr2] = Math.max(ans1,ans2);
    }
    public int longestCommonSubsequence(String text1, String text2) {
        dp = new int[text1.length()][text2.length()];

        for(int i =0 ; i<text1.length() ; i++){
            Arrays.fill(dp[i],-1);
        }
        return f(0,0,text1,text2);
        
    }
}
    

