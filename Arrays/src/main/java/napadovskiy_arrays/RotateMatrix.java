package napadovskiy_arrays;

/**
	*Class RotateMatrix для поворота массива
	*@author napadovskiy
	*@since 08.08.2016
	*@version 1
*/

class RotateMatrix {
	/**
		*поворот массива
	*/
    public int[][] RotateArray(int[][] matrix) {
		int[][] newMatrix = new int[matrix.length][matrix.length];
        for (int i =0; i < matrix.length; i++){
            for (int j =0; j < matrix.length; j++){
                newMatrix[j][i] = matrix[i][j];
            }
        }
		return newMatrix;
	}
}	