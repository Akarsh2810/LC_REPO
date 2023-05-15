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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode slow = head, fast = head;
        while(--k > 0)
            fast = fast.next;
        ListNode first = fast;
        while(fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        swap(slow, first);
        return head;
    }
    void swap(ListNode slow, ListNode first) {
        int temp = slow.val;
        slow.val = first.val;
        first.val = temp;
    }
}