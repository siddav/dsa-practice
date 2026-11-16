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
    private static class ListK
            implements Comparable<ListK>
    {
        ListNode l;

        ListK(ListNode l)
        {
            this.l = l;
        }

        @Override
        public int compareTo(ListK o)
        {
            return Integer.compare(this.l.val, o.l.val);
        }
    }
    public ListNode mergeKLists(ListNode[] lists)
    {
        PriorityQueue<ListK> pq = new PriorityQueue<>();
        for (ListNode node : lists) {
            if(node != null) {
                pq.offer(new ListK(node));
            }
        }
        ListNode dummy = new ListNode();
        ListNode current = dummy;
        while(!pq.isEmpty()) {
            ListK m = pq.poll();
            current.next = new ListNode(m.l.val);
            current = current.next;
            if(m.l.next != null) {
                pq.offer(new ListK(m.l.next));
            }
        }
        return dummy.next;
    }
}
