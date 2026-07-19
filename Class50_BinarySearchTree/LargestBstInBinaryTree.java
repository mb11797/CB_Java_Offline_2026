/* class Node {
    int data;
    Node left, right;
    public Node(int d) {
     data = d;
     left = right = null;
   }
} */

class Solution {
    
    public static class BSTCheckUtil{
        boolean isBST;
        int size;
        int minm;
        int maxm;
        
        public BSTCheckUtil(){
            isBST = true;
            size = 0;
            minm = Integer.MAX_VALUE;
            maxm = Integer.MIN_VALUE;
        }
    }
    
    public static BSTCheckUtil largestBstRec(Node root){
        BSTCheckUtil curAns = new BSTCheckUtil();
        if(root == null){
            return curAns;
        }
        
        BSTCheckUtil leftAns = largestBstRec(root.left);
        BSTCheckUtil rightAns = largestBstRec(root.right);
        
        // check bst for current node
        if(leftAns.isBST 
        && rightAns.isBST 
        && leftAns.maxm < root.data && root.data < rightAns.minm){
            curAns.isBST = true;
            curAns.size = 1 + leftAns.size + rightAns.size;
            curAns.minm = Math.min(leftAns.minm, root.data);
            curAns.maxm = Math.max(rightAns.maxm, root.data);
        }
        else{
            curAns.isBST = false;
            curAns.size = Math.max(leftAns.size, rightAns.size);
        }
        return curAns;
    }
    
    static int largestBst(Node root) {
        return largestBstRec(root).size;
    }
}