/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* reverseKGroup(ListNode* head, int k) {
        if(!head || k == 1)
            return head;
        ListNode*preHead = new ListNode(-1);
        preHead->next = head;
        ListNode*curr = preHead;
        ListNode*nxt = preHead;
        ListNode*prev = preHead;
        
        int len = 0;
        curr = curr->next;
        while(curr != NULL){
            len++;
            curr = curr->next;
        }
        
        while(len >= k){
            curr = prev->next;
            nxt = curr->next;
            for(int i=1; i<k; i++){
                curr->next = nxt->next;
                nxt->next = prev->next;
                prev->next = nxt;
                nxt = curr->next;
            }
            
            prev = curr;
            len -= k;
        }
        
        return preHead->next;
    }
};