/**
 * Problem #973
 */
class KClosestToOrigin {
  public int[][] kClosest(int[][] points, int k) {
    int len = points.length;
    int[] distance = new int[len];
    
    for (int i = 0; i < len; i++) {
      distance[i] = (points[i][0] * points[i][0]) + (points[i][1] * points[i][1]);
    }
    
    quickSelect(points, distance, 0, len - 1, k);
    return Arrays.copyOf(points, k);
  }
  
  // retrun the index pivot, where array[left] to array[pivot] inclusively has length k
  // i.e. pivot - left + 1 == k
  private void quickSelect(int[][] input, int[] distance, int left, int right, int k) {
    if (left > right || (right - left + 1) < k) {
      return;
    }
    
    int pivot = partition(input, distance, left, right);
    
    if (pivot - 1 - left + 1 == k) {
      return;
    }
    
    if (pivot - 1 - left + 1 > k) { // Left subarray is longer than k elements
      quickSelect(input, distance, left, pivot - 1, k);
    } else { // Left subarray is shorter than k elements
      // Need to get (k - (pivot - 1 - left + 1)) elements from right subarray
      k = k - pivot + left;
      quickSelect(input, distance, pivot + 1, right, k - 1);
    }
  }
  
  private int partition(int[][] input, int[] distance, int left, int right) {
    int target = distance[right];
    int prevRight = right;
    right--;
    
    // left: end of array < pivot exclusively
    // right: begin of array >= pivot exclusively
    while (left <= right) {
      if (distance[left] < target) {
        left++;
      } else if (distance[right] >= target) {
        right--;
      } else {
        swap(distance, left, right);
        swap(input, left++, right--); 
      }
    }
    
    swap(input, prevRight, left);
    swap(distance, prevRight, left);
    return left;
  }
  
  private void swap(int[][] arr, int i, int j) {
    int[] temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
  
  private void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
}