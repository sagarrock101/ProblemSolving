package gfg;

public class KadanesAlgorithm {
    public static int maxSubarraySum(int arr[], int n){
        //-1,-2,-3,-4
        //1,2,3,-2,5
        if(arr.length == 1)
            return 0;
        int maxSoFar = Integer.MIN_VALUE, maxEndingHere = 0;
        for (int i = 0; i < arr.length; i++) {
            maxEndingHere += arr[i];
            if (maxEndingHere < arr[i])
                maxEndingHere = arr[i];

            if (maxEndingHere > maxSoFar)
                maxSoFar = maxEndingHere;

        }

        return maxSoFar;
    }
}
