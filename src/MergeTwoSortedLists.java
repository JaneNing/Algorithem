public class MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = null, node = null;
        int base1, base2;
        while (l1 != null || l2 != null) {
            base1 = l1 == null ? 51 : l1.val;
            base2 = l2 == null ? 51 : l2.val;
            if (base1 < base2) {
                if (head == null) {
                    head = node = l1;
                } else {
                    node.next = l1;
                    node = node.next;
                }
                l1 = l1.next;
            } else {
                if (head == null) {
                    head = node = l2;
                } else {
                    node.next = l2;
                    node = node.next;
                }
                l2 = l2.next;
            }
        }
        return head;
    }

    private class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
