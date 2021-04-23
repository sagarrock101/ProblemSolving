public class StrFirstIndex2 {
    public int strStr(String haystack, String needle) {
        if (haystack.isEmpty() && needle.isEmpty())
            return 0;
        else if (haystack.isEmpty() && !needle.isEmpty())
            return -1;
        else if (!haystack.isEmpty() && needle.isEmpty())
            return 0;
        String newHayStack = haystack.trim();
        String newNeedle = needle.trim();
        for(int i = 0; i < newHayStack.length(); i++) {
            try {
                String pattern = newHayStack.substring(i, i + newNeedle.length());
                if(pattern.equals(newNeedle)) {
                    return i;
                }
            } catch (Exception e) {
                return -1;
            }
        }

        return -1;
    }

}
