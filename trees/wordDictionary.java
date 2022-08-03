//Add search word data structure to the Trie
//https://leetcode.com/problems/design-add-and-search-words-data-structure/
//Solution: https://leetcode.com/problems/design-add-and-search-words-data-structure/discuss/59718/Easy-to-understand-Java-solution-using-Trie-and-Recursion-with-explanatio

public class WordDictionary {

    //TrieNode class
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
    
    //Declare root node
    private Node root = new Node();

    // Method to add a word to the Trie
    public void addWord(String word) {
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

    // Method that searches if the word is in the data structure.
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
   
}