import java.util.*;

public class generateParathesis {
    // ig opening bracket == closing bracket on left, it means we cant keep closing bracket

    void helper(int openCount, int closeCount, StringBuilder cur, List<String> ans){

        if(openCount == 0  && closeCount == 0){
            ans.add(cur.toString());
            return; 
        }
        // lets place an opening bracket
        if(openCount> 0){
            cur.append('(');
            helper(openCount-1,closeCount ,cur,ans); 
            cur.deleteCharAt(cur.length() -1 );

        }

        // place an closing bracket 
        if(closeCount > openCount){
            cur.append(')');
            helper(openCount,closeCount -1 ,cur,ans); 
            cur.deleteCharAt(cur.length() -1 );

        }


    }

    public List<String> generateParathesis(int n){
        List<String> ans = new ArrayList<>(); 
        StringBuilder cur  = new StringBuilder();

        helper(n,n,cur,ans); 

        return ans; 


    }
}
