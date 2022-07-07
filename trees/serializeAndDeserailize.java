// Serialize and Deserialize Binary Tree Leetcode
// https://leetcode.com/problems/serialize-and-deserialize-binary-tree/

// Solution: https://leetcode.com/problems/serialize-and-deserialize-binary-tree/discuss/74253/Easy-to-understand-Java-Solution
public class Codec {

    // Declare a global splitter to separate the values in the string.
    // Declare a nullNode to replace null values
    private static final String spliter = ",";
    private static final String nullNode = "X";

    //Method to turn tree to string
    public String serialize(TreeNode root) {
        //1. Declare a string to store the serialized tree.
        StringBuilder sb = new StringBuilder();
        //2. Call helper method to serialize the tree.
        buildString(root, sb);
        //3. Return the string.
        return sb.toString();
    }
    //Method to turn tree into string. 
    private void buildString(TreeNode node, StringBuilder sb) {
        //1. If node is null, return.
        if (node == null) {
            //2. Append nullNode to the string.
            sb.append(nullNode).append(spliter);
        } else {
            //3. Append the node value to the string.
            sb.append(node.val).append(spliter);
            //4. Call helper method to serialize the left and right subtrees.
            buildString(node.left, sb);
            buildString(node.right,sb);
        }
    }
    // Turn string to tree
    public TreeNode deserialize(String data) {
        //1. Declare a LinkedList to store the values 
        Deque<String> nodes = new LinkedList<>();
        //2. Add all the values to the LinkedList.
        nodes.addAll(Arrays.asList(data.split(spliter)));
        //3. Call helper method to turn the LinkedList to a tree.
        return buildTree(nodes);
    }
    
    // Helper method to turn LinkedList to tree
    private TreeNode buildTree(Deque<String> nodes) {
        //1. Get the first value in the LinkedList.
        String val = nodes.remove();
        //2. If the value is null, return null.
        if (val.equals(nullNode)) return null;
        //3. Otherwise, create a new node with the value.
        else {
            //3.1. Create a new node with the value.
            TreeNode node = new TreeNode(Integer.valueOf(val));
            //3.2 Create left and right subtrees.
            node.left = buildTree(nodes);
            node.right = buildTree(nodes);
            //3.3 Return the node.
            return node;
        }
    }
  }