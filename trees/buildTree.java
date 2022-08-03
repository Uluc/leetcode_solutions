//Build tree from inorder and preorder traversal
//https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
//Solution: https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/discuss/34538/My-Accepted-Java-Solution

public TreeNode buildTree(int[] preorder, int[] inorder) {
    //The helper function to return tree root.
    return helper(0, 0, inorder.length - 1, preorder, inorder);
}
 
/*
 * Parameters:
 * startPre: start index of preorder array
 * startIn: start index of inorder array
 * endIn: end index of inorder array
 * preorder: the preorder array
 * inorder: the inorder array
 */
private TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
    //1. If preOrder or inOrder starts surpass the end, return null.
    if (preStart > preorder.length - 1 || inStart > inEnd) {
        return null;
    }
    //2. Create a new node with the value of preorder[preStart]
    TreeNode root = new TreeNode(preorder[preStart]);

    //3. Index of current root in inorder
    int inIndex = 0; 

    //4. Find the index of current root in inorder
    for (int i = inStart; i <= inEnd; i++) {
        //4.1 If current root is found, set inIndex to i
        if (inorder[i] == root.val) {
            inIndex = i;
            break;
        }
    }
    //5. Call the helper function to build the left subtree
    /*
     * Parameters: 
     * preStart: preStart incremented by one to skip the current root
     * inStart: remains like before
     * inEnd: inIndex - 1 since we are not including the current root in the left subtree
     * preorder: preorder array doesn't change
     * inOrder: inorder array doesn't change
     */
     
    root.left = helper(preStart + 1, inStart, inIndex - 1, preorder, inorder);


    //6. Call the helper function to build the right subtree
    /*
     * Parameters: 
     * preStart: prestart itself plus the index of the current root in the inorder array minus the start of inorder array incremented by one to skip the current root
     * inStart: inIndex + 1 since we are including the current root in the right subtree
     * inEnd: inEnd remains like before
     * preorder: preorder array doesn't change
     * inOrder: inorder array doesn't change
     */
    root.right = helper(preStart + inIndex - inStart + 1, inIndex + 1, inEnd, preorder, inorder);

    //7. Return the root
    return root;
}
