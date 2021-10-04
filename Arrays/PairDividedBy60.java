/**
* Problem #1010
* 
* This is an interesting problem of permutation & combination.
*/
class PairDividedBy60 {
  public int numPairsDivisibleBy60(int[] time) {
    int[] modCount = new int[60]; // Space O(1)

    for (int i = 0; i < time.length; i++) {
      modCount[time[i] % 60]++;
    }

    int count = 0;

    for (int i  = 0; i <= modCount.length / 2; i++) {
      if (i == 0 || i == 30) {
        count += (modCount[i] * (modCount[i] - 1)) / 2;
      } else {
        count += (modCount[i] * modCount[60 - i]);
      }
    }
    return count;
  }
}