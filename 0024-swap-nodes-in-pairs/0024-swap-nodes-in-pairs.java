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
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode f = head;
        ListNode s = f.next;
        while(s != null) {
            swap(f, s);
            if(f.next.next == null || s.next.next == null)
                return head;
            f = f.next.next;
            s = s.next.next;
        }
        return head;
    }
    void swap(ListNode x, ListNode y) {
        int temp = x.val;
        x.val = y.val;
        y.val = temp;
    }
}