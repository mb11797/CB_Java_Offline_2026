/*
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
    
    class Pair{
        Node node;
        int level;
        
        public Pair(Node n, int lvl){
            node = n;
            level = lvl;
        }
    }
    
    public ArrayList<Integer> leftView(Node root) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        if(root == null)
            return ans;
        int maxLevel = -1;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 0));
        
        while(!q.isEmpty()){
            Pair frontPair = q.poll();
            Node curNode = frontPair.node;
            int curLevel = frontPair.level;
            
            if(curLevel > maxLevel){
                // means curLevel is getting visited for the very first time with given curNode
                ans.add(curNode.data);
                maxLevel = curLevel;
            }
            
            if(curNode.left != null){
                q.offer(new Pair(curNode.left, curLevel + 1));
            }
            

            if(curNode.right != null){
                q.offer(new Pair(curNode.right, curLevel + 1));
            }
        }
        
        return ans;
    }
}




