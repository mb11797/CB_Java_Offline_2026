import java.util.Queue;
import java.util.LinkedList;

public class PrettyLevelOrderTraversal{

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

	public static void preOrderTraversal(TreeNode root){
		if(root == null){
			return;
		}

		System.out.print(root.data + " ");
		preOrderTraversal(root.left);
		preOrderTraversal(root.right);
	}

	public static void postOrderTraversal(TreeNode root){
		if(root == null){
			return;
		}

		postOrderTraversal(root.left);
		postOrderTraversal(root.right);
		System.out.print(root.data + " ");
	}

	public static void inOrderTraversal(TreeNode root){
		if(root == null){
			return;
		}

		inOrderTraversal(root.left);
		System.out.print(root.data + " ");
		inOrderTraversal(root.right);
	}

	public static void levelOrderTraversal(TreeNode root){
		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root);		// add last

		while(!q.isEmpty()){
			TreeNode frontNode = q.poll();		// pop front
			System.out.print(frontNode.data + " ");

			if(frontNode.left != null){
				q.offer(frontNode.left);
			}

			if(frontNode.right != null){
				q.offer(frontNode.right);
			}
		}
		System.out.println();

		return;
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

	public static void prettyLevelOrderTraversalUsingMultiSourceBFS(TreeNode root){
		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root);		// offer -> add last -> level 0

		while(!q.isEmpty()){
			int len = q.size();			// len of current state of queue = len of nodes in current level
			for(int i=0; i<len; i++){
				TreeNode fNode = q.poll();
				System.out.print(fNode.data + " ");

				if(fNode.left != null)
					q.offer(fNode.left);

				if(fNode.right != null)
					q.offer(fNode.right);
			}
			System.out.println();
		}
		return;
	}

	public static void breadthFirstSearchTraversal(TreeNode root){
		levelOrderTraversal(root);
	}

	public static void main(String[] args){
		TreeNode root = new TreeNode(5);
		TreeNode leftNode = new TreeNode(3);
		TreeNode rightNode = new TreeNode(1);
		root.left = leftNode;
		root.right = rightNode;

		leftNode.left = new TreeNode(7);
		rightNode.left = new TreeNode(2);
		rightNode.right = new TreeNode(6);

		rightNode.right.left = new TreeNode(8);

		System.out.println("Preorder Traversal: ");
		preOrderTraversal(root);
		System.out.println();

		System.out.println("Postorder Traversal: ");
		postOrderTraversal(root);
		System.out.println();

		System.out.println("Inorder Traversal: ");
		inOrderTraversal(root);
		System.out.println();

		System.out.println("Level Order Traversal: ");
		levelOrderTraversal(root);
		System.out.println();

		System.out.println("Pretty Level Order Traversal: ");
		prettyLevelOrderTraversal(root);
		System.out.println();

		System.out.println("Pretty Level Order Traversal using Multi-Source BFS: ");
		prettyLevelOrderTraversalUsingMultiSourceBFS(root);
		System.out.println();
	}
}