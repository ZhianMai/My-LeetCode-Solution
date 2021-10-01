/**
* Problem #11
*/
class ContainerWithMostWater {
  public int maxArea(int[] height) {
    int left = 0;
    int right = height.length - 1;
    int result = 0;

    while (left < right) {
      int higherOne = Math.min(height[left], height[right]);
      result = Math.max(result, higherOne * (right - left));

      if (height[left] <= height[right]) {
        left++;
      } else {
        right--;
      }
    }

    return result;
  }
}