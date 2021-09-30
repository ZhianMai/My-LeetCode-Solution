/**
* Problem #5
*/
class LongestPalindromicSubstring {
  public String longestPalindrome(String s) {
    int left = 0;
    int right = 0;
    char[] input = s.toCharArray();

    for (int i = 0; i < input.length * 2; i++) {
      int currLeft = i / 2;
      int currRight = i / 2 + i % 2;
      int paliLength = palidromeLength(input, currLeft, currRight);

      if (right - left + 1 < paliLength) {
        left = currRight - paliLength / 2;
        right = currLeft + paliLength / 2;
      }
    }

    return s.substring(left, right + 1);
  }

  private int palidromeLength(char[] input, int left, int right) {
    while (left >= 0 && right < input.length && input[left] == input[right]) {
      left--;
      right++;
    }

    return right - left - 1;
  }
}