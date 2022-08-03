//Same Tree Leetcode
// https://leetcode.com/problems/same-tree/

public boolean isSameTree(TreeNode p, TreeNode q) {
    //1. If both p and q are null, return true
    if(p == null && q == null) return true;
    //2. If either p or q is null, return false (one of them is null)
    if(p == null || q == null) return false;
    
    //3. If p and q are not null, compare the values of p and q if equal, compare the left and right subtrees
    if(p.val == q.val)
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    //4. If p and q are not null, if not equal trees must be different.
    else
        return false;
}