package hacerEarthPracticeProblems;

public class MonkAndInversion {
    public static int countTheInversion(int[][] matrix) {
        int max = matrix[0][0], maxI = -1, maxJ = -1, count = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (max > matrix[i][j]) {
                    if (maxI == -1)
                        maxI = i;
                    if (maxJ == -1)
                        maxJ = j;

                    if(maxI <= i && maxJ <= j) {
                        max = matrix[i][j];
                        maxI = i;
                        maxJ = j;
                        count++;
                        System.out.println( maxI + " " + maxJ + " " + matrix[i][j]);
                    }

                }
            }
        }
        return count;
    }
}
