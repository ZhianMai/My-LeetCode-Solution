/**
* Problem #23
*/
class MergingKLists {
  // Merge with minHeap
  public ListNode mergeKListsA(ListNode[] lists) {
    ListNode dummy = new ListNode();
    // If lists.length == 0, return null as dummy.next.
    ListNode curr = dummy;
    PriorityQueue<ListNode> minHeap = new PriorityQueue<>(new Comparator<ListNode>() {
      @Override
      public int compare(ListNode one, ListNode two) {
        if (one.val == two.val) {
          return 0;
        }
        return one.val < two.val ? -1 : 1;
      }
    });

    for (int i = 0; i < lists.length; i++) {
      if (lists[i] != null) {
        minHeap.offer(lists[i]);
      }
    }

    while (!minHeap.isEmpty()) {
      curr.next = minHeap.poll();
      curr = curr.next;
      ListNode next = curr.next;
      // curr.next = null;

      if (next != null) {
        minHeap.offer(next);
      }
    }
    return dummy.next;
  }
  
  // Merge with iteration
    public ListNode mergeKListsB(ListNode[] lists) {
    ListNode dummy = new ListNode();

    for (ListNode node : lists) {
      dummy.next = merge(dummy.next, node);
    }
    return dummy.next;
  }
  
  // Merge with binary reduction (divide & conquer)
  public ListNode mergeKLists(ListNode[] lists) {
    if (lists.length == 0) {
      return null;
    }

    int end = lists.length - 1;

    while (end != 0) {
      int begin = 0;
      int currEnd = end;

      while (begin < currEnd) {
        lists[begin] = merge(lists[begin], lists[currEnd]);
        begin++;
        currEnd--;

        if (begin >= currEnd) {
          end = currEnd;
        }
      }
    }

    return lists[0];
  }
  
  private ListNode merge(ListNode one, ListNode two) {
    ListNode dummy = new ListNode();
    ListNode curr = dummy;

    while (one != null && two != null) {
      if (one.val < two.val) {
        curr.next = one;
        curr = curr.next;
        one = one.next;
      } else {
        curr.next = two;
        curr = curr.next;
        two = two.next;
      }
    }

    if (one != null) {
      curr.next = one;
    }

    if (two != null) {
      curr.next = two;
    }
    return dummy.next;
  }
}