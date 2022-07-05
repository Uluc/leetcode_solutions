public void reorderList(ListNode head) {
    //1. If head is null 
    if(head == null) return;
    //2. Find middle of the list
    ListNode slow = head, fast = head;
    while(fast.next != null && fast.next.next != null) {
        slow = slow.next;
        fast = fast.next.next;
    }

    //3. Reverse the second half of the list
    ListNode prev = null, curr = slow.next, next = null;
    while(curr != null) {
        next = curr.next;
        curr.next = prev;
        prev = curr;
        curr = next;
    }

    //4. head2 to point into the 2nd half of the list.
    ListNode head2 = prev;
    //5. Slow.next is null to avoid cyclical list
    slow.next = null;

    //6. Merge the two lists. Iterate through the first list and add the next node to the second list.
    while(head != null && head2 != null) {
        //6.1 Create temp node to cache current head
        ListNode next1 = head.next;
        //6.2 Create temp node to cache current head2
        ListNode next2 = head2.next;
        //6.3 Set head to point to head2's next element
        head2.next = head.next;
        //6.4 Set head to point to head2
        head.next = head2;
        //6.5 head is now head2's cache and head2 is now head's cache
        head = next1;
        head2 = next2;
    }


}