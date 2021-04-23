import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RestoreTheArrayFromAdjacentPairs {
    public static int[] restoreArray(int[][] adjacentPairs) {
        Map<Integer, List<Integer>> map = new HashMap<>();

        for(int[] pair: adjacentPairs) {
            map.computeIfAbsent(pair[0], l -> new ArrayList<>()).add(pair[1]);
            map.computeIfAbsent(pair[1], s -> new ArrayList<>()).add(pair[0]);
        }

        int n = adjacentPairs.length + 1, k = 0, prev = -1;
        int[] ans = new int[n];
        for(Map.Entry<Integer, List<Integer>> m : map.entrySet()) {
            if(m.getValue().size() == 1) {
                ans[k] = m.getKey();
            }
        }

        while (k < n - 1) {
            for(int next: map.remove(ans[k])) {
                if(next != prev) {
                    prev = ans[k];
                    ans[++k] = next;
                    break;
                }
            }
        }

        return ans;


//        Map<Integer, List<Integer>> adj = new HashMap<>();
//        for (int[] pair : adjacentPairs) { // Loop through the input and build the corresponding graph.
//            adj.computeIfAbsent(pair[0], l -> new ArrayList<>()).add(pair[1]);
//            adj.computeIfAbsent(pair[1], s -> new ArrayList<>()).add(pair[0]);
//        }
//        /*
//        *  [2,1] [3,4] [3,2]
//        *
//        * 2 -> 1, 3
//        * 1 -> 2
//        * 3 -> 4,2
//        * 4 -> 3
//        *
//        * 1 2 3 4
//        *  ans 1, 2, 3,
//        * */
//        int n = adjacentPairs.length + 1, prev = -1, k = 0; // prev is initialized as a dummy value.
//        int[] ans = new int[n];
//        for (var e : adj.entrySet()) {
//            if (e.getValue().size() == 1) { // locate an end.
//                ans[0] = e.getKey(); // start from the end.
//                break;
//            }
//        }
//        while (k < n - 1) {
//            for (int next : adj.remove(ans[k])) { // locate the corresponding pair.
//                if (next != prev) { // Not the already found neighbor?
//                    prev = ans[k]; // prev pointer move to current element.
//                    ans[++k] = next; // save next element.
//                    break;
//                }
//            }
//        }
//        return ans;
    }
}
