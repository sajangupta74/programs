import java.util.*;

public class ArrayProblem
{
	int[] array;

	public static void main(String[] args)
	{
		ArrayProblem t3 = new ArrayProblem();
		t3.array = new int[]{67,1,245,563,9,90,123};
		t3.array = t3.sortMukand(t3.array);
		System.out.println(Arrays.toString(t3.array));
	}

	int[] sortMukand(int[] arr)
	{
		boolean comp;
		for(int i=0; i<arr.length-1; i++)
		{
			for(int j=i+1; j<arr.length; j++)
			{
				comp = bigElement(arr, i, j);
				if(comp == false)
				{
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}

		return arr;
	}

	boolean bigElement(int[] arr, int i, int j)
	{
		String a = String.valueOf(arr[i]),
				b = String.valueOf(arr[j]);

		int size = getMin(a.length(), b.length());

		for(int k=0; k<size; k++)
		{
			if( Integer.valueOf(a.charAt(k)) > Integer.valueOf(b.charAt(k)) )
				return true;
			else if( Integer.valueOf(a.charAt(k)) < Integer.valueOf(b.charAt(k)) )
				return false;
		}

		return false;
	}

	int getMin(int a, int b)
	{
		return a>b ? b : a;
	}
}