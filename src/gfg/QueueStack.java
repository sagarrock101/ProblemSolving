package gfg;

import java.util.LinkedList;
import java.util.Queue;

public class QueueStack {
    public static Queue<Integer> q1 = new LinkedList<Integer>();
    public static Queue<Integer> q2 = new LinkedList<Integer>();

    //Function to push an element into stack using two queues.
    public static void push(int a)
    {
        q1.add(a);
    }

    //Function to pop an element from stack using two queues.
    public static int pop()
    {
       if (q1.isEmpty()) {
            return -1;
       }
       while (q1.size() != 1) {
           q2.add(q1.poll());
       }

       Integer val = q1.poll();
       Queue<Integer> t = q1;
       q1 = q2;
       q2 = t;

        return val;
    }
}
