//kth smallest element in a BST leetcode
// https://leetcode.com/problems/kth-smallest-element-in-a-bst/

class Solution {
    //Global to store the kth smallest element
    int remaining;
    
    //Method to find the kth smallest element in a BST
    public int kthSmallest(TreeNode root, int k) {
        //1. Set remaining to k
        remaining = k;
        //2. Call the helper function to find the kth smallest element
        return inOrder(root);
    }
    
    //InOrder Traversal (Left->Root->Right)
    private int inOrder(TreeNode root){
        //1. If root is null no tree left return -1 
        if(root == null) 
            return -1;
        //2. If root is not null, traverse left subtree
        int ans = inOrder(root.left);
        //3. If we found no error return ans
        if(ans != -1) 
            return ans;
        //4. If we haven't found, decrement remaining and if remaining is 0, return root.val
        remaining--;
        //5. If remaining is 0, return root value.
        if(remaining == 0)  
            return root.val;
        //6. Traverse right subtree.
        return inOrder(root.right);
    }
    
}