/* Structure of linked list Node
class Node {
    int data;
    Node next;
    Node(int val) {
        data = val;
        next = null;
    }
} */

/*
https://www.geeksforgeeks.org/problems/remove-loop-in-linked-list/1
*/

class Solution {
    public static void removeLoop(Node head) {
        // code here
        Node slow = head;
        Node fast = head;
        
        boolean cycleMilGayi = false;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                cycleMilGayi = true;
                break;
            }
        }
        
        if(!cycleMilGayi)
            return;
        
        slow = head;
        if(slow == fast){
            // Case where head node is the starting node of cycle
            while(fast.next != slow){
                fast = fast.next;
            }
            fast.next = null;
            return;
        }
        while(slow.next != fast.next){
            slow = slow.next;
            fast = fast.next;
        }
        
        fast.next = null;
        return;
    }
}