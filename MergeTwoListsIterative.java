// Definition for singly-linked list
class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; }
}

class SolutionIterative {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1); // dummy head
        ListNode current = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }

        // Attach the remaining nodes
        if (list1 != null) current.next = list1;
        if (list2 != null) current.next = list2;

        return dummy.next; // skip dummy
    }
}

public class MergeTwoListsIterative {
    public static void main(String[] args) {
        // Create first list: 1 -> 2 -> 4
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);

        // Create second list: 1 -> 3 -> 4
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        SolutionIterative sol = new SolutionIterative();
        ListNode merged = sol.mergeTwoLists(l1, l2);

        System.out.print("Merged List (Iterative): ");
        while (merged != null) {
            System.out.print(merged.val + " ");
            merged = merged.next;
        }
    }
}
