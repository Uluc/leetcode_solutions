//Add search word data structure to the Trie
//https://leetcode.com/problems/design-add-and-search-words-data-structure/
//Solution: https://leetcode.com/problems/design-add-and-search-words-data-structure/discuss/59718/Easy-to-understand-Java-solution-using-Trie-and-Recursion-with-explanation


public class WordDictionary {

    //TrieNode class
    private class TrieNode {
        //1. Declare flag for isWord and HashMap to store children
        private boolean isWord;
        private HashMap<Character, TrieNode> children;
        
        //2. Constructor for TrieNode
        public TrieNode() {
            isWord = false;
            children = new HashMap<Character, TrieNode>();
        }
    }
    
    //Declare root node
    private TrieNode root = new TrieNode();

    // Method to add a word to the Trie
    public void addWord(String word) {
        //1. Declare a pointer to the root node.
        TrieNode curr = root;
        //2. Iterate through the word.
        for (int i = 0; i < word.length(); i++) {
            //3.1. If the character is not present in the children of the current node, create a new node.
            if (!curr.children.containsKey(word.charAt(i))) {
                curr.children.put(word.charAt(i), new TrieNode());
            }
            //3.2 Move the pointer to the child node.
            curr = curr.children.get(word.charAt(i));
        }
        //4. Set the isWord flag to true.
        curr.isWord = true;
    }

    // Method that searches if the word is in the data structure.
    public boolean search(String word) {
        return searchHelper(root, 0, word);
    }
    
    //Helper method to search a word in the Trie
    private boolean searchHelper(TrieNode node, int pos, String word) {
        //1. If the whole word is searched, return isWord.
        if (pos == word.length()) {
            return node.isWord;
        }
        //2. If size is 0 we reach the leaf before finishing scanning the word
        if (node.children.size() == 0) {
            return false;
        }
        
        //1. if the character at current position is '.', recursive check whether the remaing word is in the trie
        if (word.charAt(pos) == '.') {
            //2. Iterate through the children of the current node.
            for (Character c : node.children.keySet()) {
                //3.1. If the child node is present, recursive call the searchHelper method.
                if (searchHelper(node.children.get(c), pos + 1, word)) {
                    //3.2. If the child node is present and the word is found, return true.
                    return true;
                }
            }
        }
        
        //2. If character at position 'pos' is neither equal to the node nor '.', return false
        if (!node.children.containsKey(word.charAt(pos))) {
            return false;
        }
        
        //3. If character at current position matches the node, recursively search the remaining word
        return searchHelper(node.children.get(word.charAt(pos)), pos + 1, word);
    }
}