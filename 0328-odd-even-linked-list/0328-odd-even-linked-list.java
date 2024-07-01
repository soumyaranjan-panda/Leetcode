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
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode oddNode = head;
        ListNode evenNode = oddNode.next;
        ListNode temp = oddNode;
        ListNode temp2 = evenNode;
        while(temp != null && temp.next != null && temp2 != null){
            temp.next = temp.next.next;
            if (temp2.next != null){
                temp2.next = temp2.next.next;
            }
            
            temp = temp.next;
            temp2 = temp2.next;
        }
        while(oddNode.next != null){
            oddNode = oddNode.next;
        }
        oddNode.next = evenNode;
        return head;
    }
}