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
    
    class Pair{
        Node node;
        int level;
        
        Pair(Node n, int level){
            this.node = n;
            this.level = level;
        }
    }
    
    public ArrayList<Integer> Kdistance(Node root, int k) {
        // code here
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 0));     // adds at Last in q
        
        ArrayList<Integer> ans = new ArrayList<Integer>();
        while(!q.isEmpty()){
            Pair frontPair = q.poll();      // pops from front
            Node curNode = frontPair.node;
            int curLevel = frontPair.level;
            
            if(curLevel == k){
                ans.add(curNode.data);
            }
            
            if(curNode.left != null){
                q.offer(new Pair(curNode.left, curLevel+1));
            }
            
            if(curNode.right != null){
                q.offer(new Pair(curNode.right, curLevel+1));
            }
        }
        
        return ans;
    }
};









