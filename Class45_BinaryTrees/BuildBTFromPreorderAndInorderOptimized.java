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
    int preorderIdx;
    Map<Integer, Integer> inElmtVsIdx;

    public TreeNode buildTreeHelper(int[] preorder, int[] inorder, int beg, int en){
        if(beg > en){
            return null;
        }

        int rootElmt = preorder[preorderIdx++];
        TreeNode root = new TreeNode(rootElmt);

        int rootIdxInInorder = inElmtVsIdx.get(rootElmt);

        System.out.println(rootIdxInInorder);

        root.left = buildTreeHelper(preorder, inorder, beg, rootIdxInInorder-1);
        root.right = buildTreeHelper(preorder, inorder, rootIdxInInorder+1, en);
        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        inElmtVsIdx = new HashMap<>();
        for(int i=0; i<inorder.length; i++){
            inElmtVsIdx.put(inorder[i], i);
        }
        preorderIdx = 0;
        return buildTreeHelper(preorder, inorder, 0, preorder.length-1);
    }
}