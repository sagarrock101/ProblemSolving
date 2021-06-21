package codeChef;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class ShortestRoute {

    public static int minRoute(int n, int m, int[] trains, int destination) {
        // 1 1 0 0 0 2 0 1 2 0
        //
        // 1 2 3 4 5 6 7 8 9 10
        // 5

        ArrayList<Integer> leftRightMins = new ArrayList<>(n - destination);
        ArrayList<Integer> rightLeftMins = new ArrayList<>(n - destination);
        Collections.fill(leftRightMins, Integer.MAX_VALUE);
        Collections.fill(rightLeftMins, Integer.MAX_VALUE);
        for (int i = destination - 1; i >= 0; i--) {
            if (trains[i] == 1) {
                leftRightMins.add(destination - (i + 1));
                break;
            }
        }

        for (int i = destination - 1; i < n; i++) {
            if (trains[i] == 2) {
                rightLeftMins.add((i + 1) - destination);
                break;
            }
        }
        if (leftRightMins.size() > 0 && rightLeftMins.size() > 0)
          return  Math.min(leftRightMins.get(leftRightMins.size() - 1), rightLeftMins.get(rightLeftMins.size() - 1));
        else if(!leftRightMins.isEmpty())
            return leftRightMins.get(leftRightMins.size() - 1);
        else if(!rightLeftMins.isEmpty())
            return rightLeftMins.get(rightLeftMins.size() - 1);
        else return -1;

        //        for(int i = destination; i < n; i++)

    }

    public static int[] minTimeRequired(int n, int m, int[] trains, int[] travellers) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int[] res = new int[m];
        for (int i = 0; i < trains.length; i++) {
            if (trains[i] != 0)
                hashMap.put(i + 1, trains[i]);
        }


        for (int i = 0; i < travellers.length; i++) {
            res[i] = getShortest(travellers[i], hashMap);
        }

        return res;
    }


    public static int getShortest(int traveller, HashMap<Integer, Integer> hashMap) {
        int res = 0;
        int minDist = Integer.MAX_VALUE;


        if (traveller == 1) {
            return res;
        }
        for (Integer stnTrain : hashMap.keySet()) {
            if (traveller == stnTrain) {
                return res;
            }

            if (hashMap.get(stnTrain) == 1 && traveller >= stnTrain
                    || hashMap.get(stnTrain) == 2 && traveller <= stnTrain) {
                int distanceDiff = Math.abs(stnTrain - traveller);
                minDist = Math.min(minDist, distanceDiff);
            }
        }
        res = (minDist == Integer.MAX_VALUE) ? -1 : minDist;
        return res;
    }
}
