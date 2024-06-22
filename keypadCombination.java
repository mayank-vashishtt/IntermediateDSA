import java.util.*;

public class keypadCombination {

    String[] choices = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};


    public void helper(int idx, String digits,StringBuilder cur,List<String> ans ){


        if(idx == digits.length()){
            ans.add(cur.toString());
            // tostring do deep copy itself  
            return;

             
        }
        int curNum = digits.charAt(idx) - '0'; // convert char to num
         
        for(int i =0 ; i <choices[curNum].length() ; i ++){
              cur.append(choices[curNum].charAt(i));
              helper(idx + 1,digits,cur,ans);
              cur.deleteCharAt(cur.length() - 1);
            

        }

    }
    public List<String> letterCombination(String digits){

        StringBuilder cur = new StringBuilder();

        List<String> ans = new ArrayList<>();

        if(digits.length() == 0) return ans;

        helper(0,digits,cur,ans); 
        return ans;

    }

    
}
