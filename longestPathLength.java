public class longestPathLength {
        int maxLength;
    
        // Recursive function to find the longest increasing path
        public int f(int row, int col, int[][] A, int count) {
            
            if (row == A.length - 1 && col == A[0].length - 1) {
                maxLength = Math.max(maxLength, count + 1);
                return 1;
            }
    
            boolean foundValidPath = false;
    
            // Moving down
            if (row + 1 < A.length && A[row][col] < A[row + 1][col]) {
                foundValidPath = true;
                f(row + 1, col, A, count + 1);
            }
    
            // Moving right
            if (col + 1 < A[0].length && A[row][col] < A[row][col + 1]) {
                foundValidPath = true;
                f(row, col + 1, A, count + 1);
            }
    
            return foundValidPath ? 1 : 0;
        }
    
        public int solve(int[][] A) {
            maxLength = 0;
            // Start the recursion from the top-left cell
            f(0, 0, A, 0);
    
            // If maxLength remains 0, there was no valid path, so return -1
            return maxLength == 0 ? -1 : maxLength;
        }
    }
    

