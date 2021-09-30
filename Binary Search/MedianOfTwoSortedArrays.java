/**
* Problem #4
*/
class MedianOfTwoSortedArrays {
  public double findMedianSortedArrays(int[] a, int[] b) {
    if (a.length > b.length) { // swap to make sure a is shorter
      int[] temp = a;
      a = b;
      b = temp;
    }
        
    int m = a.length;
    int n = b.length;
    
    int from = 0;
    int to = m;
        
    while (from <= to) { // perform binary search
      int midA = from + (to - from) / 2;
      int midB = (m + n + 1) / 2 - midA;
      if (midA < m && b[midB - 1] > a[midA]) {
        from = midA + 1;
      } else if (midA > 0 && a[midA - 1] > b[midB]) {
        to = midA - 1;
      } else {
        int maxLeft = Math.max(midA == 0 ? Integer.MIN_VALUE : a[midA - 1],
                               midB == 0 ? Integer.MIN_VALUE : b[midB - 1]);
          
        if ((m + n) % 2 == 1) {
          return maxLeft;
        }
          
        int minRight = Math.min(midA == m ? Integer.MAX_VALUE : a[midA],
                                midB == n ? Integer.MAX_VALUE : b[midB]);
          
        return (maxLeft + minRight) / 2.0;
      }
    }
    return 0;
  }
}