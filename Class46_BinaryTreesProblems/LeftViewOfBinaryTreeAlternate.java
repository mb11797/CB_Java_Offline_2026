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
    // int maxLevel = -1;

    class MaxLevelHelper{
        int maxLevel;
        public MaxLevelHelper(int maxLevel){
            this.maxLevel = maxLevel;
        }
    }
    
    public void leftViewRec(Node root, int curLevel, ArrayList<Integer> ans, MaxLevelHelper maxLevelHelperObj){
        if(root == null)
            return;
        
        if(curLevel > maxLevelHelperObj.maxLevel){
            // means curLevel is getting visited for the very first time
            ans.add(root.data);
            maxLevelHelperObj.maxLevel = curLevel;
        }

        leftViewRec(root.left, curLevel + 1, ans, maxLevelHelperObj);
        leftViewRec(root.right, curLevel + 1, ans, maxLevelHelperObj);
    }
    
    public ArrayList<Integer> leftView(Node root) {
        MaxLevelHelper maxLevelHelperObj = new MaxLevelHelper(-1);
        ArrayList<Integer> ans = new ArrayList<Integer>();
        leftViewRec(root, 0, ans, maxLevel);
        return ans;
    }
}




