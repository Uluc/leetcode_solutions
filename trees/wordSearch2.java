//Word Search II leetcode
// https://leetcode.com/problems/word-search-ii/
//Solution: https://leetcode.com/problems/word-search-ii/discuss/59780/Java-15ms-Easiest-Solution-(100.00)

class Solution {
   
    class TrieNode {
        //1. Declare the children of the node.
        TrieNode[] next = new TrieNode[26];
        //2. Declare the word.
        String word;
    }
    
    public List<String> findWords(char[][] board, String[] words) {
        //1. Declare a list to store the result.
        List<String> res = new ArrayList<>();
        //2. Declare a trie to store the words.
        TrieNode root = buildTrie(words);
        //3. Iterate through the board.
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                //4.1. Call the helper method to search the word.
                dfs (board, i, j, root, res);
            }
        }
        //5. Return the result.
        return res;
    }

    //Depth first search method to search the word.
    /*
     * Parameters:
     * board: The board to search.
     * i: The row index of the board.
     * j: The column index of the board.
     * root: The root of the trie.
     * res: The list to store the result.
     */
    public void dfs(char[][] board, int i, int j, TrieNode p, List<String> res) {
        //1. Cache the character at index i,j.
        char c = board[i][j];
        //2. If the character is not present in the children of the current node, return.
        if (c == '#' || p.next[c - 'a'] == null) return;
        //3. move the pointer to the child node.
        p = p.next[c - 'a'];
        //4. If the word is found, add it to the result.
        if (p.word != null) { 
            res.add(p.word);
            //4.1. Set the word to null to avoid duplicates.
            p.word = null;     
        }
        //5. Mark the character as visited.
        board[i][j] = '#';



        //6. If row index is not out of bounds in the begining, search the previous row.
        if (i > 0) dfs(board, i - 1, j ,p, res); 
        //7. If column index is not out of bounds in the beginning, search the previous column.
        if (j > 0) dfs(board, i, j - 1, p, res);
        //8. If row index is not out of bounds at the end, search the next row.
        if (i < board.length - 1) dfs(board, i + 1, j, p, res); 
        //9. If column index is not out of bounds at the end, search the next column.
        if (j < board[0].length - 1) dfs(board, i, j + 1, p, res); 
        
        //10. Reset the character to original value.
        board[i][j] = c;
    }

    //Build the trie method to build the trie.
    public TrieNode buildTrie(String[] words) {
        //1. Declare a root node.
        TrieNode root = new TrieNode();
        //2. Iterate through the words.
        for (String w : words) {
            //3.1. Declare a pointer to the root node.
            TrieNode p = root;
            //3.2. Iterate through the word.
            for (char c : w.toCharArray()) {
                //3.2.1 If the character is not present in the children of the current node, add it.
                int i = c - 'a';
                if (p.next[i] == null) p.next[i] = new TrieNode();
                //3.2.2 Move the pointer to the child node.
                p = p.next[i];
            }
            //3.3. Set the word to the current word.
            p.word = w;
        }
        //4. Return the root node.
        return root;
    }
   
}