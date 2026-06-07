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
        ListNode oHead = head;
        ListNode eHead = head.next;
        ListNode oTemp = oHead;
        ListNode eTemp = eHead;
        
        while(oTemp != null && eTemp != null && eTemp.next != null){
            oTemp.next = eTemp.next;
            oTemp = oTemp.next;

            eTemp.next = oTemp.next;
            eTemp = eTemp.next;
        }

        oTemp.next = eHead;
        return oHead;
    }
}