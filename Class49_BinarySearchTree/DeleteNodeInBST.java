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
    public TreeNode deleteNode(TreeNode root, int key) {
        
        if(root == null){
            return null;
        }

        if(root.val < key){
            root.right = deleteNode(root.right, key);
        }
        else if(root.val > key){
            root.left = deleteNode(root.left, key);
        }
        else{
            // root.val == key
            // 3 Cases: 
            if(root.left == null && root.right == null){
                // Case 1: Leaf Node
                return null;
            }
            else if(root.left == null || root.right == null){
                // Case 2: Single Child Node
                // return root.left == null ? root.right : root.left;
                if(root.left == null){
                    // Single child is right 
                    return root.right;
                }
                else{
                    // Single child is left 
                    return root.left;
                }
            }
            else{
                // Case 3: 2 Child Node -> replace root value with just next smaller 
                // just next smaller -> right most element in left subtree of root 
                TreeNode temp = root.left;
                while(temp.right != null){
                    temp = temp.right;
                }
                root.val = temp.val;
                root.left = deleteNode(root.left, temp.val);
            }
        }

        return root;
    }
}