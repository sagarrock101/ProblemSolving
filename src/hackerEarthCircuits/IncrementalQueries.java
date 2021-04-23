package hackerEarthCircuits;

public class IncrementalQueries {
    public int operationTwo(int[] arr, int startIdx, int endIdx) {
        //1,3,1,1,4,5
        //0,1,2,3,4,5

        if (arr.length == 1)
            return 1;

        int operations = 0;
        for (int i = startIdx - 1; i < endIdx - 1; i++) {
            if (arr[i] != arr[i + 1]) {
                operations++;
            }
        }

        return operations;
    }

    public void operationOne(int[] arr, int idx, int value) {
        arr[idx - 1] = value;
    }
}
