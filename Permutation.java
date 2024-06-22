import java.util.*;
public class Permutation {

    int EMPTY_CELL = -11  ; 

    public void helper(int idx ,int[] nums,List<Integer> cur, List<List<Integer>> ans){
         
        if(idx == nums.length){
             ans.add(new ArrayList<>(cur));
             return;
        }
        int curValue = nums[idx];
        for(int i =0 ; i<cur.size(); i++){
             
            if(cur.get(i) == EMPTY_CELL){
                cur.set(i, curValue);
                helper(idx+1,nums,cur,ans);
                cur.set(i, EMPTY_CELL ); 
            }
        }

    }

    public List<List<Integer>> permute(int[] nums){
    
    
         List<List<Integer>> ans = new ArrayList<>();
         List<Integer> cur = new  ArrayList<>();
         int n = nums.length;

         for(int i = 0 ; i <n ; i++){
            cur.add(EMPTY_CELL); 
         }

         helper(0,nums,cur,ans);

         
         
    }
    
}


// for no duplicates
/* just use HashSet<ArrayList<Integer>> visited = new HashSet<>();
 * 
 * public class Solution {
    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        Collections.sort(A);  // Sort the ArrayList to handle duplicates
        boolean[] used = new boolean[A.size()];
        ArrayList<Integer> cur = new ArrayList<>();
        HashSet<ArrayList<Integer>> visited = new HashSet<>();
        
        backtrack(A, used, cur, ans, visited);
        
        return ans;
    }
    
    private void backtrack(ArrayList<Integer> A, boolean[] used, ArrayList<Integer> cur, ArrayList<ArrayList<Integer>> ans, HashSet<ArrayList<Integer>> visited) {
        if (cur.size() == A.size()) {
            if (!visited.contains(cur)) {
                ans.add(new ArrayList<>(cur));
                visited.add(new ArrayList<>(cur));
            }
            return;
        }
        
        for (int i = 0; i < A.size(); i++) {
            if (!used[i]) {
                used[i] = true;
                cur.add(A.get(i));
                backtrack(A, used, cur, ans, visited);
                cur.remove(cur.size() - 1);
                used[i] = false;
                
                // Skip duplicates
                while (i + 1 < A.size() && A.get(i).equals(A.get(i + 1))) {
                    i++;
                }
            }
        }
    }
    
 */