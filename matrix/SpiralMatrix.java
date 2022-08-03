class Solution {
  public List<Integer> spiralOrder(int[][] matrix) {
    //1.create a list to store the spiral order
    List<Integer> res = new LinkedList<>(); 
    //2. If the matrix is empty, return the list.
    if (matrix == null || matrix.length == 0) return res;
    //3. get the row and column size of the matrix
    int n = matrix.length, m = matrix[0].length;
    //4. create elements to viusalize the spiral order
    int up = 0;
    int down = n - 1;
    int left = 0;
    int right = m - 1;
    //5. While the size of the spiral order is less than the size of the matrix, continue.
    while (res.size() < n * m) {
        //5.1 iterate through matrix columns from left to right indexes
        for (int j = left; j <= right && res.size() < n * m; j++)
            res.add(matrix[up][j]);
        
        //5.2 iterate through matrix rows from up to down indexes
        for (int i = up + 1; i <= down - 1 && res.size() < n * m; i++)
            res.add(matrix[i][right]);
                  
        //5.3 iterate through matrix columns from right to left indexes
        for (int j = right; j >= left && res.size() < n * m; j--)
            res.add(matrix[down][j]);
        
        //5.4 iterate through matrix rows from down to up indexes
        for (int i = down - 1; i >= up + 1 && res.size() < n * m; i--) 
            res.add(matrix[i][left]);
        
        //5.5 increment the left and right indexes to expand the spiral order
        left++; right--; up++; down--; 
    }
    //6. return the spiral order
    return res;
  }
}