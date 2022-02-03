/**
 * Problem #302
 */
class AllBlackPixels {
  public int minArea(char[][] image, int x, int y) {
    int width = findBlackPixelWidth(image, y);
    int height = findBlackPixelHeight(image, x);
    return width * height;
  }
  
  private int findBlackPixelWidth(char[][] image, int y) {
    int left = 0;
    int right = y;
    
    // First occurence of black pixel!
    while (left < right) { // end if left == right
      int mid = left + (right - left) / 2;
      
      if (containBlackPixelVertical(image, mid)) {
        right = mid;
      } else {
        left = mid + 1;
      }
    }
    
    int firstOccur = right;
    
    left = y;
    right = image[0].length - 1;
    
    // Last occurence of black pixel!
    while (left < right) {
      int mid = left + (right - left) / 2 + (right - left) % 2;
      
      if (containBlackPixelVertical(image, mid)) {
        left = mid;
      } else {
        right = mid - 1;
      }
    }
    
    int lastOccur = right;
    
    return lastOccur - firstOccur + 1;
  }
  
  private boolean containBlackPixelVertical(char[][] image, int idx) {
    for (int i = 0; i < image.length; i++) {
      if (image[i][idx] == '1') {
        return true;
      }
    }
    return false;
  }
  
  private int findBlackPixelHeight(char[][] image, int x) {
    int up = 0;
    int down = x;
    
    // First occurence of black pixel!
    while (up < down) { // end if left == right
      int mid = up + (down - up) / 2;
      
      if (containBlackPixelHorizontal(image, mid)) {
        down = mid;
      } else {
        up = mid + 1;
      }
    }
    
    int firstOccur = up;
    
    up = x;
    down = image.length - 1;
    
    // Last occurence of black pixel!
    while (up < down) {
      int mid = up + (down - up) / 2 + (down - up) % 2;
      
      if (containBlackPixelHorizontal(image, mid)) {
        up = mid;
      } else {
        down = mid - 1;
      }
    }
    
    int lastOccur = down;
    
    return lastOccur - firstOccur + 1;
  }
  
  private boolean containBlackPixelHorizontal(char[][] image, int idx) {
    for (int i = 0; i < image[0].length; i++) {
      if (image[idx][i] == '1') {
        return true;
      }
    }
    return false;
  }
}