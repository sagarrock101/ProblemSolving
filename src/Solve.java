import gfg.*;

import java.io.IOException;
import java.util.ArrayList;

public class Solve {

    public static void main(String args[]) throws IOException {

        RearrangeArrayAlt.rearrange(new int[]{10,20,30,40,50,60,70,80,90,100,110}, 11);

//        System.out.println(KadanesAlgorithm.maxSubarraySum(new int[]{-1,-2,-3,-4}, 5));

//        MergeTwoArrays.merge(new long[]{1,3,5,7}, new long[]{0,2,6,8,9}, 4, 5);

//        System.out.println(CountTriplets.countTriplets(new int[]{2, 3, 4}, 4));

//
//        System.out.println(SubArrayWithGivenSum.subarraySum(new int[]{135, 101, 170,125, 79, 159, 163, 65, 106, 146, 82, 28 ,162, 92, 196 ,143, 28, 37,192, 5, 103, 154, 93, 183,
//                22, 117, 119, 96, 48, 127, 172, 139, 70, 113, 68, 100,36, 95, 104, 12, 123, 134
//        }, 5, 468));

//        System.out.println(Arrays.toString(RestoreTheArrayFromAdjacentPairs.restoreArray(new int[][]{
//                {2,1},
//                {3,4},
//                {3,2}
//        })));

//        System.out.println(MaximumErasure.maximumUniqueSubarray(new int[]{4, 2, 4, 5, 6}));
//        System.out.println(MaximumErasure.maximumUniqueSubarray(new int[]{5,2,1,2,5,2,1,2,5}));


//        System.out.println(MaximumRepeatingSubstring.maxRepeating("ababc", "ab"));

//        System.out.println(LetterCombinationsOfAphoneNumber.letterCombinations("23"));

//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String lines = br.readLine();
//        String[] nums = lines.split(" ");
//        int t = Integer.parseInt(nums[0]);
//        while (t-->0) {
//            lines = br.readLine();
//            String[] nums2 = lines.split(" ");
//            int[][] arr = new int[Integer.parseInt(nums2[0])][Integer.parseInt(nums2[0])];
////            String[] strings = lines.trim().split("\\s+");
//            for(int i = 0; i < arr.length; i++) {
//                String[] strings = br.readLine().split(" ");
//                for(int j = 0; j < arr[i].length; j++) {
//                    arr[i][j] = Integer.parseInt(strings[j]);
//                }
//            }
//            System.out.println(MonkAndInversion.countTheInversion(arr));;
//        }

    }

    public static String smallestString(int operations, String s) {
        //abcdefghijklmnopqrstuvwxyz
//        zya
        String temp = "";
        char[] alphabets = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        ArrayList<Character> characterArrayList = new ArrayList<>();
        for (int i = 0; i < alphabets.length; i++) {
            characterArrayList.add(alphabets[i]);
        }

        if (s.length() == 1) {
            return incAlphabet(s.charAt(0), operations, characterArrayList, temp);
        }

        //zya
        int i = 0;
        for (; i < s.length() - 1; i++) {
            if (s.charAt(i) > s.charAt(i + 1)) {
                if (operations > 0) {
                    temp += incAlphabet(s.charAt(i), 1, characterArrayList, temp);
                    operations--;
                }
            }
        }

        if (i == s.length()) {
            if (s.charAt(s.length() - 1) != 'a')
                temp += incAlphabet(s.charAt(s.length() - 1), operations, characterArrayList, temp);
        }

        return temp;
    }

    public static String incAlphabet(char s, int operations, ArrayList<Character> characterArrayList, String temp) {
        int idx = 0;
        int value = characterArrayList.indexOf(s) + operations;
        if (value > 25) {
            idx = (value - 1) - 25;
            temp += characterArrayList.get(idx);
        } else {
            temp += characterArrayList.get(value);
        }
        return temp;
    }

    public static void printArray(int arr[][]) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }
}

