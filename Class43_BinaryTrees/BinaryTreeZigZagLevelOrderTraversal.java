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
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        
        int level = 0;
        while(!q.isEmpty()){
            int len = q.size();
            Integer[] curLevelArr = new Integer[len];
            for(int i=0; i<len; i++){
                TreeNode fNode = q.poll();

                if(level % 2 == 0){
                    curLevelArr[i] = fNode.val;
                }
                else{
                    curLevelArr[len - i - 1] = fNode.val;
                }

                if(fNode.left != null){
                    q.offer(fNode.left);
                }

                if(fNode.right != null){
                    q.offer(fNode.right);
                }
            }

            level++;
            ArrayList<Integer> curLevelList = new ArrayList<>(Arrays.asList(curLevelArr));
            ans.add(curLevelList);
        }

        return ans;
    }

}