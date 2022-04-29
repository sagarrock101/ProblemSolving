package gfg;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ParenthesisCheck {
    //Function to check if brackets are balanced or not.
   public static boolean isPar(String parenthesis) {
        // add your code here
        Map<Character, Character> characterMap = new HashMap<>();
        characterMap.put('[', ']');
        characterMap.put('(', ')');
        characterMap.put('{', '}');
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < parenthesis.length(); i++) {
            if (i == 0) {
                stack.push(parenthesis.charAt(i));
            }
            if (!stack.isEmpty() && characterMap.get(stack.peek()) != null && characterMap.get(stack.peek()) == parenthesis.charAt(i)) {
                stack.pop();
            } else {
                if (i != 0) {
                    stack.push(parenthesis.charAt(i));
                }
            }
        }

        return stack.isEmpty();
    }
}
