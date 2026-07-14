/*
Definition for Node
class Node {
    int data;
    Node left;
    Node right;

    Node(int val) {
        data = val;
        left = null;
        right = null;
    }
};
*/

class Solution {
    
    public void kDistanceDownwards(Node root, int k, ArrayList<Integer> ans){
        if(root == null){
            return;
        }
        if(k == 0){
            ans.add(root.data);
            return;
        }
        kDistanceDownwards(root.left, k-1, ans);
        kDistanceDownwards(root.right, k-1, ans);
    }
    
    public ArrayList<Integer> Kdistance(Node root, int k) {
        ArrayList<Integer> ans = new ArrayList<>();
        kDistanceDownwards(root, k, ans);
        return ans;
    }
};



