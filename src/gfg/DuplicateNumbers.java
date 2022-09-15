package gfg;

import java.util.ArrayList;

public class DuplicateNumbers {
    public static ArrayList<Integer> getDuplicates(int arr[], int n) {
        ArrayList<Integer> result = new ArrayList<>();
        for(int i=0;i<n;i++){
            int temp = arr[i]% n;
            arr[temp] += n;
        }
        for(int i=0;i<n;i++){
            int temp = arr[i]/ n;
            if(temp>1){
                result.add(i);
            }
        }
        if(result.size()==0) {
            result.add(-1);
        };
        return result;
    }
}
