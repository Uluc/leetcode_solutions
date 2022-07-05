public ListNode reverseList(ListNode head) {
    //1. Declare current and previous pointers
    ListNode curr = head;
    ListNode prev = null;
    
    //2. Iteratate until current node is null
    while(curr!=null){
        //2.1. Declare next node that points to the next of current node
        ListNode next = curr.next;
        //2.2 Set current to point to previous
        curr.next = prev;
        //2.3 Change the variables so prev and curr move up one node
        prev = curr;
        curr = next;
    }
    //3. return re
    return prev;
}