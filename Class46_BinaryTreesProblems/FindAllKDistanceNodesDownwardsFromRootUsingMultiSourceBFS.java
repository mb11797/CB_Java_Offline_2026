/*
Definition for Node
class Node {
    int data;
    Node left;
    Node right;

    Node(int val) {
        data = val;
        left = null;
        right = null;
    }
};
*/

class Solution {
    public ArrayList<Integer> Kdistance(Node root, int k) {
        // code here
        Queue<Node> q = new LinkedList<>();
        q.offer(root);     // adds at Last in q
        
        ArrayList<Integer> ans = new ArrayList<Integer>();
        int level = 0;
        while(!q.isEmpty()){
            int sz = q.size();
            for(int i=0; i<sz; i++){
                Node frontNode = q.poll();
                
                if(level == k){
                    ans.add(frontNode.data);
                }
                else{
                    if(frontNode.left != null){
                        q.offer(frontNode.left);
                    }
    
                    if(frontNode.right != null){
                        q.offer(frontNode.right);
                    }
                }
            }
            if(level == k){
                break;
            }
            level++;
        }
        
        return ans;
    }
};









