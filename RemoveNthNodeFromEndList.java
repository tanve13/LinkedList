// Remove Nth Node From End of List — Easy Runtime Code
public class RemoveNthNodeFromEndList {
    // Linked List Node Definition
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
        }
    }

    // Function to remove Nth node from end
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        // Dummy node to handle edge cases easily
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode first = dummy;
        ListNode second = dummy;

        // Move 'first' pointer n+1 steps ahead
        for (int i = 0; i <= n; i++) {
            first = first.next;
        }

        // Move both pointers until 'first' reaches null
        while (first != null) {
            first = first.next;
            second = second.next;
        }

        // Remove the nth node
        second.next = second.next.next;

        // Return updated list
        return dummy.next;
    }

    // Helper function to print list
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null) System.out.print(" -> ");
            head = head.next;
        }
        System.out.println();
    }

    // Main function (you can run this directly)
    public static void main(String[] args) {
        // Create linked list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.print("Original list: ");
        printList(head);

        int n = 2;
        head = removeNthFromEnd(head, n);

        System.out.print("After removing " + n + "th node from end: ");
        printList(head);
    }
}
