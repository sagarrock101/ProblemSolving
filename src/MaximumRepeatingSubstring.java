public class MaximumRepeatingSubstring {
    public static int maxRepeating(String sequence, String word) {
        if(!sequence.contains(word))
            return 0;
        StringBuilder kString = new StringBuilder();
        int count = 0;
        while (kString.length() < sequence.length()) {
            kString.append(word);
           try {
               if(sequence.contains(kString))
                   count++;
           } catch (Exception e) {
               return count;
            }
        }
        return count;
    }
}
