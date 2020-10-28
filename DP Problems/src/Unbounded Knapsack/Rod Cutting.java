//=======================just like the unbounded knapsack problem, so let's beging with the top down=====================

class RodCutting{

	public int rodCutting(int[] lengths, int[] prices, int rodlength){
		int[][] dp = new int[lengths.length][rodlength +1];
		return this.rodCuttingTopDown(dp, lengths, prices, rodlength, 0);
	}

	private int rodCuttingTopDown(int[][] dp, int[] lengths, int[] prices, int rodlength, int currentIndex){

		if(lengths.length == 0|| rodlength <= 0 || lengths.length != prices.length ||
			currentIndex >= lengths.length)
			return 0;

		if(dp[currentIndex][rodlength] == null){
			int price1 = 0;
			if(lengths[currentIndex] <= rodlength)
				price1 = prices[currentIndex] + 
							rodCuttingTopDown(dp, lengths, prices, rodlength-lengths[currentIndex], currentIndex);

			int price2 = rodCuttingTopDown(dp, lengths, prices, rodlength, currentIndex +1);

			dp[currentIndex][rodlength] = Math.max(price1, price2);
		}

		return dp[currentIndex][rodlength]
	}
}

//=====================================the bottom up=================================


class RodCutting{

  public int solveRodCutting(int[] lengths, int[] prices, int n) {
    // base checks
    if (n <= 0 || prices.length == 0 || prices.length != lengths.length)
      return 0;

    int lengthCount = lengths.length;
    int[][] dp = new int[lengthCount][n + 1];

    for(int i = 0; i < lengthCount; i++)
			dp[i][0] = 0;

    // process all rod lengths for all prices
    for(int i=0; i < lengthCount; i++) {
      for(int len=1; len <= n; len++) {
        int p1=0, p2=0;
        if(lengths[i] <= len)
          p1 = prices[i] + dp[i][len-lengths[i]];
        if( i > 0 )
          p2 = dp[i-1][len];
        dp[i][len] = Math.max(p1, p2);
      }
    }

    // maximum price will be at the bottom-right corner.
    return dp[lengthCount-1][n];
  }

  public static void main(String[] args) {
    RodCutting rc = new RodCutting();
    int[] lengths = {1, 2, 3, 4, 5};
    int[] prices = {2, 6, 7, 10, 13};
    int maxProfit = rc.solveRodCutting(lengths, prices, 5);
    System.out.println(maxProfit);
  }
}

