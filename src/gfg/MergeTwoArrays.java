package gfg;

import java.util.Arrays;

public class MergeTwoArrays {

    private static int nextGap(int gap)
    {
        if (gap <= 1)
            return 0;
        return (gap / 2) + (gap % 2);
    }

    //Function to merge the arrays.
    public static void merge(long arr1[], long arr2[], int n, int m)
    {
        //before
        //1 3 5 7
        //0 2 6 8 9
        //after
        //0 1 2 3
        //5 6 7 8 9
        int i, j, gap = n + m;
        for (gap = nextGap(gap); gap > 0;
             gap = nextGap(gap))
        {
            // comparing elements in the first
            // array.
            for (i = 0; i + gap < n; i++)
                if (arr1[i] > arr1[i + gap])
                {
                    long temp = arr1[i];
                    arr1[i] = arr1[i + gap];
                    arr1[i + gap] = temp;
                }

            // comparing elements in both arrays.
            for (j = gap > n ? gap - n : 0;
                 i < n && j < m;
                 i++, j++)
                if (arr1[i] > arr2[j])
                {
                    long temp = arr1[i];
                    arr1[i] = arr2[j];
                    arr2[j] = temp;
                }

            if (j < m)
            {
                // comparing elements in the
                // second array.
                for (j = 0; j + gap < m; j++)
                    if (arr2[j] > arr2[j + gap])
                    {
                        long temp = arr2[j];
                        arr2[j] = arr2[j + gap];
                        arr2[j + gap] = temp;
                    }
            }
        }

        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
    }

    public static void merge2(long arr1[], long arr2[], int n, int m) {


        //{1, 2, 3, 5, 8, 9 }
        //{10, 13, 15, 20}

        //        {1, 5, 9, 10, 15, 20};
//        {2, 3, 8, 13};

        //1, 3, 5, 7
        //0, 1, 2, 3
        //0, 2, 6, 8, 9
        //0, 1, 2, 3, 4
        int gap = m + n;//5
        int i = 0, j = 0;
        for(gap = nextGap(gap); gap > 0; gap = nextGap(gap)) {
            for (i = 0; i + gap < arr1.length; i++) {
                if(arr1[i] > arr1[i + gap]) {
                    arr1[i] += arr1[i + gap] - (arr1[i + gap] = arr1[i]);
                }
            }

            for( j = (gap > arr1.length) ? (gap - arr1.length) : 0; i < n && j < m; i++, j++) {
                if(arr1[i] > arr2[j]) {
                    arr1[i] += arr2[j] - (arr2[j] = arr1[i]);
                }
            }

            if(j < m) {
                for (j = 0; j + gap < m; j++) {
                    if(arr2[j] > arr2[j + gap]) {
                        arr2[j] += arr2[j + gap] - (arr2[j + gap] = arr2[j]);
                    }
                }
            }
        }
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
    }

    public static void swap(int index1, int index2, long[] arr1, long[] arr2) {
        long temp;
        temp = arr1[index1];
        arr1[index1] = arr2[index2];
        arr2[index2] = temp;
    }

}
