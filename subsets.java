import java.util.*;
public class subsets {


    public void helper( int idx , int[] nums , ArrayList<Integer> cur, List<List<Integer>> ans){

        if(idx == nums.length){
            // add curr to ans list 
            // ans.add(cur);
            // above is the shallow copy, but we need a deep copy

            ans.add(new ArrayList<>(cur));
            return;


        }

        // do not take this
        helper(idx + 1, nums, cur , ans);

        // take this 
        cur.add(nums[idx]);
        helper(idx+ 1, nums, cur, ans);
        cur.remove(cur.size() - 1);

    }

    public List<List<Integer>> subsets(int[] nums){

        List<List<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> cur = new ArrayList<>();
         
        helper(0, nums, cur , ans);

        return ans; 
    }
} 


/*
 * 
 * public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> cur = new ArrayList<>();

        // Sort the input array to ensure non-descending order in subsets
        Collections.sort(A);

        // Generate all subsets
        helper(0, A, cur, ans);

        // Sort the list of subsets lexicographically
        Collections.sort(ans, (o1, o2) -> {
            int n = Math.min(o1.size(), o2.size());
            for (int i = 0; i < n; i++) {
                if (!o1.get(i).equals(o2.get(i))) {
                    return o1.get(i) - o2.get(i);
                }
            }
            return o1.size() - o2.size();
        });

        return ans;
    }
 */
