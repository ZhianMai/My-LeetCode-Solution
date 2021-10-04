/**
* Problem #2
*/
class AddingTwoNumbers {
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode answerHead = new ListNode(0);
    ListNode currentAnswerNode = answerHead;

    int tempSum = 0;
    int tenLarger = 0;

    while(l1 != null && l2 != null){
      tempSum = l1.val + l2.val + tenLarger;
      tenLarger = (tempSum - (tempSum % 10)) / 10;
      currentAnswerNode.next = new ListNode(tempSum % 10);
      l1 = l1.next;
      l2 = l2.next;
      currentAnswerNode = currentAnswerNode.next;
    }

    if(l2 != null){
      l1 = l2;
    }

    while(l1 != null){
      tempSum = l1.val + tenLarger;
      tenLarger = (tempSum - (tempSum % 10)) / 10;
      currentAnswerNode.next = new ListNode(tempSum % 10);
      l1 = l1.next;
      currentAnswerNode = currentAnswerNode.next;
    }

    if(tenLarger == 1){
      currentAnswerNode.next = new ListNode(1);
    }
    return answerHead.next;
  } // end addTwoNumbers()
}