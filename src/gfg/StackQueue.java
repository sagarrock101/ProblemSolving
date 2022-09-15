package gfg;

import java.util.Iterator;
import java.util.Stack;

public class StackQueue {
    public static Stack<Integer> s1 = new Stack<Integer>();
    public static Stack<Integer> s2 = new Stack<Integer>();

    //2 3 4
    //3

    //Function to push an element in queue by using 2 stacks.
    public static void Push(int x) {
        // Your code here
        if (s1.isEmpty() && !s2.isEmpty()) {
            while (!s2.isEmpty()) {
                s1.push(s2.pop());
            }
        }
       s1.push(x);
    }


    //Function to pop an element from queue by using 2 stacks.
    public static int Pop() {
        // Your code here
        if (!s1.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
        return  (!s2.isEmpty()) ? s2.pop() : -1;
    }
}
