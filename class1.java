import java.util.*;


// basic recursion 



class class1{

    
    public int sum(int n){
        if(n == 0){
            return 0 ;
        }
        return n + sum(n-1);
    }

    public void nTimesHello(int n){
        if(n==0){
            return;
        }
        nTimesHello(n-1);
        System.out.println("Hello" + n);
    }

    public int sumOfDigit(int n){
        if(n==0){
            return 0;
        }
        return n%10 + sumOfDigit(n/10);
    }

    public int factorial(int n){
        if(n <= 1){
            return 1;
        } 
        return n * factorial(n-1);
    }



    // Pattern Printing 

    public static void printPattern(int n){

        if(n ==0) return ;

        printPattern(n-1);
        for(int i = 1 ; i<=n ; i++){
            System.out.print (i + " ");
        }
        System.out.println();
    }

    public static void printPatternReverse(int n){

        if(n ==0) return ;
       
        for(int i = 1 ; i<=n ; i++){
            // System.out.print(i + ' '); will print ascii value from 33
            System.out.print(i + "  ");

        }
        System.out.println();
        printPatternReverse(n-1);
    }

    public static void printDiamondCutHalf(int n){

        if(n == 1){
            System.out.println(1) ;
            return;
        }

        for(int i =1  ; i<=n ; i++){
            System.out.print(i + " ");
        }
        System.out.println();

        printDiamondCutHalf(n-1);

        for(int i =1  ; i<=n ; i++){
            System.out.print(i + " ");
        }
        System.out.println( );
    }

    public static int power(int x, int n){
        if(n == 0) return 1;
        return x * power(x, n-1);  
        //--  TC -- O(N)
    }

    // 1<= x <= 1e9
    // 1<= n <= 1e18
    // mod = 1e9 + 7 
    public static int fastPower(int x, int n,int mod){
        if(n == 0) return 1 ; 

        if(n%2 == 0 ){
            long  halfAnswer = fastPower(x, n/2,mod); // no mod required 
            return (int) (halfAnswer* halfAnswer)%mod; 
        }

        return (int)((fastPower(x, n-1,mod) * (long)x )%mod); 
        //TC -- O(logN)

    }

    // 1 + 2 + 3 + 4 + 5 + 6 + 7 + ..... + n % mod
    // 1<= <= 1e9
    public static int f(int n, int mod){
        int ans = (int) (((long)n *(n+1))/2) % mod;
        return ans;
    }

    // 1 * 2 * 3 * 4 * ..... * n % mod 
    public static int fa(int n,int mod){
        long ans =  1; 
        for(int i =1 ; i<=n ; i++){
            ans = (ans * i ) % mod;
        }
        return (int) ans;
    }

    // if a string is palindrome or not 

    public static boolean  helper(String s, int startIdx , int endIdx){
        // empty string of size one is always a palindrome 
        if(startIdx>= endIdx){
            return true;
        }
        if(s.charAt(startIdx) != s.charAt(endIdx)){
            return false;
        }
        return  helper(s, startIdx + 1, endIdx - 1); 
    }
    public static boolean isPalindrome(String s){
         
         
     }



 





    public static void main(String[] args) {

        // printDiamondCutHalf(5);
       System.out.println( power(2, 4));
        
    }
}