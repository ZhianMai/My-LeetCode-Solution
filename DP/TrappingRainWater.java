/**
* Problem #42
*/
class TrappingRainWater {
  public int trap(int[] height) {
    int length = height.length;
    int[] leftMaxHeight = new int[length];
    int[] rightMaxHeight = new int[length];

    int currLeftMaxHeight = height[0];
    for (int i = 1; i < length; i++) {
      leftMaxHeight[i] = currLeftMaxHeight;
      if (height[i] > currLeftMaxHeight) {
        currLeftMaxHeight = height[i];
      }

    }

    int currRightMaxHeight = height[length - 1];
    for (int i = length - 1; i >= 0; i--) {
      rightMaxHeight[i] = currRightMaxHeight;
      if (height[i] > currRightMaxHeight) {
        currRightMaxHeight = height[i];
      }

    }

    int result = 0;
    for (int i = 1; i < length - 1; i++) {
      int temp = Math.min(leftMaxHeight[i], rightMaxHeight[i]) - height[i];
      result += (temp < 0 ? 0 : temp);
    }
    return result;
  }
}