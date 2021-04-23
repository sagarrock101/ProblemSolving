public class StrFirstIndex {
    public int strStr(String haystack, String needle) {
        if (haystack.isEmpty() && needle.isEmpty())
            return 0;
        else if (haystack.isEmpty() && !needle.isEmpty())
            return -1;
        else if (!haystack.isEmpty() && needle.isEmpty())
            return 0;
        String newHayStack = haystack.trim();
        String newNeedle = needle.trim();

        //aaaababba
        //bbc

        //hello
        //ll
        int i = 0;
        int j = 0;
        int firstOccurenceIdx = -1;

        while (i < newHayStack.length() && j < newNeedle.length()) {
            if (newHayStack.charAt(i) == newNeedle.charAt(j)) {
//                System.out.println(newHayStack.charAt(i) + " " + newNeedle.charAt(j));
                if (firstOccurenceIdx == -1)
                    firstOccurenceIdx = i;
                i++;
                j++;
            } else if (j > 0) {
                j = 0;
            } else {
                if (i == newNeedle.length()) {
                    i --;
                }else i++;
            }
        }
        if (j == newNeedle.length() && firstOccurenceIdx != -1)
            return firstOccurenceIdx;

        return -1;

    }
}
