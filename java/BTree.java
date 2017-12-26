import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Iterator;
import java.util.HashMap;
import java.util.Set;
import java.util.Map.Entry;
import java.util.Map;
//import java.util.*;


class IQ
{
	Node node;
	int hd;

	public IQ(Node node, int h)
	{
		this.node = node;
		this.hd = h;
	}
}

class Node
{
	int key;
	Node left, right;
	public Node(int key)
	{
		this.key = key;
		left = null;
		right = null;
	}
}

public class BTree
{
	Node root;
	static int maxLevel=0;
	public static void main(String[] args)
	{
		/*BTree l = new BTree();
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
		System.out.println();*/

		BTree t = new BTree();
		t.root = new Node(1);
		t.root.left = new Node(2);
		t.root.right = new Node(3);
		t.root.left.left = new Node(4);
		t.root.left.right = new Node(5);
		System.out.println("Depth::	" + t.maxDepth(t.root));

		System.out.println("HasPathSum::	" + t.hasPathSum(t.root, 4));
		System.out.println("HasPathSum::	" + t.hasPathSum(t.root, 10));

		BTree t2 = new BTree();
		t2.root = new Node(30);
		t2.root.left = new Node(15);
		t2.root.right = new Node(50);
		t2.root.left.left = new Node(7);
		t2.root.left.right = new Node(24);
		t2.root.left.left.right = new Node(10);
		t2.root.left.right.left = new Node(18);
		t2.root.left.right.left.left = new Node(16);
		t2.root.right.left = new Node(40);
		t2.root.right.right = new Node(80);

		System.out.println("LCA::	" + t2.getLCA(t2.root, 10, 30));

		BTree t3 = new BTree();
		t3.root = new Node(10);
		t3.root.left = new Node(-2);
		t3.root.right = new Node(6);
		t3.root.left.left = new Node(8);
		t3.root.left.right = new Node(-4);
		t3.root.right.left = new Node(7);
		t3.root.right.right = new Node(5);
		System.out.println("Before Inroder traversal::	");
		t3.printInroder(t3.root);
		t3.sumTree(t3.root);
		System.out.println("After Inroder traversal::	");
		t3.printInroder(t3.root);

		BTree t4 = new BTree();
		t4.root = new Node(1);
		t4.root.left = new Node(2);
		t4.root.right = new Node(3);
		t4.root.left.right = new Node(4);
		t4.root.left.right.right = new Node(5);
		t4.root.left.right.right.right = new Node(6);
		System.out.println("Printing LeftView::	");
		t4.leftView(t4.root, 1);
		System.out.println();

		System.out.println("InOrder using iteration:: " );
		t4.inOrderIteration(t4.root);
		System.out.println();
		
		System.out.println("PreOrder using iteration:: " );
		t4.preOrderIteration(t4.root);
		System.out.println();

		BTree t5 = new BTree();
		t5.root = new Node(1);
		t5.root.left = new Node(2);
		t5.root.right = new Node(3);
		t5.root.left.left = new Node(4);
		t5.root.left.right = new Node(5);
		t5.root.right.left = new Node(6);
		t5.root.right.right = new Node(7);

		System.out.println("TopView::	");
		t5.printTopView(t5.root);
		System.out.println();

		t5.root = new Node(20);
		t5.root.left = new Node(8);
		t5.root.right = new Node(22);
		t5.root.left.left = new Node(5);
		t5.root.left.right = new Node(3);
		t5.root.right.right = new Node(25);		
		t5.root.left.right.left = new Node(10);
		t5.root.left.right.right = new Node(14);
		System.out.println("BottomView::	");
		t5.printBottomView(t5.root);
		System.out.println();

	}

	/*void connectLeafNodes(Node node)
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
*/
	int maxDepth(Node node)
	{
		if(node == null)
			return 0;

		if(node.left == null && node.right == null)
			return 1;

		int lh = maxDepth(node.left);
		int rh = maxDepth(node.right);

		return lh > rh ? lh+1 : rh+1;
	}

	boolean hasPathSum(Node node, int sum)
	{
		if(node == null)
			return (sum==0);

		boolean lt = false,
				rt = false;

		sum = sum - node.key;
		if(node.left == null && node.right == null && sum== 0)
			return true;
		else if(sum > 0)
		{
			lt = hasPathSum(node.left, sum);
			rt = hasPathSum(node.right, sum);
		}
		else
			return false;

		return lt||rt;
	}

	boolean getDFS(Node node, List<Integer> arr, int x)
	{
		if(node == null)
			return false;

		boolean lt=false, rt=false;

		arr.add(node.key);

		if(node.key == x)
			return true;

		if(node.key < x)
			rt = getDFS(node.right, arr, x);

		if(node.key > x)
			lt = getDFS(node.left, arr, x);

		return false;
	}

	Integer getLCA(Node node, int v1, int v2)
	{
		ArrayList<Integer> l1 = new ArrayList<Integer>();
		ArrayList<Integer> l2 = new ArrayList<Integer>();

		boolean p1 = getDFS(node, l1, v1),
				p2 = getDFS(node, l2, v2);

		if(node == null && p1 && p2)
			return null;

		int s1 = l1.size(),
			s2 = l2.size();

		for(int i=(s1-2); i>=0; i--)
		{
			for(int j=(s2-2); j>=0; j--)
			{
				if(l1.get(i) == l2.get(j))
				{
					return l1.get(i);
				}
			}
		}
		return null;
	}

	int sumTree(Node node)
	{
		if(node == null)
			return 0;

		int lkey = 0,
			rkey = 0;

		if(node.left != null)
			lkey = node.left.key;
		if(node.right != null)
			rkey = node.right.key;

		if(node.left == null && node.right == null)
			node.key = 0;
		else
		{
			int nlkey = 0,
				nrkey = 0;

			nlkey = sumTree(node.left);
			nrkey = sumTree(node.right);

			node.key = lkey + rkey + nlkey + nrkey;
		}

		return node.key;
	}

	void printInroder(Node node)
	{
		if(node == null)
			return;
		else
		{
			printInroder(node.left);
			System.out.print(node.key + "	");
			printInroder(node.right);
		}
	}

	void leftView(Node node, int level)
	{
		if(node == null)
			return;

		if(maxLevel < level)
		{
			System.out.print(node.key + " ");
			maxLevel = level;
		}

		leftView(node.left, level+1);
		leftView(node.right, level+1);
	}

	void inOrderIteration(Node node)
	{
		if(node == null)
			return;

		Stack<Node> stack = new Stack<Node>();

		while(node != null)
		{
			stack.push(node);
			node = node.left;
		}

		while(!stack.empty())
		{
			node = stack.pop();
			System.out.print(node.key + "  ");

			if(node.right != null)
			{
				node = node.right;
				while(node != null)
				{
					stack.push(node);
					node = node.left;
				}
			}
		}
	}

	void preOrderIteration(Node node)
	{
		if(node == null)
			return;

		Stack<Node> stack = new Stack<Node>();
		stack.push(node);

		while(!stack.empty())
		{
			node = stack.pop();
			System.out.print(node.key + "  ");

			if(node.right != null)
				stack.push(node.right);

			if(node.left != null)
				stack.push(node.left);
		}
	}


	void printTopView(Node node)
	{
		if(node == null)
			return;

		HashSet<Integer> set = new HashSet<Integer>();
		Queue<IQ> list = new LinkedList<IQ>();
		int hd=0;

		list.add(new IQ(node, hd));

		while(!list.isEmpty())
		{
			IQ i = list.remove();
			hd = i.hd;
			if(!set.contains(hd))
			{
				set.add(Integer.valueOf(hd));
				System.out.print(i.node.key + "  ");
			}

			if(i.node.left != null)
				list.add( new IQ(i.node.left, i.hd-1) );

			if(i.node.right != null)
				list.add( new IQ(i.node.right, i.hd+1) );
		}

	}

	void printBottomView(Node node)
	{
		if(node == null)
			return;

		HashMap<Integer, Node> map = new HashMap<Integer, Node>();
		Queue<IQ> list = new LinkedList<IQ>();
		int hd = 0;
		IQ i = new IQ(node, hd);

		list.add(i);
		while(!list.isEmpty())
		{
			i = list.remove();
			map.put(Integer.valueOf(i.hd), i.node);

			if(i.node.left != null)
				list.add( new IQ(i.node.left, i.hd-1));

			if(i.node.right != null)
				list.add(new IQ(i.node.right, i.hd+1));
		}

		Set<Entry<Integer, Node>> set = map.entrySet();
		Iterator<Entry<Integer, Node>> itr = set.iterator();
		while(itr.hasNext())
		{
			Entry<Integer, Node> m = itr.next();
			System.out.print( ((Node)m.getValue()).key + " ");
		}
	}
}

