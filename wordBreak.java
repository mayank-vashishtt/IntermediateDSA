import java.util.Arrays;

public class wordBreak {

    int dp[]; 

    public boolean valid(String word , String[] words){

        for(String _word : words){
            if(word.equals(_word)){
                return true;
            }
        }

        return false;
    }
    public int f(int idx , String A, String[] B){

        if(idx == A.length()){
            return 1; 
        }

        if(dp[idx] != -1){
            return dp[idx];
        }

        String curWord = "";
        int ans = 0 ; 
        for(int i  = idx ; i<A.length() ; i++){

            curWord += A.charAt(i);
            if(valid(curWord,B)){
                ans = f(i + 1 , A, B);
                if(ans == 1){
                    break;
                }

            }
        }
        return dp[idx] = ans;
    }
    public int wordBreak(String A, String[] B) {

        dp = new int[A.length()];

        Arrays.fill(dp,-1);

        return f(0,A,B);
    }
}


