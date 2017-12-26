class Node
{
	int key, height;
	Node left, right;

	public Node(int key)
	{
		this.key = key;
		this.height = 1;
	}
}

public class AVLTree
{
	Node root;

	int height(Node node)
	{
		if(node == null)
			return 0;

		return node.height;
	}

	Node rightRotate(Node node)
	{
		Node y = node;
		Node x = y.left;
		Node t2 = x.right;

		x.right = y;
		y.left = t2;

		y.height = Integer.max(height(y.left), height(y.right))+1;
		x.height = Integer.max(height(x.left), height(x.right))+1;

		return x;
	}

	Node leftRotate(Node node)
	{
		Node y = node;
		Node x = y.right;
		Node t2 = x.left;

		x.left = y;
		y.right = t2;

		y.height = Integer.max(height(y.left), height(y.right))+1;
		x.height = Integer.max(height(x.left), height(x.right))+1;

		return x;
	}

	int getBalance(Node node)
	{
		if(node == null)
			return 0;
		return (height(node.left) - height(node.right));
	}

	Node insert(Node node, int key)
	{
		if(node == null)
			return new Node(key);

		if(node.key > key)
			node.left = insert(node.left, key);
		else if(node.key < key)
			node.right = insert(node.right, key);
		else
			return node;

		node.height = 1 + Integer.max(height(node.left), height(node.right));

		int balance = getBalance(node);

		if(balance > 1 && node.left.key > key)
			return rightRotate(node);

		if(balance < -1 && node.right.key < key)
			return leftRotate(node);

		if(balance > 1 && node.left.key < key)
		{
			node.left = leftRotate(node.left);
			return rightRotate(node);
		}

		if(balance < -1 && node.right.key > key)
		{
			node.right = rightRotate(node.right);
			return leftRotate(node);
		}

		return node;
	}

	void preOrder(Node node) {
        if (node != null) {
            System.out.print(node.key + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    int minValue(Node node)
    {
    	int value = Integer.MAX_VALUE;
    	if(node == null)
    		return -1;
    	else
    	{
    		if(node.left != null)
    			value = minValue(node.left);
    		return Integer.min(node.key, value);
    	}
    }

    Node deleteNode(Node node, int key)
    {
    	if(node == null)
    		return node;

    	if(key < node.key)
    		node.left = deleteNode(node.left, key);
    	else if(key > node.key)
    		node.right = deleteNode(node.right, key);
    	else
    	{
    		if(node.left == null || node.right == null)
    		{
    			if(node.left == null && node.right == null)
    			{
    				node = null;
    				return node;
    			}
    			else
    			{
    				if(node.left == null)
    					node = node.right;
    				else
    					node = node.left;
    			}    			
    		}
    		else
    		{
    			int leftMinValue = minValue(node.right);
    			node.key = leftMinValue;

    			root.right = deleteNode(node.right, node.key);
    		}

    		node.height = Integer.max(height(node.left), height(node.right))+1;
    		int balance = getBalance(node);

    		if(balance > 1 && getBalance(node.left) >= 0)
    			return rightRotate(node);
    		if(balance >1 && getBalance(node.left) < 0)
    		{
    			node.left = leftRotate(node);
    			return rightRotate(node);
    		}

    		if(balance < -1 && getBalance(node.right) <= 0)
    			return leftRotate(node);

    		if(balance < -1 && getBalance(node.right) > 0)
    		{
    			node.right = rightRotate(node);
    			return leftRotate(node);
    		}		
    	}

    	return node;
    }

	public static void main(String[] args)
	{
		 AVLTree tree = new AVLTree();
 
        /* Constructing tree given in the above figure */
        tree.root = tree.insert(tree.root, 10);
        tree.root = tree.insert(tree.root, 20);
        tree.root = tree.insert(tree.root, 30);
        tree.root = tree.insert(tree.root, 40);
        tree.root = tree.insert(tree.root, 50);
        tree.root = tree.insert(tree.root, 25);
 
        /* The constructed AVL Tree would be
             30
            /  \
          20   40
         /  \     \
        10  25    50
        */
        System.out.println("Preorder traversal" +
                        " of constructed tree is : ");
        tree.preOrder(tree.root);
        System.out.println();

        tree.deleteNode(tree.root, 20);
		
		System.out.println("Preorder traversal" +
                        " of constructed tree is : ");
        tree.preOrder(tree.root);
        System.out.println();        
	}
}