//=====================================BRUTE FORCE==============================================

class Knapsack{

  public int solveKnapsack(int[] profits, int[] weights, int capacity) {
    return this.knapsackRecursive(profits, weights, capacity, 0);
  }

  private int knapsackRecursive(int[] profits, int[] weights, int capacity, int currentIndex) {
    // base checks
    if (capacity <= 0 || profits.length == 0 || weights.length != profits.length || 
        currentIndex >= profits.length)
      return 0;

    // recursive call after choosing the items at the currentIndex, note that we recursive call on all
    // items as we did not increment currentIndex
    int profit1 = 0;
    if (weights[currentIndex] <= capacity)
      profit1 = profits[currentIndex]
          + knapsackRecursive(profits, weights, capacity - weights[currentIndex], currentIndex);

    // recursive call after excluding the element at the currentIndex
    int profit2 = knapsackRecursive(profits, weights, capacity, currentIndex + 1);

    return Math.max(profit1, profit2);
  }

}

//=========================================TOP DOWN=============================================

class Knapsack{

  public int solveKnapsack(int[] profits, int[] weights, int capacity) {
    Integer[][] dp = new Integer[profits.length][capacity + 1];
    return this.knapsackRecursive(dp, profits, weights, capacity, 0);
  }

  private int knapsackRecursive(Integer[][] dp, int[] profits, int[] weights, int capacity,
      int currentIndex) {

    // base checks
    if (capacity <= 0 || profits.length == 0 || weights.length != profits.length ||
        currentIndex >= profits.length)
      return 0;

    // check if we have not already processed a similar sub-problem
    if(dp[currentIndex][capacity] == null) {
      // recursive call after choosing the items at the currentIndex, note that we recursive call on all
      // items as we did not increment currentIndex
      int profit1 = 0;
      if( weights[currentIndex] <= capacity )
          profit1 = profits[currentIndex] + knapsackRecursive(dp, profits, weights,
                  capacity - weights[currentIndex], currentIndex);

      // recursive call after excluding the element at the currentIndex
      int profit2 = knapsackRecursive(dp, profits, weights, capacity, currentIndex + 1);

      dp[currentIndex][capacity] = Math.max(profit1, profit2);
    }

    return dp[currentIndex][capacity];
  }


}


//================================BOTTOM UP=======================================

class Knapsack{
	public int solveKnapsack(int[] profits, int[] weights, int capacity){
		if(capacity <= 0 || profits.length == 0 || profits.length != weights)
			return 0;

		int n = profits.length;
		int[][] dp = new int[n][capacity + 1];

		for(int i = 0; i < n; i++)
			dp[i][0] = 0;

		for(int i = 0; i < n; i++){
			for(int c = 1; c <= capacity; c++){
				int profit1 = 0, profit2 = 0;
				if(weights[i] <= c)
					profit1 = profits[i] + dp[i][c - weights[i]];
				if(i > 0)
					profit2 = dp[i-1][c];
				dp[i][c] = Math.max(profit1, profit2);
			}
		}
		printSelectElements(dp, weights, profits, capacity);
		return dp[n-1][capacity];
	}

	private void printSelectElements(int[][] dp, int[] weights, int[] profits, int capacity){
		System.out.print("Selected weights:");
		int totalProfits = dp[weights.length - 1][capacity];
		for(int i = weights.length - 1; i >0; i--){
			if(totalProfits !=dp[i-1][capacity])
				System.out.println(" " + weights[i]);
				capacity -= weights[i];
				totalProfits -= profits[i];
		}
		if(totalProfits != 0)
			System.out.println(" " + weights[0]);
		System.out.println("");
	}
}
