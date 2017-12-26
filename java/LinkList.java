import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class LinkList
{
	static class Node
	{
		int key;
		Node next;

		public Node(int key)
		{
			this.key = key;
			this.next = null;
		}
	}
	
	Node head;

	public static void main(String[] args)	throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int choice;

		LinkList list = new LinkList();
		list.head = new Node(10);
		LinkList.Node traversal = list.head;

		do
		{
			LinkList.Node temp = new Node(0);
			System.out.print("Enter element:: ");
			temp.key = Integer.parseInt(br.readLine());
			traversal.next = temp;
			traversal = traversal.next;
			
			System.out.print("Continue?(y/n):: ");
			choice = Integer.parseInt(br.readLine());

		}while(choice != 0);

		list.print();
		list.printMiddle();

	}

	public void print()
	{	
		Node node = head;
		while(node != null)
		{
			System.out.print(node.key  +  "  ");
			node = node.next;
		}
		System.out.println();
	}

	public void printMiddle()
	{
		Node slow = head;
		Node fast = head;
		Node mid = slow;

		while(fast.next != null)
		{
			if(fast.next.next == null)
				break;
			slow = slow.next;
			fast = fast.next.next;
			mid = slow;
		}
		System.out.print(mid.key  +  "  ");
		System.out.println();
	}
}