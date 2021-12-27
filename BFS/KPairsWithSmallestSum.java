/**
 * Problem #373
 */
class KPairsWithSmallestSum {
  class Pair {
    long sum;
    int i;
    int j;
    
    public Pair(long sum, int i, int j) {
      this.sum = sum;
      this.i = i;
      this.j = j;
    }
  }
  
  // This method requires O(n*m) space
  public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
    List<List<Integer>> result = new LinkedList<>();
    int rows = Math.min(nums1.length, k);
    int cols = Math.min(nums2.length, k);
    boolean[][] visited = new boolean[rows][cols];
    
    // int[3]: [sum, nums1_idx, nums2_idx]
    PriorityQueue<Pair> minHeap = new PriorityQueue<>(new Comparator<Pair>(){
        @Override
        public int compare(Pair a, Pair b) {
          return Long.compare(a.sum, b.sum);
        }
    });
    minHeap.offer(new Pair(nums1[0] + nums2[0], 0, 0));
    visited[0][0] = true;
    
    while(k-- != 0 && !minHeap.isEmpty()) {
      Pair pair = minHeap.poll();
      List<Integer> curr = new LinkedList<>();
      curr.add(nums1[pair.i]);
      curr.add(nums2[pair.j]);
      result.add(curr);
      
      if (pair.i + 1 < rows && !visited[pair.i + 1][pair.j]) {
        minHeap.offer(new Pair(nums1[pair.i + 1] + nums2[pair.j], pair.i + 1, pair.j));
        visited[pair.i + 1][pair.j] = true;
      }
      
      if (pair.j + 1 < cols && !visited[pair.i][pair.j + 1]) {
        minHeap.offer(new Pair(nums1[pair.i] + nums2[pair.j + 1], pair.i, pair.j + 1));
        visited[pair.i][pair.j + 1] = true;
      }
    }
    
    return result;
  }
  
  // This method requires O(k) space
  public List<List<Integer>> kSmallestPairsB(int[] nums1, int[] nums2, int k) {
    List<List<Integer>> result = new LinkedList<>();
    int rows = Math.min(nums1.length, k);
    int cols = Math.min(nums2.length, k);
    
    // int[3]: [sum, nums1_idx, nums2_idx]
    PriorityQueue<Pair> minHeap = new PriorityQueue<>(new Comparator<Pair>(){
        @Override
        public int compare(Pair a, Pair b) {
          return Long.compare(a.sum, b.sum);
        }
    });
    
    for (int i = 0; i < rows; i++) {
      minHeap.offer(new Pair(nums1[i] + nums2[0], i, 0));
    }
    
    while(k-- != 0 && !minHeap.isEmpty()) {
      Pair pair = minHeap.poll();
      List<Integer> curr = new LinkedList<>();
      curr.add(nums1[pair.i]);
      curr.add(nums2[pair.j]);
      result.add(curr);
      
      if (pair.j + 1 < cols) {
        pair.sum = nums1[pair.i] + nums2[pair.j + 1];
        pair.j++;
        minHeap.offer(pair);
      }
    }
    
    return result;
  }
}