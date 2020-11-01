class LPS {

  public int findLPSLength(String st) {
    return findLPSLengthRecursive(st, 0, st.length() - 1);
  }

  private int findLPSLengthRecursive(String st, int startIndex, int endIndex) {
    if (startIndex > endIndex)
      return 0;

    // every string with one character is a palindrome
    if (startIndex == endIndex)
      return 1;

    // case 1: elements at the beginning and the end are the same
    if (st.charAt(startIndex) == st.charAt(endIndex)) {
      int remainingLength = endIndex - startIndex - 1;
      // check if the remaining string is also a palindrome
      if (remainingLength == findLPSLengthRecursive(st, startIndex + 1, endIndex - 1))
        return remainingLength + 2;
    }

    // case 2: skip one character either from the beginning or the end
    int c1 = findLPSLengthRecursive(st, startIndex + 1, endIndex);
    int c2 = findLPSLengthRecursive(st, startIndex, endIndex - 1);
    return Math.max(c1, c2);
  }

  public static void main(String[] args) {
    LPS lps = new LPS();
    System.out.println(lps.findLPSLength("abdbca"));
    System.out.println(lps.findLPSLength("cddpd"));
    System.out.println(lps.findLPSLength("pqr"));
  }
}

//==============top down============

class LPS{
  public int findLPSLength(String st){
    int[][] dp = new int[st.length()][st.length()];
    return findLPSLengthRecursive(dp, st, 0, st.length()-1);
  }

  private int findLPSLengthRecursive(Integer[][] dp, String st, int startIndex, int endIndex) {
    if (startIndex > endIndex)
      return 0;

    // every string with one character is a palindrome
    if (startIndex == endIndex)
      return 1;

    if (dp[startIndex][endIndex] == null) {
      // case 1: elements at the beginning and the end are the same
      if (st.charAt(startIndex) == st.charAt(endIndex)) {
        int remainingLength = endIndex - startIndex - 1;
        // check if the remaining string is also a palindrome
        if (remainingLength == findLPSLengthRecursive(dp, st, startIndex + 1, endIndex - 1)) {
          dp[startIndex][endIndex] = remainingLength + 2;
          return dp[startIndex][endIndex];
        }
      }

      // case 2: skip one character either from the beginning or the end
      int c1 = findLPSLengthRecursive(dp, st, startIndex + 1, endIndex);
      int c2 = findLPSLengthRecursive(dp, st, startIndex, endIndex - 1);
      dp[startIndex][endIndex] = Math.max(c1, c2);
    }

    return dp[startIndex][endIndex];
  }
}


//===============bottom up========================
class LPS{

  public int findLPSLength(String st) {
    // dp[i][j] will be 'true' if the string from index 'i' to index 'j' is a
    // palindrome
    boolean[][] dp = new boolean[st.length()][st.length()];

    // every string with one character is a palindrome
    for (int i = 0; i < st.length(); i++)
      dp[i][i] = true;

    int maxLength = 1;
    for (int startIndex = st.length() - 1; startIndex >= 0; startIndex--) {
      for (int endIndex = startIndex + 1; endIndex < st.length(); endIndex++) {
        if (st.charAt(startIndex) == st.charAt(endIndex)) {
          // if it's a two character string or if the remaining string is a palindrome too
          if (endIndex - startIndex == 1 || dp[startIndex + 1][endIndex - 1]) {
            dp[startIndex][endIndex] = true;
            maxLength = Math.max(maxLength, endIndex - startIndex + 1);
          }
        }
      }
    }

    return maxLength;
  }
}