/**
* Problem #725
*/
class SplitingLinkedListInPart {
  public ListNode[] splitListToParts(ListNode head, int k) {
    int size = 0;

    for (ListNode temp = head; temp != null; temp = temp.next) {
      size++; // Get the size of linked list.
    }

    int[] eachSize = new int[k];

    for (int i = 0; i < size; i++) { // Calculate length of each linked list
      eachSize[i % k]++;
    }

    ListNode[] result = new ListNode[k];

    for (int i = 0; i < k; i++) {
      if (eachSize[i] != 0) {
        result[i] = head;
        ListNode prev = null;

        while (eachSize[i]-- != 0) {
          prev = head;
          head = head.next;
        }

        prev.next = null;
      }
    }

    return result;
  }
}