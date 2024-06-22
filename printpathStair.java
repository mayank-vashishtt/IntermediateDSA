import java.util.ArrayList;

public class printpathStair {
    

    public void generatePaths(int A, ArrayList<Integer> currentPath, ArrayList<ArrayList<Integer>> paths) {
        // Base case: if remaining steps is 0, add the current path to the list of paths
        if (A == 0) {
            paths.add(new ArrayList<>(currentPath));
            return;
        }

        // If remaining steps is positive, continue exploring paths
        if (A >= 1) {
            currentPath.add(1); // Take 1 step
            generatePaths(A - 1, currentPath, paths);
            currentPath.remove(currentPath.size() - 1); // Backtrack
        }
        if (A >= 2) {
            currentPath.add(2); // Take 2 steps
            generatePaths(A - 2, currentPath, paths);
            currentPath.remove(currentPath.size() - 1); // Backtrack
        }
    }

    public ArrayList<ArrayList<Integer>> WaysToClimb(int A) {

        ArrayList<ArrayList<Integer>> paths = new ArrayList<>();

        ArrayList<Integer> curpath = new ArrayList<>();


        generatePaths(A, curpath, paths);
        
        return paths;
    }
}

