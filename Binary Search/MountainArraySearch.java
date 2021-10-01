/**
* Problem #1095
*
* Use the second binary search pattern.
*/
class MountainArraySearch {
  public int findInMountainArray(int target, MountainArray mountainArr) {
    int peak = getPeak(mountainArr);
    int leftOne = firstOccurence(mountainArr, 0, peak, target, true);

    if (leftOne == -1) {
      return firstOccurence(mountainArr, peak, mountainArr.length() - 1, target, false);
    }
    return leftOne;
  }

  private int firstOccurence(MountainArray arr, int left, int right, int target, boolean ascending) {
    while (left < right) {
      int mid = left + (right - left) / 2;

      if ((ascending && arr.get(mid) < target) || (!ascending && arr.get(mid) > target)) {
        left = mid + 1;
      } else {
        right = mid;
      }
    }
    return arr.get(left) == target ? left : -1;
  }

  private int getPeak(MountainArray arr) {
    int left = 1;
    int right = arr.length() - 2;

    while (left <= right) {
      int mid = left + (right - left) / 2;
      int midVal = arr.get(mid);

      if (midVal > arr.get(mid - 1) && midVal > arr.get(mid + 1)) {
        return mid;
      } else if (arr.get(mid - 1) < midVal && midVal < arr.get(mid + 1)) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    return - 1;
  }
}