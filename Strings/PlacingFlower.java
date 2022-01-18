/**
 * Problem #605
 */
class PlacingFlower {
  public boolean canPlaceFlowers(int[] arr, int n) {
    if (arr[0] == 0 && (arr.length == 1 || arr[1] == 0)) {
      arr[0] = 1;
      n--;
    }
    
    for (int i = 1; i < arr.length - 1; i++) {
      if (arr[i] == 0 && arr[i - 1] == 0 && arr[i + 1] == 0) {
        n--;
        arr[i] = 1;
      }
    }
    
    if (arr[arr.length - 1] == 0 && (arr.length > 2 && arr[arr.length - 2] == 0)) {
      n--;
      //arr[arr.length - 1] = 1;
    }
    
    return n <= 0;
  }
}