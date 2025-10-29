// Runnable version of "Remove Duplicates from Sorted List"
public class RemoveDuplicatesFromSortedList {

    // Definition for singly-linked list
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    // Your Solution class (as provided)
    public static class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            // Edge case: empty list or single node
            if (head == null || head.next == null) return head;

            ListNode current = head;

            // Traverse the list
            while (current != null && current.next != null) {
                if (current.val == current.next.val) {
                    // Skip duplicate node
                    current.next = current.next.next;
                } else {
                    // Move forward if no duplicate
                    current = current.next;
                }
            }

            return head;
        }
    }

    // Helper method to print linked list
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null) System.out.print(" -> ");
            head = head.next;
        }
        System.out.println();
    }

    // Main method to run program
    public static void main(String[] args) {
        // Create sorted linked list: 1 -> 1 -> 2 -> 3 -> 3
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(3);

        System.out.print("Original List: ");
        printList(head);

        // Call your solution
        Solution sol = new Solution();
        head = sol.deleteDuplicates(head);

        System.out.print("After Removing Duplicates: ");
        printList(head);
    }
}
