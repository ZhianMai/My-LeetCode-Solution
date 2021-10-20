/**
 * Problem #151
 */
class ReverseWordsInString {
  // Do this in-place, with Space O(1)
  public String reverseWords(String s) {
    char[] input = removeSpace(s).toCharArray();
    swap(input, 0, input.length - 1);

    int begin = 0;
    for (int end = 0; end < input.length; end++) {
      if (input[end] != ' ') {
        begin = end;
        while (end < input.length && input[end] != ' ') {
          end++;
        }
        swap(input, begin, end - 1);
      }
    }
    return new String(input);
  }
  
  private String removeSpace(String s) {
    char[] input = s.toCharArray();
    int begin = 0;
    int end = 0;
    for (; end < input.length; end++) {
      if (input[end] != ' ') {
        input[begin++] = input[end];
      } else if (end + 1 < input.length && input[end + 1] != ' ' && begin != 0) {
        input[begin++] = input[end];
      }
    }
    return new String(input, 0, begin);
  }
  
  private void swap(char[] input, int i, int j) {
    while (i <= j) {
      char temp = input[i];
      input[i] = input[j];
      input[j] = temp;
      i++;
      j--;
    }
  }
}