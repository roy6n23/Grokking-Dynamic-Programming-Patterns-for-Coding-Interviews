class Fibonacci {

  public int CalculateFibonacci(int n) {
    if (n==0) return 0;
    int dp[] = new int[n+1];

    //base cases
    dp[0] = 0;
    dp[1] = 1;

    for(int i=2; i<=n; i++)
      dp[i] = dp[i-1] + dp[i-2];

    return dp[n];
  }

  public static void main(String[] args) {
    Fibonacci fib = new Fibonacci();
    System.out.println("5th Fibonacci is ---> " + fib.CalculateFibonacci(5));
    System.out.println("6th Fibonacci is ---> " + fib.CalculateFibonacci(6));
    System.out.println("7th Fibonacci is ---> " + fib.CalculateFibonacci(7));
  }
}