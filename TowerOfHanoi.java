public class TowerOfHanoi {


    public static void toh(int n, char src , char des , char aux){

        if(n ==0 ) return ;


        toh(n-1, src, aux, des);
        System.out.println(src + "-->" + des);
        toh(n-1,aux,des,src);
    }

    public static void main(String[] args) {
        toh(2,'A','C','B');
    }

    /*
     * public class Solution {
    private List<int[]> moveList = new ArrayList<>();

    public int[][] towerOfHanoi(int A) {
        solveTowersOfHanoi(A, 1, 2, 3);
        int[][] ans = new int[moveList.size()][3];
        for (int i = 0; i < moveList.size(); i++) {
            ans[i] = moveList.get(i);
        }
        return ans;
    }

    private void solveTowersOfHanoi(int n, int start, int auxiliary, int end) {
        if (n == 1) {
            moveList.add(new int[]{n, start, end});
        } else {
            solveTowersOfHanoi(n - 1, start, end, auxiliary);
            moveList.add(new int[]{n, start, end});
            solveTowersOfHanoi(n - 1, auxiliary, start, end);
        }
    }}
     */



    
    
}
