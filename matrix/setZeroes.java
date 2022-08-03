public class setZeroes {

  public void setZeroes(int[][] matrix) {
    //1. Boolean first column to indicate if the first column has a zero
    Boolean isCol = false;
    //2. Get the length of the matrix
    int row = matrix.length;
    int col = matrix[0].length;

    //3. Iterate through the matrix rows
    for (int i = 0; i < row; i++) {

      // 3.1 If anythign in the first column is zero set isCol to true
      if (matrix[i][0] == 0) {
        isCol = true;
      }

      // 3.2 Iterate through the matrix columns
      for (int j = 1; j < col; j++) {
        //3.2.1 If an element is zero, we set the first element of the corresponding row and column to 0
        if (matrix[i][j] == 0) {
          matrix[0][j] = 0;
          matrix[i][0] = 0;
        }
      }
    }

    //4. Iterate matrix starting at the second row and column
    for (int i = 1; i < row; i++) {
      for (int j = 1; j < col; j++) {
        //4.1 If the first element of the row or column is zero, we set the element to 0
        if (matrix[i][0] == 0 || matrix[0][j] == 0) {
          matrix[i][j] = 0;
        }
      }
    }

    //5. If the first element of the first column is zero, we set the first column to 0
    if (matrix[0][0] == 0) {
      for (int j = 0; j < col; j++) {
        matrix[0][j] = 0;
      }
    }

    //6. If isCol is true, we set the first column to 0 
    if (isCol) {
      for (int i = 0; i < row; i++) {
        matrix[i][0] = 0;
      }
    }
  }
}

