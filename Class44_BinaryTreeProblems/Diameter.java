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
    private class DHPair{
        public int diameter;
        public int height;
        
        public DHPair(int d, int h){
            diameter = d;
            height = h;
        }
    }

    public DHPair diameterOfBinaryTreeHelper(TreeNode root) {
        if(root == null){
            return new DHPair(0, 0);
        }
        DHPair lftAns = diameterOfBinaryTreeHelper(root.left);
        DHPair rytAns = diameterOfBinaryTreeHelper(root.right);

        int diameterThroughSelf = lftAns.height + rytAns.height;
        int curAnsDiameter = Math.max(diameterThroughSelf, 
                                        Math.max(lftAns.diameter, rytAns.diameter));
        int curAnsHeight = 1 + Math.max(lftAns.height, rytAns.height);
        DHPair curAns = new DHPair(curAnsDiameter , curAnsHeight);
        return curAns;
    }

    public int diameterOfBinaryTree(TreeNode root) {
        DHPair ans = diameterOfBinaryTreeHelper(root);
        return ans.diameter;
    }
}










