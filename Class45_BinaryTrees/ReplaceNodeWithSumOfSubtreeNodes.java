public class ReplaceNodeWithSumOfSubtreeNodes{
		public static Scanner scanner = new Scanner(System.in);

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

	public static TreeNode buildBinaryTreeFromPreOrderInput(){
		int val = scanner.nextInt();
		if(val == -1){
			return null;
		}

		TreeNode root = new TreeNode(val);
		root.left = buildBinaryTreeFromPreOrderInput();
		root.right = buildBinaryTreeFromPreOrderInput();
		return root;
	}

	public static TreeNode buildBinaryTreeFromLevelOrderInput(int[] input){
		int n = input.length;
		if(n == 0 || input[0] == -1){
			return null;
		}

		Queue<TreeNode> q = new LinkedList();
		TreeNode root = new TreeNode(input[0]);
		q.offer(root);

		int i=1;
		while(i < n){
			TreeNode frontNode = q.poll();

			if(i<n && input[i] != -1){
				frontNode.left = new TreeNode(input[i]);
				q.offer(frontNode.left);
			}
			i++;

			if(i<n && input[i] != -1){
				frontNode.right = new TreeNode(input[i]);
				q.offer(frontNode.right);
			}
			i++;
		}

		return root;
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

	public static void replaceNodeWithSumOfSubtreeNodes(TreeNode root){
		
	}

	public static void main(String[] args){
		
		TreeNode root = buildBinaryTreeFromPreOrderInput();

		replaceNodeWithSumOfSubtreeNodes(root);

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