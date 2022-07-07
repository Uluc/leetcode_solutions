//Invert Binary Tree
// https://leetcode.com/problems/invert-binary-tree/
public TreeNode invertTree(TreeNode root) {
    //1. If root is null, no tree return null
    if (root == null) {
        return null;
    }

    //2. Create a queue to store the nodes and add the root to the queue
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);

    //3. Breadth-first search
    while(!queue.isEmpty()) {
        TreeNode node = queue.poll();

        //3.1 Swap the left and right children 
        TreeNode left = node.left;
        node.left = node.right;
        node.right = left;

        //3.2 Add the children to the queue
        if(node.left != null) {
            queue.offer(node.left);
        }
        if(node.right != null) {
            queue.offer(node.right);
        }
    }
    //4. Return the root
    return root;
}
