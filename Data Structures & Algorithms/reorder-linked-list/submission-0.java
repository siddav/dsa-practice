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
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) {
            return;
        }
        ListNode f = head.next;
        ListNode s = head;
        while(f != null && f.next != null) {
            s = s.next;
            f = f.next.next;
        }
        ListNode s1 = s;
        s = s.next;
        Stack<ListNode> rHalf = new Stack<>();
        while(s != null) {
            rHalf.push(s);
            s = s.next;
        }
        s1.next = null;
        ListNode c = head;
        while(!rHalf.isEmpty()) {
            ListNode toInsert = rHalf.pop();
            if(c.next == null) {
                c.next = toInsert;
                toInsert.next = null;
                break;
            }
            ListNode t = c.next;
            c.next = toInsert;
            toInsert.next = t;
            c = t;
        }          
    }
}
