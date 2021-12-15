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
  
  // Detailed solution, naive approach
  public double findMedianSortedArraysB(int[] numsA, int[] numsB) {
    // begin index of numsA, inclusively
    int aBegin = 0;
    // begin index of numsB, inclusively
    int bBegin = 0;
    int aEnd = numsA.length;
    int bEnd = numsB.length;
    // The total length is odd or even
    boolean isOddLen = (aEnd + bEnd) % 2 == 1;
    // Total elements to drop
    int remains = (aEnd + bEnd) / 2;
    
    if (!isOddLen) { // For even length, need to drop one less
      remains--;
    }
    
    while (remains != 0) {
      if (aBegin == aEnd) { // array A is totally dropped
        bBegin += remains;
        remains = 0;
        break;
      }
      
      if (bBegin == bEnd) { // array B is totally dropped
        aBegin += remains;
        remains = 0;
        break;
      }
      
      // Each time drop (reamins / 2) elements
      // Get the ceiling(remains / 2) to avoid infinity loop when remains == 1
      int toDrop = remains / 2 + remains % 2;
      
      // The index for deciding which array to drop (reamins / 2) elements
      int aIdxToCheck = Math.min(aEnd, aBegin + toDrop) - 1;
      int bIdxToCheck = Math.min(bEnd, bBegin + toDrop) - 1;
      
      if (numsA[aIdxToCheck] <= numsB[bIdxToCheck]) { // drop array A
        remains -= (aIdxToCheck - aBegin + 1);
        aBegin = aIdxToCheck + 1;
      } else { // drop array B
        remains -= (bIdxToCheck - bBegin + 1);
        bBegin = bIdxToCheck + 1;
      }
    } // end while()
    
    if (aBegin == aEnd) { // array A is totally dropped
      if (isOddLen) {
        return numsB[bBegin];
      } else {
        return (numsB[bBegin] + numsB[bBegin + 1]) * 1.0 / 2; 
      }
    }
    
    if (bBegin == bEnd) { // array B is totally dropped
      if (isOddLen) {
        return numsA[aBegin];
      } else {
        return (numsA[aBegin] + numsA[aBegin + 1]) * 1.0 / 2; 
      }
    }
    
    // Neither A nor B is empty 
    if (isOddLen) {
      return Math.min(numsA[aBegin], numsB[bBegin]);
    } else {
      // When the total length is even, it needs to pick the two smallest from
      // numsA[aBegin], numsA[aBegin + 1], numsB[bBegin], and numsB[bBegin + 1]
      int minX = 0;
      int minY = 0;
      
      if (numsA[aBegin] < numsB[bBegin]) {
        minX = numsA[aBegin++];
      } else {
        minX = numsB[bBegin++];
      }
      
      if (aBegin == aEnd) {
        minY = numsB[bBegin];
      } else if (bBegin == bEnd) {
        minY = numsA[aBegin];
      } else {
        minY = Math.min(numsA[aBegin], numsB[bBegin]);
      }
        
      return (minX + minY) * 1.0 / 2;
    }
  }
}