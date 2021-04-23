import java.util.ArrayList;
import java.util.HashSet;

public class LinkedListOperations {


    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode start = new ListNode(0);
        ListNode slow = start, fast = start;
        slow.next = head;

        //Move fast in front so that the gap between slow and fast becomes n
        for (int i = 1; i <= n + 1; i++) {
            fast = fast.next;
        }
        //Move fast to the end, maintaining the gap
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        //Skip the desired node
        slow.next = slow.next.next;
        ListNode tempNode = start;
        while (tempNode != null) {
            System.out.println(tempNode.val);
            tempNode = tempNode.next;
        }
        return start.next;
    }

    public ListNode removeNthFromEndRepeat(ListNode head, int n) {
        ListNode dummyNode = new ListNode(0);
        ListNode fast = dummyNode, slow = dummyNode;
        slow.next = head;
        //0,1,2,3,4,5 n = 2
        //      fast
        for (int i = 1; i <= n + 1; i++) {
            fast = fast.next;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;
        ListNode tempNode = dummyNode.next;
        printNodes(tempNode);
        return dummyNode.next;
    }

    public static void printNodes(ListNode node) {
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    /*
    * ListNode start = new ListNode(0);
    ListNode slow = start, fast = start;
    slow.next = head;
    *
    *   0, 1,2,3,4,5
       slow  fast
       *   slow  fast
       *       slow  fast
       *
    //Move fast in front so that the gap between slow and fast becomes n
    for(int i=1; i<=n+1; i++)   {
        fast = fast.next;
    }
    //Move fast to the end, maintaining the gap
    while(fast != null) {
        slow = slow.next;
        fast = fast.next;
    }
    //Skip the desired node
    slow.next = slow.next.next;
    return start.next;*/

    public ListNode reverseList(ListNode head) {
        //swap values
        //null <- 1 -> 2 -> 2 -> 1
        //        p    h    t
        ListNode prev = null;
        while (head != null) {
            ListNode tempNode = head.next;
            head.next = prev;
            prev = head;
            head = tempNode;

        }

        return prev;

    }

    public ListNode reverseListAndAddData(ListNode head, ArrayList<Integer> arrayList) {
        //swap values
        //null <- 1 -> 2 -> 2 -> 1
        //        p    h    t
        ListNode prev = null;
        while (head != null) {
            arrayList.add(head.val);
            ListNode tempNode = head.next;
            head.next = prev;
            prev = head;
            head = tempNode;

        }

        return prev;

    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null)
            return null;
        else if (l1 == null)
            return l2;
        else if (l2 == null)
            return l1;

        ListNode result = new ListNode(0);
        ListNode curNode = result;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                curNode.next = l1;
                l1 = l1.next;
            } else {
                curNode.next = l2;
                l2 = l2.next;
            }
            curNode = curNode.next;
        }

        if (l1 != null) {
            curNode.next = l1;
        }

        if (l2 != null) {
            curNode.next = l2;
        }

        return result.next;
    }

    public boolean isPalindrome(ListNode head) {

        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        if (fast != null)
            slow = slow.next;

        ListNode prev = null;
        while (slow != null) {
            ListNode temp = slow.next;
            slow.next = prev;
            prev = slow;
            slow = temp;
        }

        slow = prev;
        while (slow != null) {
            if (head.val != slow.val) {
                return false;
            }
            slow = slow.next;
            head = head.next;
        }

        return true;
    }

    public boolean hasCycle(ListNode head) {

//        1->2->3->4->5
        ListNode fast = head, slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow)
                return true;
        }
        return false;
    }


    /*           ^
                 I
    *  1 -> 2 -> 2 -> 1
    *            s    t
    * */

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
}
