import java.util.Stack;

public class LengthOfLongestValidSubstring {
    public int getTheLongestSubstring(String b) {
        int counter = 0;

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < b.length(); i++) {
            if (b.charAt(i) == '(') {
                stack.push(b.charAt(i));
            } else {
                if (!stack.isEmpty()) {
                    counter += 2;
                    stack.pop();
                }
            }
        }
        return counter;
    }
}
