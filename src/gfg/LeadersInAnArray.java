package gfg;

import java.util.ArrayList;
import java.util.Arrays;

public class LeadersInAnArray {
    static ArrayList<Integer> leaders(int arr[], int n) {
        // Your code here
        //{16,17,4,3,5,2}
        int max = Integer.MIN_VALUE;
        ArrayList<Integer> arrayList = new ArrayList<>();
        ArrayList<Integer> tempList = new ArrayList<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] >= max) {
                max = arr[i];
                arrayList.add(max);
            }
        }
        for(int i = arrayList.size() - 1; i >= 0; i--) {
            tempList.add(arrayList.get(i));
        }
        return tempList;
    }
}
