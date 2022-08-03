public class Solution {

  //1. map to store the visited cells
  static boolean[][] visited;

  public boolean exist(char[][] board, String word) {
      //1. Map to store the visited cells
      visited = new boolean[board.length][board[0].length];
      
      //2. iterate through the board.
      for(int i = 0; i < board.length; i++){
          for(int j = 0; j < board[i].length; j++){
              //2.1 if the current cell is the first letter of the word, then check if the word can be formed by the current cell
              if((word.charAt(0) == board[i][j]) && dfs(board, word, i, j, 0)){
                  return true;
              }
          }
      }
      //3. return false if the word is not found.
      return false;
  }
  
  /* Method for Depth first Search
   * Parameters:
   * board: The board to search.
   * word: The word to search.
   * i: The row index of the board.
   * j: The column index of the board.
   * index: The index of the word.
   */
  private boolean dfs(char[][]board, String word, int i, int j, int index){
    
    //1. if the index is equal to the length of the word, then return true.
    if(index == word.length())
      return true;
      
    /*2. If row index is out of bounds, return false.
     * If column index is out of bounds, return false.
     * If the current cell is already visited, return false.
     * If the current cell is not the character at the index, return false.
     */

    if(i >= board.length || 
       i < 0 || 
       j >= board[i].length ||
       j < 0 || 
       board[i][j] != word.charAt(index) || 
       visited[i][j])
      return false;
    
    //3. mark the current cell as visited.
    visited[i][j] = true;

    //4. check if the word can be formed by the current cell and its neighbors. Go up down left right.
    if(dfs(board, word, i-1, j, index+1) || 
      dfs(board, word, i+1, j, index+1) ||
      dfs(board, word, i, j-1, index+1) || 
      dfs(board, word, i, j+1, index+1)){
      return true;
    }
    
    //5. unmark the current cell as visited.
    visited[i][j] = false;
    //6. word not found return false.
    return false;
  }
}