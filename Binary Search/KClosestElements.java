/**
 * Problem #658
*/
public class KClosestElements {
  public List<Integer> findClosestElements(int[] arr, int k, int x) {
    // Get element closest to x
    int xIdx = findColsestToTarget(arr, x);
    
    // Perform binary reduction on two subarrays:
    // left subarray: [0, xIdx]
    // right subarray: [xIdx + 1, end]
    
    // begin of left subarry NOT selected, inclusively
    int leftBegin = xIdx; 
    // begin of right subarry NOT selected, inclusively
    int rightBegin = xIdx + 1; 
    int leftEnd = -1;
    int rightEnd = arr.length;
    int remains = k;
    
    while (remains != 0) {
      if (leftBegin == leftEnd) {
        rightBegin += remains;
        break;
      }
      
      if (rightBegin == rightEnd) {
        leftBegin -= remains;
        break;
      }
      
      int toKeep = remains / 2 + remains % 2;
      int leftToCompareIdx = Math.max(0, leftBegin - toKeep + 1); 
      int rightToCompareIdx = Math.min(rightEnd - 1, rightBegin + toKeep - 1);
      
      if (Math.abs(arr[leftToCompareIdx] - x) - 
          Math.abs(arr[rightToCompareIdx] - x) <= 0) {
        remains -= (leftBegin - leftToCompareIdx + 1);
        leftBegin = leftToCompareIdx - 1;
      } else {
        remains -= (rightToCompareIdx - rightBegin + 1);
        rightBegin = rightToCompareIdx + 1;
      }
    }
    
    // System.out.println("left: " + leftBegin + " right: " + rightBegin);
    
    List<Integer> result = new LinkedList<>();
    
    for (int i = leftBegin + 1; i < rightBegin; i++) {
      result.add(arr[i]);
    }
    
    return result;
  }
  
  private int findColsestToTarget(int[] arr, int x) {
    int left = 0;
    int right = arr.length - 1;
    
    while (left < right - 1) { // end if left + 1 == right
      int mid = left + (right - left) / 2;
      
      if (arr[mid] == x) {
        return mid;
      } else if (arr[mid] < x) {
        left = mid;
      } else {
        right = mid;
      }
    }
    
    int leftAbs = Math.abs(arr[left] - x);
    int rightAbs = Math.abs(arr[right] - x);
    
    if (leftAbs <= rightAbs) {
      return left;
    } else {
      return right;
    }
  }
}