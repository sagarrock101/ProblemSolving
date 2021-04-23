package hacerEarthPracticeProblems;

public class MonkAndRotation {
    public static int[] rotate(int[] arr, int k) {
        while (k-- > 0) {
            int last = arr[arr.length - 1];
            for(int i = arr.length - 2; i >= 0; i--) {
                arr[i+1] = arr[i];
            }
            arr[0] = last;
        }
        return arr;
    }

    public static void rotateOptimized(int[] arr, int k) {

        for(int i = 0; i < arr.length; i++) {

        }
    }
}
