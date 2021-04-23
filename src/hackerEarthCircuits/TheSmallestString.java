package hackerEarthCircuits;

public class TheSmallestString {

    public String smallestString(int operations, String s) {
        //abcdefghijklmnopqrstuvwxyz
//        twx
        String temp = "";
        for(int i = 0; i < s.length() - 1; i++) {
            if((int)(s.charAt(i)) > (int)(s.charAt(i + 1))) {
                while (operations-- > 0)
                   temp += (int)(s.charAt(i) + 1);
            } else temp += s.charAt(i);
        }
        return temp;
    }

}
