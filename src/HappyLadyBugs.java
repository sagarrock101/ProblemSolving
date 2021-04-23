import java.util.HashMap;
import java.util.Map;

public class HappyLadyBugs {
    public String happyLadybugs(String b) {
        HashMap<Character, Integer> stringHashMap = new HashMap<>();
        int dashCount = 0;
        int charCount = 0;
        int max = Integer.MIN_VALUE;
        if (b.length() == 1) {
            if (b.charAt(0) == '_')
                return "YES";
        }
        for (int i = 0; i < b.length(); i++) {
            if (!stringHashMap.containsKey(b.charAt(i))) {
                stringHashMap.put(b.charAt(i), 1);
            } else stringHashMap.put(b.charAt(i), stringHashMap.get(b.charAt(i)) + 1);
        }

        for (Map.Entry<Character, Integer> characterIntegerEntry : stringHashMap.entrySet()) {
//            System.out.println(characterIntegerEntry.getKey() + " " + characterIntegerEntry.getValue());
            if (characterIntegerEntry.getKey() == '_')
                dashCount = characterIntegerEntry.getValue();
            if (characterIntegerEntry.getValue() >= 2 && characterIntegerEntry.getKey() != '_')
                charCount = characterIntegerEntry.getValue();
            else {
                if (characterIntegerEntry.getKey() != '_')
                    charCount = 1;
            }
        }

        if(dashCount >= 2 && charCount == 0 ) {
            return "YES";
        }

//        if (dashCount == 0 && charCount == 1)
//            return "NO";

        if (dashCount >= 1 && charCount >= 2) {
            return "YES";
        }

        return "NO";
    }

}
