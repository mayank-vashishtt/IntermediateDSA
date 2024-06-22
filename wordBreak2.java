public class wordBreak2 {
    
    import java.util.*;


    List<String> ans = new ArrayList<>();
    HashMap<Integer, List<String>> memo = new HashMap<>();
    Set<String> wordDict;

    public List<String> f(int idx, String A) {
        if (idx == A.length()) {
            return Arrays.asList(""); // Return a list with an empty string
        }

        if (memo.containsKey(idx)) {
            return memo.get(idx);
        }

        List<String> result = new ArrayList<>();
        String curWord = "";

        for (int i = idx; i < A.length(); i++) {
            curWord += A.charAt(i);
            if (wordDict.contains(curWord)) {
                List<String> nextWords = f(i + 1, A);
                for (String next : nextWords) {
                    if (next.isEmpty()) {
                        result.add(curWord);
                    } else {
                        result.add(curWord + " " + next);
                    }
                }
            }
        }
        memo.put(idx, result);
        return result;
    }

    public String[] wordBreak(String A, String[] B) {
        wordDict = new HashSet<>(Arrays.asList(B));
        List<String> results = f(0, A);
        Collections.sort(results); // Ensure the results are sorted
        return results.toArray(new String[0]);
    }

}



/*
 * public class Solution 
{
    HashSet<String> dict = new HashSet<>();
    ArrayList<String> ans = new ArrayList<>();
    public ArrayList<String> wordBreak(String A, ArrayList<String> B) 
    {
        for(int i = 0; i<B.size(); i++)
        {
            dict.add(B.get(i));
        }
        
        f(0,A,"");
        return ans;
    }
    
    void f(int start, String A,String curr)
    {
        if(start == A.length())
        {
            ans.add(curr.trim());
            return;
        }
        
        for(int i = start; i<A.length(); i++)
        {
            String sub = A.substring(start,i+1);
            if(dict.contains(sub))
            {
                f(i+1,A,curr+" "+sub);
            }
        }
    }
}

 */
