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

    private void findAllNodesKDistDownwards(TreeNode root, int k, List<Integer> ans){
        if(root == null){
            return;
        }

        if(k == 0){
            ans.add(root.val);
            return;
        }

        findAllNodesKDistDownwards(root.left, k-1, ans);
        findAllNodesKDistDownwards(root.right, k-1, ans);
    }

    private int findAllNodesAtDistK(TreeNode root, TreeNode target, int k, List<Integer> ans){
        if(root == null)
            return -1;
        
        if(root == target){
            findAllNodesKDistDownwards(root, k, ans);
            return 0;
        }

        int distLeft = findAllNodesAtDistK(root.left, target, k, ans);
        if(distLeft != -1){
            if(distLeft + 1 == k){
                ans.add(root.val);
            }
            else{
                findAllNodesKDistDownwards(root.right, k - (distLeft+1) - 1, ans);
            }
            return distLeft + 1;
        }

        int distRight = findAllNodesAtDistK(root.right, target, k, ans);
        if(distRight != -1){
            if(distRight + 1 == k){
                ans.add(root.val);
            }
            else{
                findAllNodesKDistDownwards(root.left, k - (distRight+1) - 1, ans);
            }
            return distRight + 1;
        }

        return -1;
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> ans = new ArrayList<>();
        findAllNodesAtDistK(root, target, k, ans);
        return ans;
    }
}