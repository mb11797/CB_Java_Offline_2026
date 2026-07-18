import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class BinarySearchTree{
	public static class TreeNode{
		int data;
		TreeNode left;
		TreeNode right;
		public TreeNode(int data){
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}

	public static TreeNode insertInBST(TreeNode root, int dataToInsert){

		if(root == null){
			root = new TreeNode(dataToInsert);
			return root;
		}

		if(dataToInsert <= root.data){
			root.left = insertInBST(root.left, dataToInsert);
		}
		else{
			// dataToInsert > root.data
			root.right = insertInBST(root.right, dataToInsert);
		}

		return root;
	}

	public static TreeNode buildBinarySearchTree(){
		Scanner scanner = new Scanner(System.in);
		int data = scanner.nextInt();
		TreeNode root = null;

		while(data != -1){
			root = insertInBST(root, data);
			data = scanner.nextInt();
		}

		return root;
	}

	public static void prettyLevelOrderTraversal(TreeNode root){
		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root);		// offer -> add last
		q.offer(null);		// Level 0 completed -> identifier = null

		while(!q.isEmpty()){
			TreeNode fNode = q.poll();		// poll -> pop front

			if(fNode == null){
				System.out.println();
				q.offer(null);
				if(q.peek() == null){
					return;
				}
			}
			else{
				System.out.print(fNode.data + " ");

				if(fNode.left != null){
					q.offer(fNode.left);
				}

				if(fNode.right != null){
					q.offer(fNode.right);
				}
			}
		}
		return;
	}

	static int counter;
	public static boolean searchInBST(TreeNode root, int key){
		if(root == null){
			return false;
		}

		System.out.println(counter + " -> searchInBST(" + root.data + ", " + key + ")");
		counter++;

		if(key == root.data){
			return true;
		}
		else if(key < root.data){
			return searchInBST(root.left, key);
		}
		else{
			// root.data < key
			return searchInBST(root.right, key);
		}
	}

	public static TreeNode deleteInBST(TreeNode root, int keyToDelete){
		if(root == null){
            return null;
        }

        if(root.data < key){
            root.right = deleteInBST(root.right, key);
        }
        else if(root.data > key){
            root.left = deleteInBST(root.left, key);
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
                root.data = temp.data;
                root.left = deleteInBST(root.left, temp.val);
            }
        }

        return root;
	}

	public static void main(String[] args){
		TreeNode root = buildBinarySearchTree();
		prettyLevelOrderTraversal(root);

		System.out.println("Enter key to search: ");
		Scanner scanner = new Scanner(System.in);
		int key = scanner.nextInt();

		counter = 1;
		boolean found = searchInBST(root, key);
		System.out.println(key + (found ? " found in BST" : " not found in BST"));

		// System.out.println("Enter key to search: ");
		// key = scanner.nextInt();

		// found = searchInBST(root, key);
		// System.out.println(key + (found ? " found in BST" : " not found in BST"));
	}
}













