//=======================================BRUTE FORCE=================================




class CoinChange{

	public int countChange(int[] denominations, int total){
		return this.countChangeRecursive(denominations, total, 0);
	}

	private int countChangeRecursive(int[] denominations, int total, int currentIndex){

		if(total == 0)
			return 1;

		if(denominations.length == 0 || currentIndex >= denominations.length)
			return 0;

		int sum1 = 0;
		if(denominations[currentIndex] <= total)
			sum1 = countChangeRecursive(denominations, total - denominations[currentIndex], currentIndex);

		int sum2 = countChangeRecursive(denominations, total, currentIndex +1);

		int sum = sum1 + sum2;

		return sum;
	}
}


//=====================================TOP DOWN================================
class CoinChange{

	public int countChange(int[] denominations, int total){
		int[][] dp = new int[denominations.length][total + 1];
		return this.countChangeRecursive(dp, denominations, total, 0);
	}

	private int countChangeRecursive(int[][] dp, int[] denominations, int total, int currentIndex){

		if(total == 0)
			return 1;

		if(denominations.length == 0 || currentIndex >= denominations.length)
			return 0;

		if(dp[currentIndex][total] == null){

			int sum1 = 0;
			if(denominations[currentIndex] <= total)
				sum1 = countChangeRecursive(denominations, total - denominations[currentIndex], currentIndex);

			int sum2 = countChangeRecursive(denominations, total, currentIndex +1);

			dp[currentIndex][total] = sum1 + sum2;
		}

		return dp[currentIndex][sum];
	}
}

//===================================BOTTOM UP===============================================
class CoinChange{

  public int countChange(int[] denominations, int total) {
    int n = denominations.length;
    int[][] dp = new int[n][total + 1];

    // populate the total=0 columns, as we will always have an empty set for zero total
    for(int i=0; i < n; i++)
      dp[i][0] = 1;
    
    // process all sub-arrays for all capacities
    for(int i=0; i < n; i++) {
      for(int t=1; t <= total; t++) {
        if(i > 0)
          dp[i][t] = dp[i-1][t];
        if(t >= denominations[i])
          dp[i][t] += dp[i][t-denominations[i]];
      }
    }

    // total combinations will be at the bottom-right corner.
    return dp[n-1][total];
  }
}