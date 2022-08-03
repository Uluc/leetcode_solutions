// max path sum in a binary tree leetcode
//https://leetcode.com/problems/binary-tree-maximum-path-sum/


//Solution from: https://leetcode.com/problems/binary-tree-maximum-path-sum/discuss/39875/Elegant-Java-solution

public class Solution {
    //Global variable to store the max path sum
    int max = Integer.MIN_VALUE;
    
    //Method to find the max path sum in a binary tree
    public int maxPathSum(TreeNode root) {
        helper(root);
        return max;
    }
    
    //Helper method to find the max path sum in a binary tree
    int helper(TreeNode root) {
        //1. If root is null, return 0
        if (root == null) return 0;
        //2. If root is not null, find the max path sum in the left and right subtrees
        int left = Math.max(helper(root.left),0);
        int right = Math.max(helper(root.right), 0);
        
        //3. Update the max path sum
        max = Math.max(max, root.val + left + right);
        
        //4. Return the max path sum of the left or right subtree
        return root.val + Math.max(left, right);
    }
}