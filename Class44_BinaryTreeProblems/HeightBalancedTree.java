/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    class HBPair{
        int height;
        boolean isBalanced;

        public HBPair(){

        }

        public HBPair(int ht, boolean isBal){
            height = ht;
            isBalanced = isBal;
        }
    }

    HBPair isBalancedHelper(TreeNode root){
        if(root == null){
            return new HBPair(0, true);
        }

        HBPair lftPair = isBalancedHelper(root.left);
        HBPair rytPair = isBalancedHelper(root.right);

        HBPair curPair = new HBPair();
        if(lftPair.isBalanced && rytPair.isBalanced && Math.abs(lftPair.height - rytPair.height) <= 1){
            curPair.isBalanced = true;
        }

        curPair.height = 1 + Math.max(lftPair.height, rytPair.height);
        return curPair;
    }

    public boolean isBalanced(TreeNode root) {
        return isBalancedHelper(root).isBalanced;
    }
}