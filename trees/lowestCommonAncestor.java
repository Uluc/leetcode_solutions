//Lowest common ancestor of a binary tree leetcode
// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/


public public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    //1.If root value is greater than both p and q values, then lowest common ancestor must be in the left subtree.
    if(root.val > p.val && root.val > q.val){
        //1.1 Return the left subtree
        return lowestCommonAncestor(root.left, p, q);
    }
    //2.If root value is less than both p and q values, then lowest common ancestor must be in the right subtree.
    else if(root.val < p.val && root.val < q.val){
        //2.1 Return the right subtree
        return lowestCommonAncestor(root.right, p, q);
    }
    //3.If root value is between p and q values, then the root must be the lowest common ancestor.
    else{
        //3.1 Return the root
        return root;
    }
}