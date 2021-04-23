package healofy;

public class MinOperations {

    public int minOperations(int[] x, int l, int r, int start, int end) {
        int operations = 0;
        int curPtr = start;
        while (curPtr < x.length || curPtr != end) {
            if(curPtr < end) {
                curPtr += r;
            } else {
                curPtr -= l;
            }
            operations++;
            if(curPtr == end)
                break;
        }
        //1,2,3,4,5,6,7,\8,9
        //

        return operations;
    }
}
