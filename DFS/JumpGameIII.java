/**
* Problem #1306
*/
class JumpGameIII {
  public boolean canReach(int[] arr, int index) {
    if (index < 0 || index >= arr.length || arr[index] < 0) {
      return false;
    }
    
    arr[index] *= -1;
    
    if (arr[index] == 0) {
      return true;
    }
    
    return canReach(arr, index + arr[index]) || canReach(arr, index - arr[index]);
  }
}