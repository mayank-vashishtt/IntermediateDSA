public class sudoku {




    public void solveSudoku(ArrayList<ArrayList<Character>> a) {
        char[][] board = new char[9][9];
        
        // Convert ArrayList<ArrayList<Character>> to char[][]
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                board[i][j] = a.get(i).get(j);
            }
        }
        
        solve(board);
        
        // Convert char[][] back to ArrayList<ArrayList<Character>>
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                a.get(i).set(j, board[i][j]);
            }
        }
    }

    private boolean solve(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {

                    for (char c = '1'; c <= '9'; c++) {
                        if (isValid(board, i, j, c)) {
                            board[i][j] = c;

                            if (solve(board))
                                return true;
                            else
                                board[i][j] = '.';
                        }
                    }

                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValid(char[][] board, int row, int col, char c) {
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == c)
                return false;

            if (board[row][i] == c)
                return false;

            if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c)
                return false;
        }
        return true;
    }
}



// if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c)
//return false;
    

/*
 * import java.util.*;

public class Solution 
{
	public void solveSudoku(char[][] A) 
    {
        f(0,0,A);
	}
	
	boolean f(int r, int c, char [][] A)
	{
	    if(r == 9)
	    {
	        return true;
	    }
	    
	    if(c==9)
	    {
	        return f(r+1,0,A);
	    }
	    
	    if(A[r][c] != '.')
	    {
	        return f(r,c+1,A);
	    }
	    
	    for(char i = '1'; i<='9'; i++)
	    {
	        if(isValid(r,c,i,A))
	        {
	            A[r][c] = i;
	            if(f(r,c+1,A))
	            {
	                return true;
	            }
	            A[r][c] = '.';
	        }
	    }
	    return false;
	}
	
	boolean isValid(int r,int c,char val, char[][]A)
	{
	    for(int i = 0; i<A.length; i++)
	    {
	        if(A[i][c] == val)
	        {
	            return false;
	        }
	        if(A[r][i] == val)
	        {
	            return false;
	        }
	    }
	    
	    int startRow = r/3*3;
	    int startCol = c/3*3;
	    
	    for(int i = startRow; i<startRow+3; i++)
	    {
	        for(int j = startCol; j<startCol+3; j++)
	        {
	            if(A[i][j] == val)
	            {
	                return false;
	            }
	        }
	    }
	    
	    return true;
	}
}

 */