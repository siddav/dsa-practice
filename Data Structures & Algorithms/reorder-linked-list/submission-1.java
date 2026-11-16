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
        ListNode s = head;
        ListNode f = head.next;
        while(f!=null && f.next!=null) {
            s = s.next;
            f = f.next.next;
        }
        ListNode rightHalf = s.next;
        s.next = null;
        // reverse second half
        ListNode prev = null;
        ListNode cur = rightHalf;
        while(cur != null) {            
            ListNode t = cur.next;
            cur.next = prev;
            prev = cur;
            cur = t;
        }
        // prev is head of second half
        ListNode sh = prev;
        ListNode fh = head;
        while(fh!=null&&sh!=null) {
            ListNode t1 = fh.next;
            ListNode t2 = sh.next;
            fh.next = sh;
            sh.next = t1;
            sh = t2;
            fh = t1;
        }
    }
}
