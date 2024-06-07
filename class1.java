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



    public static void main(String[] args) {
        
    }
}