class ArrayJump{
	public int countMinJumps(int[] jumps){
		return this.countMinJumpsRecursive(jumps, 0);
	}

	private int countMinJumpsRecursive(int[] jumps, int currentIndex){
		// if we have reached the last index, we don't need any more jumps
		if(currentIndex == jumps.length - 1)
			return 0;

		if(jumps[currentIndex] == 0)
			return Integer.MAX_VALUE;

		int totaljumps = Integer.MAX_VALUE;
		int start = currentIndex + 1;
		int end = currentIndex + jumps[currentIndex];
		while(start < jumps.length && start <= end){
			int minJumps = countMinJumpsRecursive(jumps, start++);
			if(minJumps != Integer.MAX_VALUE)
				totaljumps = Math.min(totaljumps, minJumps+1);
		}

		return totaljumps;
	}
}

//=====================TOP DOWN============================

class ArrayJump{

 public int countMinJumps(int[] jumps) {
    int dp[] = new int[jumps.length];
    return this.countMinJumpsRecursive(dp, jumps, 0);
  }

  private int countMinJumpsRecursive(int[] dp, int[] jumps, int currentIndex) {
    // if we have reached the last index, we don't need any more jumps
    if( currentIndex == jumps.length - 1)
      return 0;

    // If an element is 0, then we cannot move through that element
    if (jumps[currentIndex] == 0)
      return Integer.MAX_VALUE;

    // if we have already solved this problem, return the result
    if(dp[currentIndex] != 0)
      return dp[currentIndex];

    int totalJumps = Integer.MAX_VALUE;
    int start = currentIndex + 1;
    int end = currentIndex + jumps[currentIndex];
    while(start < jumps.length && start <= end) {
      // jump one step and recurse for the remaining array
      int minJumps = countMinJumpsRecursive(dp, jumps, start++);
      if(minJumps != Integer.MAX_VALUE)
        totalJumps = Math.min(totalJumps, minJumps + 1);
    }
    dp[currentIndex] = totalJumps;
    return dp[currentIndex];
  }

}


//====================BOTTOM UP===========================
class ArrayJump{

	public int countMinJumps(int[] jumps){
		int[] dp = new int[jumps.length];

		for(int i=1; i< jumps.length; i++)
			dp[i] = Integer.MAX_VALUE;

		for(int start = 0; start < jumps.length-1; start++){
			for(int end = start+1; end< jumps[start] + start && end< jums.length; end++){
				dp[end] = Math.min(dp[end], dp[start] +1 );
			}
		}

		return dp[jumps.length-1];
	}
}