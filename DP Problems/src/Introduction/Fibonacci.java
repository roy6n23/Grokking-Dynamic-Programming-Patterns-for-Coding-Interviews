package Introduction;



public class Fibonacci {


/* ==========Brute force==============

    public int CalculateFibonacci(int n){
        if(n < 2)
            return n;
        return CalculateFibonacci(n -1 ) + CalculateFibonacci(n  -2);
    }
*/
    public int CalculateFibonacci(int n ){
        int memorize[] = new int[n+1];
        return CalculateFibonacciRecursive(memorize, n );
    }

    public  int CalculateFibonacciRecursive(int[] memorize, int n ){
        if(n < 2)
            return n;
        // if we have already solved this subproblem, simply return the result from the cache
        if(memorize[n] != 0){
            return memorize[n];
        }

        memorize[n] = CalculateFibonacciRecursive(memorize, n -1) +
                CalculateFibonacciRecursive(memorize, n -2);
        return memorize[n];
    }

    public static void main(String[] args) {
        Fibonacci fib = new Fibonacci();
        System.out.println("5th Fibonacci is ---> " + fib.CalculateFibonacci(5));
        System.out.println("6th Fibonacci is ---> " + fib.CalculateFibonacci(6));
        System.out.println("7th Fibonacci is ---> " + fib.CalculateFibonacci(7));
    }
}
