/*
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
    
    public void leftViewRec(Node root, int curLevel, ArrayList<Integer> ans){
        if(root == null)
            return;
        
        if(curLevel > maxLevel){
            // means curLevel is getting visited for the very first time
            ans.add(root.data);
            maxLevel = curLevel;
        }

        leftViewRec(root.left, curLevel + 1, ans);
        leftViewRec(root.right, curLevel + 1, ans);
    }
    
    public ArrayList<Integer> leftView(Node root) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        leftViewRec(root, 0, ans);
        return ans;
    }
}




