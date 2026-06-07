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

    public ListNode reverse(ListNode head){
        ListNode prev = null, curr = head, nxt = null;
        while(curr != null){
            nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxt;
        }

        return prev;
    }

    public ListNode plusOne(ListNode head) {
        head = reverse(head);
        ListNode temp = head;
        ListNode prev = null;

        int carry = 1;
        while(temp != null || carry > 0){
            int sum = carry;

            if(temp != null){
                sum += temp.val;
                temp.val = sum % 10;
            }
            else{
                prev.next = new ListNode(sum % 10);
            }
            carry = sum / 10;
            prev = temp;
            if(temp != null)
                temp = temp.next;
        }

        head = reverse(head);
        return head;
    }
}