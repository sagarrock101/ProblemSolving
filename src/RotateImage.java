import java.util.ArrayList;

public class RotateImage {

    /*
     * 1,4,7
     * 2,5,6
     * 3,8,9
     *
     * 1,4,7
     * 2,5,8
     * 3,6,9
     *
     * 100,200,300,700
     * 500,400,600,890
     * 1200,800,900,1008
     * 1224,422, 199, 250
     *
     *
     * 100,500,1200,1224
     * 200,400,800,422
     * 300,600,900,199
     * 700,890,1008,250
     * */

    public void rotate(int[][] matrix) {
        transpose(matrix);
        swap(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

    }

    private void swap(int[][] matrix) {
        for(int i = 0; i < matrix.length; i++) {
            int k = matrix[i].length - 1;
            for(int j = 0; (k >= matrix.length/2) && j <= (matrix[i].length / 2); j++, k--) {
                if(j != k) {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[i][k];
                    matrix[i][k] = temp;
                }
            }
        }
    }

    public void transpose(int[][] matrix) {
        int temp = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix[i].length; j++) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}
