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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        return reverse(remove(reverse(head), n));
    }
    public ListNode remove(ListNode head, int index){
        if(head == null || head.next == null){
            return null;
        }
        ListNode temp = new ListNode();
        if(index == 1){
            return head.next;
        }
        temp.next = head;
        for(int i = 0; i < index-1; i++){
            temp = temp.next;
        }
        if(temp != null){
            temp.next = temp.next.next;
        }
        return head;
    }
    public ListNode reverse(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode prev = null;
        ListNode pres = head;
        ListNode next = pres.next;
        while(pres != null){
            pres.next = prev;
            prev = pres;
            pres = next;
            if(next != null){
                next = next.next;
            }
        }
        return prev;
    }
}