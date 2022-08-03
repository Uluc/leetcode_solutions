//https://leetcode.com/problems/rotate-image/discuss/18879/AC-Java-in-place-solution-with-explanation-Easy-to-understand.
public class Solution {
  public void rotate(int[][] matrix) {
    //1. Declare a variable to store the number of rows.
    int n = matrix.length;
    //2. For loop to transpose the matrix
      for(int i = 0; i<n; i++){
          for(int j = i; j<matrix[0].length; j++){
              //2.1. Swap elements at index i and j in the matrix with each other. 
              int temp = matrix[i][j];
              matrix[i][j] = matrix[j][i];
              matrix[j][i] = temp;
          }
      }
      //3. For loop for horizontally flipping the matrix
      for(int i =0 ; i<n; i++){
          for(int j = 0; j<n/2; j++){
              //3.1 Swap the elements at the current index with the elements at the opposite index
              int temp =  matrix[i][j];
              matrix[i][j] = matrix[i][n-1-j];
              matrix[i][n-1-j] = temp;
          }
      }
  }
}
