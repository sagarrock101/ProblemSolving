import java.util.ArrayList;
import java.util.List;

public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        ListNode t1;
        ListNode t2;
        t1 = head;
        t2 = head;
        ArrayList<Integer> numHolder = new ArrayList<>();
        while (t1.next != null) {
            numHolder.add(t1.val);
            t1 = t1.next;
        }
        int i =0;
        numHolder.add(t1.val);
        while (t2.next != null && i < numHolder.size()) {
            if(t2.val != numHolder.get(i++))
                return false;
            t2 = t2.next;
        }

        return false;
    }

    public boolean isPalindromeOptimized(ListNode head) {
        ListNode fast;
        ListNode slow;
        fast = head;
        slow = head;
        // 1 2 2 1
        // 1 2 2
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        if (fast != null) {
            slow = slow.next;
        }

        slow = reveseNode(slow);
        fast = head;
        while (fast != null && slow != null) {
            if(fast.val != slow.val) {
                return false;
            }
            fast = fast.next;
            slow = slow.next;
        }

        return true;
    }

    public ListNode reveseNode(ListNode node) {
        ListNode prev = null;
        while (node != null) {
            ListNode next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }

        return prev;
    }
}
