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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }
        Stack<TreeNode> l2rStk = new Stack<>();
        Stack<TreeNode> r2lStk = new Stack<>();

        // push all elements of Level 0 in l2rStk
        l2rStk.push(root);
        while(!l2rStk.isEmpty() || !r2lStk.isEmpty()){
            // Step-1: work on l2rStk
            List<Integer> level1 = new ArrayList<>();
            while(!l2rStk.isEmpty()){
                TreeNode topNode = l2rStk.pop();

                level1.add(topNode.val);

                if(topNode.left != null)
                    r2lStk.push(topNode.left);

                if(topNode.right != null)
                    r2lStk.push(topNode.right);

            }

            if(level1.size() > 0){
                ans.add(level1);
            }

            // Step-2: work on r2lStk
            List<Integer> level2 = new ArrayList<>();
            while(!r2lStk.isEmpty()){
                TreeNode topNode = r2lStk.pop();

                level2.add(topNode.val);

                if(topNode.right != null)
                    l2rStk.push(topNode.right);
                
                if(topNode.left != null)
                    l2rStk.push(topNode.left);
            }

            if(level2.size() > 0){
                ans.add(level2);
            }
        }
        return ans;
    }
}