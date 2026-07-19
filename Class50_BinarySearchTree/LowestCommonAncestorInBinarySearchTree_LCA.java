/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        if(root == null){
            return null;
        }

        if(Math.min(p.val, q.val) <= root.val && root.val <= Math.max(p.val, q.val)){
            return root;
        }
        else if(root.val < p.val && root.val < q.val){
            return lowestCommonAncestor(root.right, p, q);
        }
        else{
            return lowestCommonAncestor(root.left, p, q);
        }
        
    }
}