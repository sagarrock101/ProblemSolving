package gfg;

import java.util.Arrays;

public class MinimumPlatforms {

    static int findPlatform(int arr[], int dep[], int n)
    {
        // add your code here
        int max = 1;
        int platforms = 1;
        int i = 1;
        int j = 0;
        Arrays.sort(arr);
        Arrays.sort(dep);
        while (i < arr.length && j < dep.length) {
           if(arr[i] <= dep[j]) {
               platforms++;
               i++;
           } else if(arr[i] >= dep[j]) {
               platforms--;
               j++;
           }

           if(platforms > max)
               max = platforms;
        }
        return max;
    }

}
