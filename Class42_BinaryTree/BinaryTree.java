public class BinaryTree{

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

		System.out.println(root.data);
		System.out.println(root.left.data);
		System.out.println(root.right.data);
		System.out.println(root.left.left.data);
		System.out.println(root.right.left.data);
		System.out.println(root.right.right.data);
		System.out.println(root.right.right.left.data);

		System.out.println("Preorder Traversal: ");
		preOrderTraversal(root);
		System.out.println();

		System.out.println("Postorder Traversal: ");
		postOrderTraversal(root);
		System.out.println();

		System.out.println("Inorder Traversal: ");
		inOrderTraversal(root);
		System.out.println();
	}
}