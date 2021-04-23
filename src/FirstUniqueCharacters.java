import java.util.TreeMap;

public class FirstUniqueCharacters {
    public int firstUniqChar(String s) {
        TreeMap<Character, Integer> tm = new TreeMap<>();
        int firstIndex = -1;
        int secondIndex = -1;
        for (int i = 0; i < s.length(); i++) {
            if (!tm.containsKey(s.charAt(i)))
                tm.put(s.charAt(i), 1);
            else tm.put(s.charAt(i), tm.get(s.charAt(i)) + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            if (tm.get(s.charAt(i)) == 1) {
                firstIndex = i;
                break;
            }
        }

        for (int i = 0; i < s.length(); i++) {
            if (tm.get(s.charAt(i)) == 1) {
                if (firstIndex != i)
                    secondIndex = i;
                break;
            }
        }

        if(firstIndex != -1)
            return firstIndex;
        else return secondIndex;
    }
}
