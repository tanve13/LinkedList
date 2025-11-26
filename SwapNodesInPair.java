public class SwapNodesInPair {

   
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    static class Solution {
        public ListNode swapPairs(ListNode head) {
            ListNode dummy = new ListNode(0);
            dummy.next = head;

            ListNode curr = dummy;

            while (curr.next != null && curr.next.next != null) {
                ListNode first = curr.next;
                ListNode second = curr.next.next;

                // Swap
                first.next = second.next;
                second.next = first;
                curr.next = second;

                // Move to next pair
                curr = first;
            }

            return dummy.next;
        }
    }

    public static void main(String[] args) {
        // Create sample list: 1 -> 2 -> 3 -> 4
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        Solution sol = new Solution();
        ListNode swapped = sol.swapPairs(head);

        // Print result
        System.out.print("Swapped List: ");
        while (swapped != null) {
            System.out.print(swapped.val + " ");
            swapped = swapped.next;
        }
    }
}
