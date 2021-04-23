public class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {
        //eaihgfoahgoahgoahgo
        int i = 0;
        int j = s.length() - 1;
        String matchedString1 = "";
        String matchedString2 = "";

        while (i < s.length() && j > 0) {
            if (s.charAt(i) == s.charAt(j)) {
                matchedString1 += s.charAt(i);
                if (i != j) {
                    matchedString2 += s.charAt(j);
                }
                System.out.println(matchedString1 + " " + matchedString2);
            } else {
                matchedString1 = "";
                matchedString2 = "";
            }

            if (i == j)
                break;

            i++;
            j--;
        }

        return matchedString1 + matchedString2;
    }
}
