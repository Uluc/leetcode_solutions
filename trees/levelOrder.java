//  Level order traversal of a tree leetcode
// https://leetcode.com/problems/level-order-traversal/

public List<List<Integer>> levelOrder(TreeNode root) {
    //1. List of lists to store result.
    List<List<Integer>> res = new ArrayList<>();
    //2. If root is null, return empty list.
    if (root == null)
        return res;
    //3. Create a queue to store the nodes and add the root to the queue
    Queue<TreeNode> q = new LinkedList<>();
    q.add(root);
    //4. Breadth-first search
    while(!q.isEmpty()) {
        //4.1 Create a list to store the values of the current level
        int levelSize = q.size();
        List<Integer> currLevel = new ArrayList<>();
        //4.2 Populate the list with the values of the current level
        for(int i = 0; i < levelSize; i++) {
            //4.2.1 Pop the first node from the queue
            TreeNode currNode = q.poll();
            //4.2.2 Add the value of the node to the list
            currLevel.add(currNode.val);
            //4.2.3 Add the left and right children to the queue
            if (currNode.left != null)
                q.add(currNode.left);
            if (currNode.right != null)
                q.add(currNode.right);
        }
        //4.3 Add the list to the result
        res.add(currLevel);
    }
    //5. Return the result
    return res;
}
