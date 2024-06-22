import java.util.Arrays;

public class editDistance {
    int[][] dp;
    public int f(int ptr1 , int ptr2 , String word1, String word2){

        if(ptr1 == word1.length()){
            // inserting remaning chr
            return word2.length() - ptr2;
        }

        if(ptr2 == word2.length()){
            // deleting remaning char
            return word1.length() - ptr1;
        }

        if(word1.charAt(ptr1) ==word2.charAt(ptr2)){
            return f(ptr1 + 1,ptr2 + 1,word1,word2);
        }

        if(dp[ptr1][ptr2] != -1){
            return dp[ptr1][ptr2];
        }
        // replace
        int ans1 = 1 + f(ptr1 + 1,ptr2 + 1,word1,word2);
        // insert
        int ans2 = 1 + f(ptr1,ptr2 + 1,word1,word2);
        // delete
        int ans3 = 1 + f(ptr1 + 1,ptr2,word1,word2);

        return dp[ptr1][ptr2] = Math.min(ans1,Math.min(ans2,ans3));
    }
    public int minDistance(String word1, String word2) {

        dp = new int[word1.length()][word2.length()];
        for(int i = 0 ; i< word1.length(); i++){
            Arrays.fill(dp[i],-1);
        }
        return f(0,0,word1,word2);
        
    }
}
    
