package string.decode;

/**
* This is a problem from one coding challenge.
* 
* Use number 1 - 26 to represent 'a' - 'z';
*
* If the number is single and from 1 - 9, it will not end up with anything, such as 1 -> 'a'.
* If the number is single and from 10 - 26, it will end up with '#', such as 26# -> 'z'.
* If the number is multiple and from 1 - 9, it will end up with (count), such as
* 1(9) -> 'aaaaaaaaa'
* If the number is multiple and from 10 - 26, it will end up with #(count), such as
* 26#(9) -> 'zzzzzzzzz'
*
* Since I cannot access the original problem, so I also wrote some Junit test for checking
* correctness.
*/
public class StringDecode {
  private static final int J_TO_Z_POUND_IDX = 2;
  private static final int J_TO_Z_LENGTH = 3;

  public String decode(String s) {
    char[] input = s.toCharArray();
    StringBuilder result = new StringBuilder();

    // Four types of input format:
    // Case 1: single letter 1 to 9 as a to i;
    // Case 2: single letter 10# to 26# as j to z;
    // Case 3: Multiple letters 1(num) to 9(num) as [a * num] to [i * num];
    // Case 4: Multiple letters 10#(num) to 26#(num) as [j * num] to [z * num];
    int i = 0;
    int len = input.length;

    while (i < len) {
      if (
          // Not meet case 2 & 4
          !(i + J_TO_Z_POUND_IDX < len && input[i + J_TO_Z_POUND_IDX] == '#') &&
          // Not meet case 3
          !(i + 1 < len && input[i + 1] == '(')
      ) {
        int charIdx = charToInt(input[i]);

        result.append(intToChar(charIdx));
        i++;
      } else if (
          // Not meet case 2
          !(i + 1 < len && input[i + 1] == '(') &&
          // Meet case 3
          (i + J_TO_Z_POUND_IDX < len && input[i + J_TO_Z_POUND_IDX] == '#') &&
          // Not meet case 4
          !(i + J_TO_Z_LENGTH < len && input[i + J_TO_Z_LENGTH] == '(')
      ) {
        int charIdx = charToInt(input[i]) * 10 + charToInt(input[i + 1]);

        result.append(intToChar(charIdx));
        i += J_TO_Z_LENGTH; // index skip over '#'
      } else if (i + 1 < len && input[i + 1] == '(') { // Meet case 3
        int charIdx = charToInt(input[i]);
        int[] newIndex = new int[]{0};
        int count = getCount(input, i + 2, newIndex); // i + 2 skip over '('

        buildString(result, count, intToChar(charIdx));
        i = newIndex[0] + 1; // index skip over ')'
      } else { // Case 4 left
        int charIdx = charToInt(input[i]) * 10 + charToInt(input[i + 1]);
        int[] newIndex = new int[]{0};
        int count = getCount(input, i + 4, newIndex); // i + 4 skip over '('

        buildString(result, count, intToChar(charIdx));
        i = newIndex[0] + 1; // index skip over ')'
      }
    }
    return result.toString();
  }

  private int getCount(char[] input, int index, int[] newIndex) {
    int count = 0;

    while (index < input.length && input[index] != ')') {
      count *= 10;
      count += charToInt(input[index++]);
    }

    newIndex[0] = index;
    return count;
  }

  public char intToChar(int i) {
    return (char)('a' + i - 1);
  }

  public int charToInt(char ch) {
    return Character.getNumericValue(ch);
  }

  private void buildString(StringBuilder sb, int count, char ch) {
    while (count-- > 0) {
      sb.append(ch);
    }
  }
}
