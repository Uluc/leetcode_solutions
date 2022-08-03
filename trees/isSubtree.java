class Solution {
    //Method to check if subtree.
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        //1. If root is null, return false.
        if (root == null) return false;
        //2. Run dfs on root and subroot.
        if (dfs(root, subRoot)) return true;
        //3. If dfs on root and subroot fails, check if subtree is in left or right subtree.
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
  
    //Method to execute dfs on subtree.
    private boolean dfs(TreeNode root, TreeNode subRoot) {
        //1. If both root and subroot are null, return true.
        if (root == null && subRoot == null) return true;
        //2. If either root or subroot is null, return false.
        if (root == null || subRoot == null) return false;
        //3. If the values of root and subroot are not equal, return false.
        if (root.val != subRoot.val) return false;
        //4. If the values of root and subroot are equal, check if the left and right subtrees are equal.
        return dfs(root.left, subRoot.left) && dfs(root.right, subRoot.right);
    }
}
  