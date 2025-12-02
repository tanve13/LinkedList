public class LinkedListCycle {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int v) { val = v; }
    }

    static class Solution {
        public boolean hasCycle(ListNode head) {
            if (head == null || head.next == null) return false;

            ListNode slow = head;
            ListNode fast = head.next;

            while (fast != null && fast.next != null) {
                if (slow == fast) return true;

                slow = slow.next;
                fast = fast.next.next;
            }
            return false;
        }
    }

    public static void main(String[] args) {
        // making a tiny cursed list with a cycle
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        a.next = b;
        b.next = c;
        c.next = b;  // cycle here

        Solution sol = new Solution();
        System.out.println(sol.hasCycle(a));  // true
    }
}
