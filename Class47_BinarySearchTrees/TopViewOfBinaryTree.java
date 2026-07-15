import java.util.*;


/*
Level Order Input:
15
3 1 2 6 8 5 9 13 -1 7 -1 -1 -1 11 -1
*/

public class TopViewOfBinaryTree{
	public static class TreeNode {
		int data;
		TreeNode left;
		TreeNode right;

		public TreeNode(int data){
			this.data = data;
			this.left = null;
			this.right = null;
		}
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

	private static void verticalOrderTraversalBinaryTreeUsingDFS(TreeNode root, int col, Map<Integer, List<Integer>> colVsNodeValuesListMap){
		if(root == null){
			return;
		}

		List<Integer> colNodeValuesList = colVsNodeValuesListMap.getOrDefault(col, new ArrayList<Integer>());
		colNodeValuesList.add(root.data);
		colVsNodeValuesListMap.put(col, colNodeValuesList);

		verticalOrderTraversalBinaryTreeUsingDFS(root.left, col-1, colVsNodeValuesListMap);
		verticalOrderTraversalBinaryTreeUsingDFS(root.right, col+1, colVsNodeValuesListMap);
	}

	public static Map<Integer, List<Integer>> verticalOrderTraversalBinaryTreeUsingDFS(TreeNode root){
		Map<Integer, List<Integer>> colVsNodeValuesListMap = new HashMap<>();
		verticalOrderTraversalBinaryTreeUsingDFS(root, 0, colVsNodeValuesListMap);
		return colVsNodeValuesListMap;
	}

	public static void topViewOfBinaryTreeUsingDFS(TreeNode root, int col, Map<Integer, Integer> colVsNodeValMap){
		if(root == null)
			return;

		if(!colVsNodeValMap.containsKey(col)){
			colVsNodeValMap.put(col, root.data);
		}

		topViewOfBinaryTreeUsingDFS(root.left, col-1, colVsNodeValMap);
		topViewOfBinaryTreeUsingDFS(root.right, col+1, colVsNodeValMap);
	}

	public static Map<Integer, Integer> topViewOfBinaryTreeUsingDFS(TreeNode root){
		Map<Integer, Integer> colVsNodeValMap = new HashMap<>();
		topViewOfBinaryTreeUsingDFS(root, 0, colVsNodeValMap);
		return colVsNodeValMap;
	}

	public static class ColumnBasedSortingComparator implements Comparator<Map.Entry<Integer, Integer>>{
		@Override
		public int compare(Map.Entry<Integer, Integer> entryA, Map.Entry<Integer, Integer> entryB){
			return Integer.compare(entryA.getKey(), entryB.getKey());
		}
	}

	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] levelOrderInput = new int[n];

		for(int i=0; i<n; i++){
			levelOrderInput[i] = scanner.nextInt();
		}

		TreeNode root = buildBinaryTreeFromLevelOrderInput(levelOrderInput);

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

		System.out.println("Vertical Order Traversal using DFS: ");
		Map<Integer, List<Integer>> verticalOrderTraversal = verticalOrderTraversalBinaryTreeUsingDFS(root);
		for(Map.Entry<Integer, List<Integer>> entry: verticalOrderTraversal.entrySet()){
			int col = entry.getKey();
			System.out.print(col + " -> ");
			List<Integer> nodesList = entry.getValue();
			for(int nodeVal: nodesList){
				System.out.print(nodeVal + ", ");
			}
			System.out.println();
		}
		System.out.println();

		System.out.println("Top View of Binary Tree using DFS: ");
		Map<Integer, Integer> topViewOfBT = topViewOfBinaryTreeUsingDFS(root);
		for(Map.Entry<Integer, Integer> entry: topViewOfBT.entrySet()){
			int col = entry.getKey();
			int nodeVal = entry.getValue();
			System.out.println(col + " -> " + nodeVal);
		}
		System.out.println();

		System.out.println("Top View of Binary Tree with Correct Ordering using DFS: ");
		List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(topViewOfBT.entrySet());
		Collections.sort(entryList, new ColumnBasedSortingComparator());
		for(Map.Entry<Integer, Integer> entry: entryList){
			int col = entry.getKey();
			int nodeVal = entry.getValue();
			System.out.println(col + " -> " + nodeVal);
		}
		System.out.println();
	}
}