public class VerifyingAnAlienDictionary {

    public boolean isAlienSorted(String[] words, String order) {
        if(words.length == 1)
            return true;
        for(int i = 0; i < words.length - 1; i++) {
            return checkForOrder(words[i], words[i+1], order);
        }
        return false;
    }

    private boolean checkForOrder(String word1, String word2, String order) {
            for(char ch2: word2.toCharArray()) {
                for(char ch1: word1.toCharArray()) {
//                   if(order.charAt(ch))
                }
            }
            return false;
    }

}
