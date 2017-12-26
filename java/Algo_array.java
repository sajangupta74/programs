import java.util.Stack;

public class Algo_array
{
	Integer[] arr;

	public static void main(String[] args)
	{
		Algo_array s1 = new Algo_array();
		Algo_array s2 = new Algo_array();
		Algo_array s3 = new Algo_array();
		s1.arr = new Integer[]{1,12,15,26,38};
		s2.arr = new Integer[]{2,13,17,30,45};
		s3.arr = new Integer[]{2,13,17,30,45,50,55,60,68};
		System.out.println("Median::	" + s1.medianSortedArraySameSize(s1.arr, s2.arr));
		System.out.println("Median::	" + s1.medianSortedArray(s1.arr, s3.arr));
	}

	Integer getMedian(Integer a, Integer b)
	{
		return (a+b)/2;
	}

	public Integer medianSortedArray(Integer[] arr1, Integer[] arr2)
	{
		Integer s1 = arr1.length,
				s2 = arr2.length,
				s3 = s1+s2;
		boolean odd;
		int k=0,
			j=0;
		Stack<Integer> stack = new Stack<Integer>();

		if(s1 == 0 && s2 == 0)
		{
			return null;
		}
		if(s1 == 0 && s2 != 1)
			return arr2[0];
		if(s2 ==0 && s1 != 0)
			return arr1[0];

		if(s3%2 == 0)
			odd = false;
		else
			odd = true;

		for(int i=0;i<(s3/2)+1;i++)
		{
			if(arr1[k] < arr2[j])
			{
				stack.push(arr1[k]);
				k++;
			}
			else
			{
				stack.push(arr2[j]);
				j++;	
			}
		}

		if(odd)
		{
			stack.pop();
			return stack.pop();
		}
		else
		{
			return getMedian(stack.pop(), stack.pop());
		}
	}

	public Integer medianSortedArraySameSize(Integer[] arr1, Integer[] arr2)
	{
		Integer size1 = arr1.length,
				size2 = arr2.length;
		Stack<Integer> stack = new Stack<Integer>();
		int k=0, j=0;
		if(size1 == 0)
			return null;

		if(size1 == 1)
			return getMedian(arr1[0], arr2[0]);

		for(int i=0; i<=size1; i++)
		{
			if(arr1[k] < arr2[j])
			{
				stack.push(arr1[k]);
				k++;
			}	
			else
			{
				stack.push(arr2[j]);
				j++;
			}
		}
		
		Integer a = (Integer)stack.pop();
		Integer b = (Integer)stack.pop();
		return getMedian(a, b);
	}


	Integer getPivot()
	{
		
	}

	void quickSort(Integer arr, Integer l, Integer r)
	{
		if(l<r)
		{
			Integer pivot = getPivot(arr, l, r);
			quickSort(arr, l, pivot);
			quickSort(arr, pivot, r);
		}
	}
}