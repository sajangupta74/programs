import java.util.Stack;

public class SpecialStack extends Stack<Integer>
{
	Stack<Integer> auxStack = new Stack<Integer>();

	void push(int x)
	{
		if(isEmpty())
		{
			super.push(x);
			auxStack.push(x);
		}
		else
		{
			int y = auxStack.pop();
			auxStack.push(y);
			if(x < y)
			{
				auxStack.push(x);
				super.push(x);
			}
			else
			{
				auxStack.push(y);
				super.push(x);
			}
		}
	}

	public Integer pop()
	{
		int x = Integer.MIN_VALUE;

		if(isEmpty())
		{
			System.out.println("Stack is overflow");
		}
		else
		{
			x = super.pop();
			int y = auxStack.pop();
		}

		return x;
	}

	int getMin()
	{
		int x = auxStack.pop();
		auxStack.push(x);

		return x;
	}

	public static void main(String[] args)
	{
		SpecialStack stack = new SpecialStack();
		for(int i=5; i<10; i++)
		{
			stack.push(i);
		}
		System.out.println("Minimum Element is::	" + stack.getMin());
	}
}