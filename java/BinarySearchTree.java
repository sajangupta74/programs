import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;


class Node
{
	int key;
	Node left=null, right=null;

	public Node(int value)
	{
		key = value;
	}
}

public class BinarySearchTree
{
	Node root=null;

	public Node insert(Node node, int key)
	{
		if(node == null)
			return node = new Node(key);

		if(node.key < key)
			root.right = insert(node.right, key);
		else if(node.key > key)
			root.left = insert(node.left, key);

		return root;
	}

	public void inorder(Node node)
	{
		if(node == null)
			return;
		inorder(node.left);
		System.out.print(node.key + "	");
		inorder(node.right);
	}

	public static void main(String[] args)	throws Exception
	{
		int choice;
		int key;

		BinarySearchTree bst = new BinarySearchTree();		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		//System.out.println("Enter choice, press e anytime to exit");
		
		/*do
		{			
			System.out.println("Enter key::	");
			key = Integer.parseInt(br.readLine());

			bst.root = bst.insert(bst.root, key);	
			
			System.out.println("Enter choice, press e anytime to exit");
			choice = Integer.parseInt(br.readLine());		
		}while(choice != 0);

		System.out.println("Inorder Traversal::	");
		bst.inorder(bst.root);*/

		int[] pre1 = new int[]{2,4,3};
        int n = pre1.length;
        if (bst.canRepresentBST(pre1, n) == true) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
        int[] pre2 = new int[]{2,4,1};
        int n1 = pre2.length;
        if (bst.canRepresentBST(pre2, n) == true) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
	}

	public boolean canRepresentBST(int pre[], int n) {
        // Create an empty stack
        Stack<Integer> s = new Stack<Integer>();
 
        // Initialize current root as minimum possible
        // value
        int root = Integer.MIN_VALUE;
 
        // Traverse given array
        for (int i = 0; i < n; i++) {
            // If we find a node who is on right side
            // and smaller than root, return false
            if (pre[i] < root) {
                return false;
            }
 
            // If pre[i] is in right subtree of stack top,
            // Keep removing items smaller than pre[i]
            // and make the last removed item as new
            // root.
            while (!s.empty() && s.peek() < pre[i]) {
                root = s.peek();
                s.pop();
            }
 
            // At this point either stack is empty or
            // pre[i] is smaller than root, push pre[i]
            s.push(pre[i]);
        }
        return true;
    }
}