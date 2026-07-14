/*
Definition for Node
class Node {
    int data;
    Node left, right;

    Node(int val) {
        this.data = val;
        this.left = null;
        this.right = null;
    }
}
*/

class Solution {
    int maxLevel = -1;
    
    private void rightViewRec(Node root, int curLevel, ArrayList<Integer> ans){
        if(root == null){
            return;
        }
        
        if(curLevel > maxLevel){
            // means curLevel is getting visited for the very first time with gievn node
            ans.add(root.data);
            maxLevel = curLevel;
        }
        
        rightViewRec(root.right, curLevel+1, ans);
        rightViewRec(root.left, curLevel+1, ans);
    }
    
    public ArrayList<Integer> rightView(Node root) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        rightViewRec(root, 0, ans);
        return ans;
    }
}

