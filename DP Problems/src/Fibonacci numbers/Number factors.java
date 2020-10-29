class ExpressNumber {

  public int CountWays(int n) {
    if( n == 0)
      return 1; // base case, we don't need to subtract any thing, so there is only one way

    if(n == 1)
      return 1; // we can subtract 1 to be left with zero, and that is the only way

    if(n == 2)
      return 1; // we can subtract 1 twice to get zero and that is the only way

    if(n == 3)
      return 2; // '3' can be expressed as {1,1,1}, {3}
      
    // if we subtract 1, we are left with 'n-1'
    int subtract1 = CountWays(n-1);
    // if we subtract 3, we are left with 'n-3'
    int subtract3 = CountWays(n-3);
    // if we subtract 4, we are left with 'n-4'
    int subtract4 = CountWays(n-4);

    return subtract1 + subtract3 + subtract4;
  }
}

//===================TOP DOWN=================
class ExpressNumber{

  public int coutWays(int n){
    int[] dp = new int[n+1];
    return coutWaysRecursive(dp, n);
  }

  public int coutWaysRecursive(int[] dp, int n){
    if(n==0)
      return 1;
    if(n==1)
      return 1;
    if(n==2)
      return 1;
    if(n==3)
      return 2;

    if(dp[n] == 0){
      int subtract1 = coutWaysRecursive(n-1);
      int subtract3 = coutWaysRecursive(n-3);
      int subtract4 = coutWaysRecursive(n-4);

      dp[n] = subtract4 + subtract3 + subtract1;
    }

    return dp[n];
  }
}


//===================BOTTOM UP==============

class ExpressNumber{
  public int coutWays(int n){
    int[] dp = new int[n+1];

    dp[0] = 1;
    dp[1] = 1;
    dp[2] = 1;
    dp[3] = 2;

    for(int i =4; i <= n; i++){
      dp[i] = dp[i-1] + dp[i-3] + dp[i-4];
    }

    return dp[n];
  }
}