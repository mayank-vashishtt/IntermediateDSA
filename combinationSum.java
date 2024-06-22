import java.util.ArrayList;
import java.util.Collections;

public class combinationSum {
    

    public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B) {
    
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>(); // for storing ans we made an array 

        ArrayList<Integer> list = new ArrayList<>(); // the empty list of all times 

        ArrayList<Integer> U = new ArrayList<>(); // U will be the original list after removing duplicate values 

        Collections.sort(A); // Sort for efficient backtracking and lexicographic order
        
        U.add(A.get(0));
        
        for(int i =0; i<A.size(); i++){
            if(i !=0 && A.get(i) != A.get(i-1)){
                U.add(A.get(i));
            }
        }
        // above loop is for removing the duplicate values 


        solve(U, list, 0, B, ans,0); // recusrion is called 


        return ans;
    }

    private void solve(ArrayList<Integer> A, ArrayList<Integer> list, int sum, int B, ArrayList<ArrayList<Integer>> ans, int j) {

        // A is the original list here, List is one that we have to fill and j is the idx , and ans is where we have to put on 




        // solution condn or base condn

        if (sum == B) {
            ans.add(new ArrayList<>(list)); // learn this way to put on the arraylist<>(list)
            return;
        }

        if (sum > B || A.isEmpty()) { 
            return;
        }


// choice condition below 
        for (int i = j; i < A.size(); i++) { 
            // Start from 0 for each iteration (no skipping)
            list.add(A.get(i));
            solve(A, list, sum + A.get(i), B, ans,i); // Recursive call with updated sum
            list.remove(list.size() - 1); // Backtrack (remove the last element)
        }
    }
}
    
