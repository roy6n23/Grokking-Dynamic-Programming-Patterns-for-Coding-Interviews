//===============TOP DOWN===================

class Fibonacci{

 public int CalculateFibonacci(int n) {
    int dp[] = new int[n + 1];
    return CalculateFibonacciRecursive(dp, n);
  }

  public int CalculateFibonacciRecursive(int[] dp, int n) {
    if (n < 2)
      return n;
    if (dp[n] == 0)
      dp[n] = CalculateFibonacciRecursive(dp, n - 1) + CalculateFibonacciRecursive(dp, n - 2);
    return dp[n];
  }
}

//================BOTTOM UP===============================

class Fibonacci {

  public int CalculateFibonacci(int n) {
    if (n < 2)
      return n;

    int dp[] = new int[n + 1];
    dp[0] = 0;
    dp[1] = 1;
    for (int i = 2; i <= n; i++)
      dp[i] = dp[i - 1] + dp[i - 2];
    return dp[n];
  }

  public static void main(String[] args) {
    Fibonacci fib = new Fibonacci();
    System.out.println("5th Fibonacci is ---> " + fib.CalculateFibonacci(5));
    System.out.println("6th Fibonacci is ---> " + fib.CalculateFibonacci(6));
    System.out.println("7th Fibonacci is ---> " + fib.CalculateFibonacci(7));
  }
}


//======================SPACE COMPLEXITY  O(1)====================================
class Fibonacci {

  public int CalculateFibonacci(int n) {
    if (n < 2)
      return n;
    int n1 = 0, n2 = 1, temp;
    for (int i = 2; i <= n; i++) {
      temp = n1 + n2;
      n1 = n2;
      n2 = temp;
    }
    return n2;
  }

  public static void main(String[] args) {
    Fibonacci fib = new Fibonacci();
    System.out.println("5th Fibonacci is ---> " + fib.CalculateFibonacci(5));
    System.out.println("6th Fibonacci is ---> " + fib.CalculateFibonacci(6));
    System.out.println("7th Fibonacci is ---> " + fib.CalculateFibonacci(7));
  }
}
