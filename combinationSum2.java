import java.util.*;
public class combinationSum2 {
  


    public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>(); // for storing the results
        ArrayList<Integer> list = new ArrayList<>(); // temporary list to store the current combination

        Collections.sort(A); // Sort for efficient backtracking and lexicographic order

        solve(A, list, 0, B, ans, 0); // Start the recursion

        return ans;
    }

    private void solve(ArrayList<Integer> A, ArrayList<Integer> list, int sum, int B, ArrayList<ArrayList<Integer>> ans, int idx) {
        if (sum == B) {
            ans.add(new ArrayList<>(list)); // Add the current combination to the results
            return;
        }

        if (sum > B) {
            return; // If the sum exceeds B, no need to continue
        }

        for (int i = idx; i < A.size(); i++) {
            // Skip duplicates
            if (i > idx && A.get(i).equals(A.get(i - 1))) continue;

            list.add(A.get(i)); // Include A[i] in the current combination
            solve(A, list, sum + A.get(i), B, ans, i + 1); // Move to the next element
            list.remove(list.size() - 1); // Backtrack
        }
    }
}

