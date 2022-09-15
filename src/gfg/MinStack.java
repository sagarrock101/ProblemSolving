package gfg;

import java.util.Stack;

public class MinStack {

    int minEle = Integer.MAX_VALUE;
    Stack<Integer> s = new Stack<>();

    //2 , 1
    // 3

    /*returns min element from stack*/
    int getMin() {
        // Your code here
        if (s.isEmpty()) return -1;
        for (Integer value :
                s) {
            if (value < minEle) {
                minEle = value;
            }
        }
        return minEle;
    }

    /*returns poped element from stack*/
    int pop() {
        // Your code here
        return  (!s.isEmpty()) ? s.pop() : -1;
    }

    /*push element x into the stack*/
    void push(int x) {
        // Your code here
        s.push(x);
    }
}
