import java.util.HashMap;
import java.util.Map;

public class HappyLadyBugs2 {
    private boolean allBugsHavePair = false;
    private boolean isDashPresent = false;
    private Integer dashCount = 0;

    public String happyLadybugs(String b) {
        //[
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (Character c : b.toCharArray()) {
            if (!hashMap.containsKey(c))
                hashMap.put(c, 1);
            else hashMap.put(c, hashMap.get(c) + 1);
        }
        for (Map.Entry<Character, Integer> e : hashMap.entrySet()) {
//            System.out.println(e.getKey() + " " + e.getValue());
            if (e.getKey() == '_') {
                dashCount = e.getValue();
                isDashPresent = true;
            }
            if (e.getKey() != '_' && !(e.getValue() >= 2)) {
               return "NO";
            }

        }
//        R R G G B X B X
//        i,j
        if(!hashMap.containsKey('_')) {
            char last = b.charAt(0);
            int count = 0;
            for(int i = 0; i < b.length(); i++) {
                char cur = b.charAt(i);
                if(cur == last) {
                    count++;
                } else {
                    if(count < 2) {
                        return "NO";
                    } else {
                        count = 1;
                    }
                }
                last = cur;
            }
            return "YES";
        } else {
            return "YES";
        }



//        if(!hashMap.containsKey('_'))
//        {
//            int count = 0;
//            char last = b.charAt(0);
//            for(int i = 0; i < b.length(); i++)
//            {
//                char curr = b.charAt(i);
//
//                if(curr == last)
//                {
//                    count++;
//                }
//                else
//                {
//                    if(count < 2)
//                    {
//                        return "NO";
//                    }
//                    else{count = 1;}
//                }
//                last = curr;
//            }
//            return "YES";
//        }
//        else //It has an _ so it is YES
//        {
//            return "YES";
//        }

    }

}
