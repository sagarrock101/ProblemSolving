package gfg;

import java.util.ArrayList;
import java.util.Arrays;

public class SpiralTraversal {
    //Function to return a list of integers denoting spiral traversal of matrix.
    public static void spirallyTraverse(int matrix[][], int r, int c) {
        int top = 0;
        int bottom = matrix.length - 1;
        int right = matrix[0].length - 1;
        int left = 0;
        int dir = 0;
        ArrayList<Integer> arrayList = new ArrayList<>();
        while (top <= bottom && left <= right) {
            if (dir == 0) {
                for (int i = left; i <= right; i++) {
                    System.out.print(matrix[top][i] + " ");
                    arrayList.add(matrix[top][i]);
                }
                top++;
            } else if (dir == 1) {
                for (int i = top; i <= bottom; i++) {
                    System.out.print(matrix[i][right] + " ");
                    arrayList.add(matrix[i][right]);
                }
                right--;
            } else if (dir == 2) {
                for (int i = right; i >= left; i--) {
                    System.out.print(matrix[bottom][i] + " ");
                    arrayList.add(matrix[bottom][i]);
                }
                bottom--;
            } else if (dir == 3) {
                for (int i = bottom; i >= top; i--) {
                    System.out.print(matrix[i][left] + " ");
                    arrayList.add(matrix[i][left]);
                }
                left++;
            }
            dir = (dir + 1) % 4;
        }
    }
}
