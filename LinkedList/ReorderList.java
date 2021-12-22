/**
 * Problem #143
 */
 
public class ReorderList {
  public void reorderList(ListNode head) {
    ListNode mid = findMidNodeAndBreak(head);
    mid = reverseList(mid);
    mergeList(head, mid);
  }
  
  private ListNode findMidNodeAndBreak(ListNode head) {
    if (head == null || head.next == null) {
      return null;
    }
    
    ListNode fast = head;
    ListNode slow = head;
    ListNode slowPrev = null;
    
    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      slowPrev = slow;
      slow = slow.next;
    }
    
    if (slowPrev != null) {
      slowPrev.next = null;
    }
    
    return slow;
  }
  
  private ListNode reverseList(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    
    ListNode newHead = reverseList(head.next);
    head.next.next = head;
    head.next = null;
    return newHead;
  }
  
  private void mergeList(ListNode listA, ListNode listB) {
    ListNode dummy  = new ListNode(0);
    ListNode curr = dummy;
    
    while (listA != null && listB != null) {
      curr.next = listA;
      listA = listA.next;
      curr = curr.next;
      
      curr.next = listB;
      listB = listB.next;
      curr = curr.next;
    }
    
    if (listA != null) {
      curr.next = listA;
    }
    
    if (listB != null) {
      curr.next = listB;
    }
  }
}