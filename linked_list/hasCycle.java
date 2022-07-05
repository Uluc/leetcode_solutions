public boolean hasCycle(ListNode head) {
    //1. declare fast and slow pointers
    ListNode slow = head, fast = head;

    //2. Loop until either fast or slow is null.
    while (fast != null && fast.next != null) {
        //2.1 Push slow node forward one element and fast forward by 2 elements
      slow = slow.next;
      fast = fast.next.next;
        //2.2 If slow meets fast that means list has cylce return true
      if (slow == fast) 
          return true;
    }
    //3. Nothing found return false
    return false;
  }