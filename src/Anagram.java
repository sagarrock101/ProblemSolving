import java.util.Arrays;
import java.util.HashSet;

public class Anagram {
    public boolean isAnagram(String s, String t) {
        if(t.isEmpty() && s.isEmpty())
            return true;
        else if(t.isEmpty() || s.isEmpty())
            return false;
        char[] charS = s.toCharArray();
        char[] charT = t.toCharArray();

        Arrays.sort(charS);
        Arrays.sort(charT);

        if(charS.length != charT.length) {
            return false;
        } else {
            for(int i = 0; i < charS.length; i++) {
                if(charS[i] != charT[i])
                    return false;
            }
        }

        return true;
    }

}
