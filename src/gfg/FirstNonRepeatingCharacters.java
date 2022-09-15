package gfg;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class FirstNonRepeatingCharacters {

    public static String FirstNonRepeating(String str)
    {
        //aabc
        //a#bb
        int[] freq = new int[26];
        StringBuilder ans = new StringBuilder();
        Queue<Character> queue = new LinkedList<>();
        Arrays.fill(freq, 0);
        for (int i = 0; i < str.length(); i++) {
            queue.add(str.charAt(i));
            freq[str.charAt(i) - 97]++;
            while (!queue.isEmpty() && freq[queue.peek() - 97] != 1) {
                queue.poll();
            }
            if (!queue.isEmpty()) {
                ans.append(queue.peek());
            } else {
                ans.append("#");
            }
        }
        return ans.toString();
    }

}
