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
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null || left == right) {
            return head;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        // Move prev to the node just before the left position
        for (int i = 0; i < left - 1; i++) {
            prev = prev.next;
        }

        ListNode pres = prev.next;
        ListNode next = pres.next;

        // Perform the reversal
        for (int i = 0; i < right - left; i++) {
            pres.next = next.next;
            next.next = prev.next;
            prev.next = next;
            next = pres.next;
        }

        return dummy.next;
    }
}
