import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class LongestSubString {
    //dfdv
    public int lengthOfLongestSubstring(String s) {
       int i = 0, j = 0;
       int max = 0;
       HashSet<Character> hs = new HashSet<>();
       while (j < s.length()) {
           if(!hs.contains(s.charAt(j))) {
               hs.add(s.charAt(j));
               max = Math.max(hs.size(), max);
           } else {
               hs.remove(s.charAt(i++));
           }
       }
       return max;
    }
}
