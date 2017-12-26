class Node
{
	int key;
	Node left, right, leafConnection;

	public Node(int key)
	{
		this.key=key;
		left = null;
		right = null;
		leafConnection=null;
	}

	public Node()
	{
		left = null;
	}
}

public class BinaryTree
{
	public Node root;
	public int max=0;
	public Node prev=null;
	public Node firstLeafNode=null;

	public BinaryTree(Node node)
	{
		root = node;
	}

	public BinaryTree()
	{
		root = null;
	}

	public static void main(String[] args)
	{
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);

		System.out.println("Printing tree in Pre-Order::	");
		tree.preOrder(tree.root);
		System.out.println("");

		System.out.println("Printing tree in In-Order::	");
		tree.inOrder(tree.root);
		System.out.println("");

		System.out.println("Printing tree in Post-Order::	");
		tree.postOrder(tree.root);
		System.out.println("");

		System.out.println("Height of the tree is:: " + tree.height(tree.root));

		System.out.println("Level Traversal of tree is:: ");		
		tree.completeLevelTraversal(tree.root);
		System.out.println("");

		System.out.println("Size of the tree is::	" + tree.size(tree.root));

		System.out.println("Leaf Count is::	" + tree.leafCount(tree.root));

		BinaryTree tree2 = new BinaryTree();
		tree2.root = new Node(1);
		tree2.root.left = new Node(2);
		tree2.root.right = new Node(3);
		tree2.root.left.left = new Node(4);
		tree2.root.left.right = new Node(5);

		System.out.println("Identical tree!	" + tree.sameTree(tree.root, tree2.root));

		System.out.println("MaxDepth of tree is::	" + tree.maxDepth(tree.root));
		System.out.println("MinDepth of tree is::	" + tree.minDepth(tree.root));

		System.out.print("SpiralLevelTraversal in ltr::	");
		tree.spiralLevelTraversal(tree.root,2,false);
		System.out.println("");

		BinaryTree tree3 = new BinaryTree();
		tree3.root = new Node(10);
		tree3.root.left = new Node(8);
		tree3.root.right = new Node(2);
		tree3.root.left.left = new Node(3);
		tree3.root.left.right = new Node(5);
		tree3.root.right.left = new Node(3);

		System.out.print("ChildrenSumProperty of tree is::	" + tree3.childrenSumProperty(tree3.root));
		System.out.println("");

		System.out.print("ChildrenSumProperty of tree is::	" + tree3.c2(tree3.root));
		System.out.println("");

		BinaryTree tree4 = new BinaryTree();
		tree4.root = new Node(1);
		tree4.root.left = new Node(2);
		tree4.root.right = new Node(3);
		tree4.root.left.left = new Node(4);
		tree4.root.left.right = new Node(5);
		System.out.println("tree::	");
		tree4.inOrder(tree4.root);
		System.out.println("mirror tree::	");
		tree4.inOrder(tree4.mirror(tree4.root));
		System.out.println("");

		tree4.root = new Node(4);
		tree4.root.left = new Node(2);
		tree4.root.right = new Node(5);
		tree4.root.left.left = new Node(1);
		tree4.root.left.right = new Node(6);
		//System.out.print("isBST::	" + tree4.isBST(tree4.root));
		System.out.println("");

		BinaryTree t = new BinaryTree();
		t.root = new Node(1);
		t.root.left = new Node(2);
		t.root.right = new Node(3);
		t.root.left.left = new Node(4);
		t.root.left.right = new Node(5);
		t.root.left.right.left = new Node(6);
		t.root.left.right.left.left = new Node(8);
		t.root.left.right.right = new Node(7);
		t.root.left.right.right.right = new Node(9);
		t.root.left.right.right.right.right = new Node(10);
		t.root.right.left = new Node(12);
		t.root.right.right = new Node(11);
		t.root.right.right.right = new Node(13);
		t.root.right.right.right.right = new Node(15);
		t.root.right.right.right.left = new Node(14);
		t.root.right.right.right.left.left = new Node(16);
		t.root.right.right.right.left.left.left = new Node(17);
		t.root.right.right.right.left.left.left.left = new Node(18);

		//System.out.print("Diameter of tree is::	" + t.diameter(t.root));


		BinaryTree t2 = new BinaryTree();
		t2.root = new Node(10);
		t2.root.left = new Node(2);
		t2.root.left.left = new Node(20);
		t2.root.left.right = new Node(1);
		//t2.root.left.right.left = new Node(5);
		t2.root.right = new Node(10);
		t2.root.right.right = new Node(-25);
		t2.root.right.right.left = new Node(3);
		t2.root.right.right.right = new Node(4);
		System.out.println("Max path Sum of tree is::	" + t2.maxSum(t2.root));
		System.out.println("Max path Sum2 of tree is::	" + t2.max);

		BinaryTree d = new BinaryTree();
		d.root = new Node(1);
		d.root.left = new Node(2);
		d.root.right = new Node(3);
		d.root.left.left = new Node(4);
		d.root.left.right = new Node(5);
		System.out.println("Diameter of tree is::	" + d.diameter(d.root));

		BinaryTree l = new BinaryTree();
		l.root = new Node(20);
		l.root.left = new Node(10);
		l.root.left.left = new Node(5);
		l.root.left.right = new Node(15);
		l.root.left.right.left = new Node(12);
		l.root.left.right.right = new Node(17);
		l.root.right = new Node(30);
		l.root.right.right = new Node(40);
		l.root.right.right.left = new Node(35);
		l.root.right.right.right = new Node(50);
		l.root.right.right.right.right = new Node(60);

		l.connectLeafNodes(l.root);
		l.travreseLeafNodes(l.firstLeafNode);
		System.out.println();

	}

	void preOrder(Node node)
	{
		if(node == null)
			return;

		System.out.print(node.key + "	");
		preOrder(node.left);
		preOrder(node.right);
	}

	void inOrder(Node node)
	{
		if(node == null)
			return;

		inOrder(node.left);

		System.out.print(node.key + "	");

		inOrder(node.right);
	}

	void postOrder(Node node)
	{
		if(node == null)
			return;

		postOrder(node.left);
		postOrder(node.right);

		System.out.print(node.key + "	");
	}

	int height(Node node)
	{
		int	lheight=0,
			rheight=0;

		if(node == null)
			return 0;
		else
		{
			lheight = height(node.left);
			rheight = height(node.right);

			if(lheight > rheight)
				return lheight+1;
			else
				return rheight+1;
		}
	}

	void levelTraversal(Node node, int level)
	{
		if(node == null)
			return;
		
		if(level == 1) {
			System.out.print(node.key + "	");
		}
		else if(level > 1)
		{
			levelTraversal(node.left, level - 1);
			levelTraversal(node.right, level - 1);

		}
	}

	void spiralLevelTraversal(Node node, int level, boolean ltr)
	{
		if(node == null)
			return;
		else if(level == 1)
			System.out.print(node.key + "	");
		else
		{
			if(ltr)
			{
				spiralLevelTraversal(node.left, level-1, ltr);
				spiralLevelTraversal(node.right, level-1, ltr);
			}
			else
			{
				spiralLevelTraversal(node.right, level-1, ltr);
				spiralLevelTraversal(node.left, level-1, ltr);
			}
		}
	}

	void completeLevelTraversal(Node node)
	{
		int height = height(node);

		for(int i=1; i<=height; i++)
		{
			levelTraversal(node, i);
		}
	}

	int size(Node node)
	{
		if(node == null)
			return 0;
		else
		{
			return size(node.left) + 1 + size(node.right);
		}
	}

	int leafCount(Node node)
	{
		if(node == null)
			return 0;
		else if(node.left == null && node.right == null)
			return 1;
		else
			return leafCount(node.left) + leafCount(node.right);
	}

	boolean sameTree(Node node1, Node node2)
	{
		if( node1 == null && node2 == null)
			return true;
		else if(node1 != null && node2 != null)
		{
			return (node1.key == node2.key && sameTree(node1.left, node2.left) && sameTree(node1.right, node2.right));
		}
		else
			return false;
	}

	int minDepth(Node node)
	{
		if(node == null)
			return 0;

		if(node.left == null && node.right == null)
			return 1;

		return (minDepth(node.left)+1)>(minDepth(node.right)+1) ? (minDepth(node.right)+1) : (minDepth(node.left)+1);
	}

	int maxDepth(Node node)
	{
		if(node == null)
			return 0;
		else
			if(maxDepth(node.left) > maxDepth(node.right))
				return (maxDepth(node.left)+1);
			else
				return (maxDepth(node.right)+1);
	}

	boolean childrenSumProperty(Node node)
	{
		int lkey = 0,
			rkey = 0;

		if(node == null || (node.left == null && node.right == null))
			return true;
		else
		{
			if(node.left != null)
				lkey = node.left.key;

			if(node.right != null)
				rkey = node.right.key;
			
			if( childrenSumProperty(node.left) 
					&& childrenSumProperty(node.right)
					&& (lkey + rkey == node.key) )
				return true;
			else
				return false;	
		}
	}

	Node mirror(Node node)
	{
		if(node == null)
			return node;
		else
		{
			mirror(node.left);
			mirror(node.right);

			if(node.left == null  && node.right == null)
				return node;
			else
			{
				Node temp;
				temp = node.left;
				node.left = node.right;
				node.right = temp;
				return node;
			}
		}
	}

	boolean isBST(Node node, Node l, Node r)
	{
		if(node == null)
			return true;
		
		if(l != null && l.key > node.key)
			return false;

		if(r != null && r.key < node.key)
			return false;

		return (isBST(node.left, l, node) && isBST(node.right, node, r));
	}

	//childrenSumProperty just for testing
	public boolean c2(Node node) 
	{
		int l = 0,r = 0 ;
		if(node == null || (node.left == null && node.right == null))
			return true;

		if(node.left != null)
			l = node.left.key;

		if(node.right != null)
			r = node.right.key;

		return ( (l+r) == node.key  && c2(node.left) && c2(node.right));
		
	}

	public int maxSum(Node node)
	{
		int max1, max2;
		if(node == null)
			return 0;

		/*if(node.left == null && node.right == null)
			return node.key;*/

		int l = maxSum(node.left);
		int r = maxSum(node.right);

		max1 = Math.max(Math.max(l,r)+node.key, node.key);
		max2 = Math.max(max1, l+r+node.key);

		max = Math.max(max2, max);
		return max1;
	}

	int maximumOfThree(int key1, int key2, int key3)
	{
		int max;
		
		if(key1 >= key2)
			max = key1;
		else
			max = key2;

		if(max <= key3)
			max = key3;

		return max;
	}

	int diameter(Node node)
	{
		if(node == null)
			return 0;

		if(node.left == null && node.right == null)
			return 1;

		int ld = diameter(node.left);
		int rd = diameter(node.right);

		int l = height(node.left);
		int r = height(node.right);

		return maximumOfThree(l+r+1, ld, rd);
	}

	void connectLeafNodes(Node node)
	{
		if(node == null)
			return ;
		
		if(node.left == null && node.right == null)
		{
			if(prev == null)
			{
				prev = node;
				firstLeafNode = node;
			}
			else
			{
				prev.leafConnection = node;
				prev = node;
			}
		}

		connectLeafNodes(node.left);
		connectLeafNodes(node.right);
	}

	void travreseLeafNodes(Node node)
	{
		if(node == null)
			return;

		System.out.print(node.key + " 	");
		travreseLeafNodes(node.leafConnection);
	}

}