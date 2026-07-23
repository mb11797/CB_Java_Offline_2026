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

    class MyNodeComparator implements Comparator<ListNode>{
        public int compare(ListNode a, ListNode b){
            // ascending order -> a.val will come first
            // Method-1
            // return a.val - b.val;

            // Method-2
            return Integer.compare(a.val, b.val);
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> minPQ = new PriorityQueue<>(new MyNodeComparator());

        for(ListNode head: lists){
            if(head != null)
                minPQ.offer(head);
        }

        if(minPQ.isEmpty()){
            return null;
        }

        ListNode mergedLLHead = null;
        ListNode mergedLLTail = mergedLLHead;

        while(!minPQ.isEmpty()){
            ListNode minmNode = minPQ.poll();

            if(mergedLLHead == null){
                mergedLLHead = mergedLLTail = minmNode;
            }
            else{
                mergedLLTail.next = minmNode;
                mergedLLTail = mergedLLTail.next;
            }

            if(minmNode.next != null){
                minPQ.offer(minmNode.next);
            }
        }
        return mergedLLHead;
    }
}