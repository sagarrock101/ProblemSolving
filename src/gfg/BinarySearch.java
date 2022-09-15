package gfg;

public class BinarySearch {
    public static int binSrch(int arr[], int x, int start, int end, int mid) {
        int s = start;
        int e = end;
        int m = (s + e) / 2;
//        1, 2, 3, 4, 5, 6
//        0 , 1, 2, 3, 4, 5
        while (s <= e) {
            if (x < arr[m]) {
                e = m - 1;
                m = (s + e) / 2;
            } else if (x > arr[m]) {
                s = m + 1;
                m = (s + e) / 2;
            } else if (x == arr[m]) {
                return m;
            }
        }
        return -1;
    }
}
