public ListNode mergeKLists(ListNode[] lists) {
        
    //1. Create a priority queue to function as a minimum heap.
    PriorityQueue<ListNode> minHeap = new PriorityQueue<>((node1, node2) -> {
        return node1.val - node2.val;
    });
    
    //2. Iterate through all different linked lists.
    for(ListNode node : lists) {
        //2.1 Iterate through all the elements of the current linked list.
        while(node != null) {
            //2.1.1 If null we finished the list continue to next list
            if(node == null) continue;
            //2.1.2 Add current node to minHeap
            minHeap.offer(node);
            //2.1.3 Create a node to cache current node and move current node forward one element
            ListNode cache = node;
            node = node.next;
            
            //2.1.4 Set the next pointer of the cache element to null.
            cache.next = null;
        }
    }

    //3. Set a dumm
    ListNode returnList = new ListNode();
    ListNode head = returnList;
    
    
    while(!minHeap.isEmpty()) {
        ListNode lowest = minHeap.poll();
        
        head.next = lowest;
        head = head.next;
    }
    
    return returnList.next;

}