import java.util.Arrays;
import java.util.HashSet;

public class SetMatrixZeros {
    public void setZeroes(int[][] matrix) {
        HashSet<String> hs = new HashSet<>();
        HashSet<Integer> paintedRows = new HashSet<>();
        HashSet<Integer> paintedCols = new HashSet<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    hs.add(i + "," + j);
                }
            }
        }
        System.out.println(hs);

        for (String string : hs) {
            String[] spliter = string.split(",");
            int row = Integer.parseInt(spliter[0]);
            int col = Integer.parseInt(spliter[1]);
            paintMatrixWithZeros(matrix, row, col, paintedRows, paintedCols);
        }
        System.out.println(paintedRows);
        System.out.println(paintedCols);

        Solve.printArray(matrix);
    }

    public void paintMatrixWithZeros(int[][] matrix, int row, int col, HashSet<Integer> paintedRows, HashSet<Integer> paintedCols) {

        if(!paintedRows.contains(row)) {
            Arrays.fill(matrix[row], 0);
            paintedRows.add(row);
        }

        if(!paintedCols.contains(col)) {
            for (int k = 0; k < matrix.length; k++) {
                matrix[k][col] = 0;
            }
            paintedCols.add(col);
        }
    }
}
