import java.util.ArrayList;

public class combination {


    public ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();


    public ArrayList<ArrayList<Integer>> combine(int A, int B) {
        // A is the last number and B is the size of the arr 

        ArrayList<Integer> curr = new ArrayList<Integer>();

        comb(1,A, B,curr);


        return ans;
    }



    public void comb(int i, int A, int B , ArrayList<Integer> curr){

        // solution condition 
        if(B==0){ 
            ans.add(new ArrayList<Integer>(curr));    
            return ;
        }

        if(i>A) return ;



        curr.add(i);
        comb(i+1,A,B-1,curr);

        curr.remove(curr.size()-1);
        comb(i+1,A,B,curr);
        
        return ;
    }
}
    

