/*
Definition for Node
class Node {
    int data;
    Node left, right;

    Node(int val) {
        this.data = val;
        this.left = null;
        this.right = null;
    }
}
*/

class Solution {
    public ArrayList<Integer> rightView(Node root) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        if(root == null)
            return ans;
            
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        int curLevel = 0;
        while(!q.isEmpty()){
            int sz = q.size();
            for(int i=0; i<sz; i++){
                Node frontNode = q.poll();
                
                if(i == sz-1){
                    ans.add(frontNode.data);
                }
                
                if(frontNode.left != null){
                    q.offer(frontNode.left);
                }
                
                if(frontNode.right != null){
                    q.offer(frontNode.right);
                }
            }
        }
        
        return ans;
    }
}