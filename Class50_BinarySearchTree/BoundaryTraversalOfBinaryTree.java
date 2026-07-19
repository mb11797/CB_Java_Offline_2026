/* Node Structure
class Node {
    int data;
    Node left, right;

    Node(int val) {
        data = val;
        left = right = null;
    }
} */

class Solution {
    
    public void printLeftBoundary(Node root, ArrayList<Integer> boundary){
        if(root != null){
            if(root.left != null){
                boundary.add(root.data);
                printLeftBoundary(root.left, boundary);
            }
            else if(root.right != null){
                boundary.add(root.data);
                printLeftBoundary(root.right, boundary);
            }
        }
    }
    
    public void printLeaves(Node root, ArrayList<Integer> boundary){
        if(root != null){
            printLeaves(root.left, boundary);
            if(root.left == null && root.right == null)
                boundary.add(root.data);
            printLeaves(root.right, boundary);            
        }
    }
    
    public void printRightBoundary(Node root, ArrayList<Integer> boundary){
        if(root != null){
            if(root.right != null){
                printRightBoundary(root.right, boundary);
                boundary.add(root.data);
            }
            else if(root.left != null){
                printRightBoundary(root.left, boundary);
                boundary.add(root.data);
            }
        }
    }
    
    public ArrayList<Integer> boundaryTraversal(Node root) {
        ArrayList<Integer> boundary = new ArrayList<>();
        if(root == null){
            return boundary;
        }
        
        boundary.add(root.data);
        
        printLeftBoundary(root.left, boundary);
        printLeaves(root.left, boundary);
        printLeaves(root.right, boundary);
        printRightBoundary(root.right, boundary);
        
        return boundary;
    }
}
















