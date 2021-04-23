import java.util.ArrayList;
import java.util.HashMap;

public class IntersectionOfTwoArrays {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
//        4,4,8,9,9
//        4,5,9
// list 4
//
        for (int a: nums1) {
            if(!hashMap.containsKey(a))
                hashMap.put(a, 1);
            else hashMap.put(a, hashMap.get(a) + 1);
        }

        ArrayList<Integer> arrayList = new ArrayList<>();
        for(int b: nums2) {
            if(hashMap.get(b) != null && hashMap.get(b) > 0) {
                hashMap.put(b, hashMap.get(b) - 1);
                arrayList.add(b);
            }
        }
        return arrayList.stream().mapToInt(i -> i).toArray();
    }
}
