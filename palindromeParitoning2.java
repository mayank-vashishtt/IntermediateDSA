public class palindromeParitoning2 {
    import java.util.*;


    // Helper function to check if a string is a palindrome
    public boolean valid(String word) {
        int i = 0;
        int j = word.length() - 1;
        while (i <= j) {
            if (word.charAt(i) != word.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    // Recursive function to find all palindromic partitions starting from idx
    public void findPartitions(int idx, String a, List<String> current, List<List<String>> result) {
        if (idx == a.length()) {
            result.add(new ArrayList<>(current));
            return;
        }

        String curWord = "";
        for (int i = idx; i < a.length(); i++) {
            curWord += a.charAt(i);
            if (valid(curWord)) {
                current.add(curWord); // Choose
                findPartitions(i + 1, a, current, result); // Explore
                current.remove(current.size() - 1); // Unchoose
            }
        }
    }

    // Main function to return all possible palindromic partitions
    public ArrayList<ArrayList<String>> partition(String a) {
        List<List<String>> result = new ArrayList<>();
        findPartitions(0, a, new ArrayList<>(), result);

        // Convert List<List<String>> to ArrayList<ArrayList<String>>
        ArrayList<ArrayList<String>> finalResult = new ArrayList<>();
        for (List<String> partition : result) {
            finalResult.add(new ArrayList<>(partition));
        }
        return finalResult;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String a = "aab";
        ArrayList<ArrayList<String>> result = solution.partition(a);

        for (ArrayList<String> partition : result) {
            System.out.println(partition);
        }
        // Output: ["a", "a", "b"], ["aa", "b"]
    }
}


