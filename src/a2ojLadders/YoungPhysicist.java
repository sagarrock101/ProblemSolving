package a2ojLadders;

import java.util.Arrays;

public class YoungPhysicist {
    public static String equilibriumCheck(int[][] arr) {

        int sum = 0;

       for(int i = 0; i < arr.length; i++) {
           for(int j = 0; j < arr[i].length; j++) {
                sum += arr[j][i];
           }
           if(sum !=0)
               return "NO";
       }
       return "YES";
    }
}
