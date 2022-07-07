//Trie prefix tree leetcode
// https://leetcode.com/problems/implement-trie-prefix-tree/

//Solution: https://leetcode.com/problems/implement-trie-prefix-tree/discuss/1509492/Java-or-Fast-or-Easy

class Trie {
    //Class for Node
    class Node {
       //1. Declare a map to store the children of the node and flag for isEnd.
        Node [] children;
        boolean isEnd;
        //2. Constructor for Node
        Node(){
            children = new Node[26];
            isEnd = false;
        }
    }
    
    //Declare a root node
    final private Node root;
    
    //Constructor for Trie
    public Trie() {
        root = new Node();
    }
    
    //Method to insert a word into the Trie
    public void insert(String word) {
        //1. Declare a pointer to the root node.
        Node curr = root;
        
        //2. Iterate through the word.
        for(int i = 0;i<word.length();i++){
            //3.1. Cache character at index i.
            char ch = word.charAt(i);
            
            //3.2. If the character is not present in the children of the current node, create a new node.
            if(curr.children[ch - 'a'] == null){
                curr.children[ch - 'a'] = new Node();
            }
            //3.3 Move the pointer to the child node.
            curr = curr.children[ch - 'a'];
        }
        //4. Set the isEnd flag to true.
        curr.isEnd = true;
    }
    
    //Method to search a word in the Trie
    public boolean search(String word) {
        //1. Declare a pointer to the root node.
        Node curr = root;

        //2. Iterate through the word.
        for(int i = 0;i<word.length();i++){
            //2.1. Cache character at index i.
            char ch = word.charAt(i);
            
            //2.2. If the character is not present in the children of the current node, return false.
            if(curr.children[ch - 'a'] == null) return false;
            //2.3 Move the pointer to the child node.
            curr = curr.children[ch - 'a'];
        }
        //3. Return current node's isEnd flag.
        return curr.isEnd;
    }
    
  
    //Method to search a prefix in the Trie
    public boolean startsWith(String prefix) {
        //1. Declare a pointer to the root node.
        Node curr = root;
        //2. Iterate through the prefix.
        for(int i = 0;i<prefix.length();i++){
            //2.1. Cache character at index i.
            char ch = prefix.charAt(i);
            
            //2.2. If the character is not present in the children of the current node, return false.
            if(curr.children[ch - 'a'] == null) return false;
            //2.3 Move the pointer to the child node.
            curr = curr.children[ch - 'a'];
        }
        //3. Return true if prefix is present in the Trie.
        return true;
    }
}

