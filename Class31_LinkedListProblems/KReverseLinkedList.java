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
    public int lengthOfLL(ListNode head){
        int len = 0;
        ListNode temp = head;
        while(temp != null){
            len++;
            temp = temp.next;
        }
        return len;
    }

    public ListNode kReverseRecursive(ListNode head, int k, int lenOfLL){
        if(head == null || lenOfLL < k){
            return head;
        }

        // Step-1: Reverse current group of size k
        ListNode prev = null, curr = head, nxt = null;
        int i=0;
        while(i < k){
            nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxt;
            i++;
        }

        // Step-2: Recursive call
        head.next = kReverseRecursive(curr, k, lenOfLL - k);
        return prev;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        int lenOfLL = lengthOfLL(head);

        return kReverseRecursive(head, k, lenOfLL);
    }
}