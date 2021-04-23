import java.util.HashMap;

public class CountAndSayRepeat {
    public String countAndSay(int n) {
        String str = "";
        if(n == 1) return "1";
        if(n == 2) return "11";

        str = "11";

        for(int i = 3; i <= n; i++) {
            StringBuilder t = new StringBuilder();
            str += "$";
            int count = 1;
            for(int j = 1; j < str.length(); j++) {
                if(str.charAt(j-1) == str.charAt(j))
                    count++;
                else {
                    t.append(count);
                    t.append(str.charAt(j - 1));
                    count = 1;
                }
            }
            str = t.toString();
        }


        return str;
    }
}
