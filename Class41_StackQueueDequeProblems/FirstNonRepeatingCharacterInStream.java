class Solution {
    
    class DLLNode{
        char data;
        DLLNode next;
        DLLNode prev;
        
        public DLLNode(char data){
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }
    
    private void removeFromDLL(DLLNode node){
        node.next.prev = node.prev;
        node.prev.next = node.next;
        node.next = null;
        node.prev = null;
    }
    
    private void addLastInDLL(DLLNode tail, DLLNode node){
        node.next = tail;
        node.prev = tail.prev;
        tail.prev = node;
        node.prev.next = node;
    }

    public String firstNonRepeating(String s) {
        DLLNode head = new DLLNode('$');        // $ -> dummy data
        DLLNode tail = new DLLNode('$');        // $ -> dummy data
        head.next = tail;
        tail.prev = head;
        
        DLLNode[] nodeAddr = new DLLNode[26];
        boolean[] repeated = new boolean[26];
        
        Arrays.fill(nodeAddr, null);
        Arrays.fill(repeated, false);
        
        StringBuilder sbAns = new StringBuilder();
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            
            if(repeated[ch - 'a']){
                // freq already >= 2
                if(head.next == tail){
                    // no node in DLL
                    sbAns.append("#");
                }
                else{
                    sbAns.append(head.next.data);
                }
                continue;
            }
            else if(nodeAddr[ch - 'a'] != null){
                // freq = 1 -> element has occured 1 time in the past
                // today it is coming 2nd time
                repeated[ch - 'a'] = true;
                removeFromDLL(nodeAddr[ch - 'a']);
                nodeAddr[ch - 'a'] = null;
            }
            else{
                // freq = 0 in past
                // today it is coming 1st time -> So add at last in DLL
                DLLNode newNode = new DLLNode(ch);
                addLastInDLL(tail, newNode);
                nodeAddr[ch - 'a'] = newNode;
            }
            
            if(head.next == tail){
                // no node in DLL
                sbAns.append("#");
            }
            else{
                sbAns.append(head.next.data);
            }
        }
        
        return sbAns.toString();
    }
}