import java.util.Stack;
import java.util.*;
import java.util.*;

class ArrayAlgos
{
	public int array[];

	public static void main(String[] args)
	{
		ArrayAlgos arr = new ArrayAlgos();

		arr.array = new int[] {0,1,2,3,4,5,6,7,8};

		arr.array = arr.reverseArray(arr.array);
		for(int i=0; i<arr.array.length; i++)
			System.out.print(arr.array[i] + "	");
		System.out.println();

		//arr.subarrays(arr.array);

		ArrayAlgos sortRotated = new ArrayAlgos();
		sortRotated.array = new int[]{5,6,7,8,9};
		System.out.println("Pivot Element is::	" + sortRotated.array[sortRotated.getPivotElement(sortRotated.array,0,sortRotated.array.length-1)]);
		System.out.println("Element you search is:: " + sortRotated.array[sortRotated.binarySearch(sortRotated.array, 0, sortRotated.array.length-1, 5)]);
		System.out.println("HasTwoCandidate::  " + sortRotated.hasTwoCandidate(sortRotated.array, 200));

		ArrayAlgos sorted = new ArrayAlgos();
		sorted.array = new int[]{0,1,2,3,4,5,6,7,8,9};
		sorted.triplets(sorted.array, 7);

		System.out.println("Integer.Max_value::	" + Integer.MAX_VALUE + "	" + Integer.MIN_VALUE);

		ArrayAlgos reachability = new ArrayAlgos();
		reachability.array = new int[]{0,2,2,1,1,1,2,3};
		System.out.println(reachability.reachable(reachability.array, 0));

		ArrayAlgos arr1, arr2;
		arr1 = new ArrayAlgos();
		arr2 = new ArrayAlgos();
		arr1.array = new int[]{1,12,15,26,38};
		arr2.array = new int[]{2,13,17,30,45};
		System.out.println("Median::  " + arr1.medianSortedArraySameSize(arr1.array, arr2.array));

		ArrayAlgos t2 = new ArrayAlgos();
		t2.array = new int[]{8,3,5,1,4,10,17,20};
		t2.array = t2.sortArraySpecificToNumber(t2.array, 10);
		System.out.println("SortedSpecifically:: " + Arrays.toString(t2.array));

		ArrayAlgos t3 = new ArrayAlgos();
		t3.array = new int[]{67,1,245,563,9,90,123};
		t3.array = t3.sortMukand(t3.array);
		System.out.println(Arrays.toString(t3.array));
	}

	public int[] reverseArray(int[] arr)
	{
		int i=0;
		int temp;
		if(arr.length < 2)
			return arr;
		else
		{
			while(i < arr.length/2)
			{
				int index = arr.length - (1+i);
				temp = arr[i];
				arr[i] = arr[index];
				arr[index] = temp;
				i++;
			}
		}
		return arr;
	}

	public int searchInSortedRotated(int[] arr, int key)
	{
		int pivot = getPivotElement(arr, 0, arr.length-1);

		if(arr[pivot] > key)
			return -1;

		if(key == arr[0])
			return 0;

		if( key == arr[pivot])
			return pivot;

		if(key > arr[0])
			return binarySearch(arr, 0, pivot-1, key);
		else
			return binarySearch(arr, pivot+1, arr.length-1, key);
	}	

	public int binarySearch(int[] arr, int l, int h, int key)
	{
		int mid = (l+h)/2;

		if(l>h) 
			return -1;

		if(arr[mid] == key)
			return mid;

		if(key > arr[mid])
			return binarySearch(arr, mid+1, h, key);
		else
			return binarySearch(arr, l, mid-1, key);
	}

	public int getPivotElement(int[] arr, int l, int h)
	{
		if(arr[l] < arr[h])
			return l;
		if(l == h)
			return l;

		int mid = (l+h)/2;
		if(arr[mid] < arr[mid+1] && arr[mid] < arr[mid-1])
			return mid;
		else
		{
			if(arr[mid] > arr[h])
				return getPivotElement(arr, mid, h);
			else
				return getPivotElement(arr, l, mid);
		}
	}

	public void subarrays(int[] arr)
	{
		int n = arr.length;
		int[][] sub_arr = new int[(n*(n+1))/2][n];

		for(int i=0; i<arr.length; i++)
		{
			for(int j=i; j<arr.length; j++)
			{
				for(int k=i; k<=j; k++)
				{
					System.out.print(arr[k] + "  ");
					sub_arr[ (i*(n-i)+(k-i) )][k-i] = arr[k];
				}
				System.out.println();
				n++;
			}
		}

		for(int i1=0; i1<(n*(n+1)/2); i1++)
		{
			for(int i2=0; i2<10; i2++)
			{
				System.out.println(sub_arr[i1][i2] + "	");
			}System.out.println();
		}
	}


	public boolean hasTwoCandidate(int[] arr, int sum)
	{
		int l = 0, h = arr.length-1;
		
		while(l<h)
		{
			if( arr[l] + arr[h] == sum )
				return true;
			else if(arr[l] + arr[h] > sum)
				h--;
			else if(arr[l] + arr[h] < sum)
				l++;
		}

		return false;
	}

	public void triplets(int[] arr, int sum)
	{
		int size = arr.length;
		int l = 0, h = size-1, flag=0;

		for(int i=0; i<size-2; i++)
		{
			while(l < h)
			{
				if(arr[i] + arr[l] + arr[h] == sum)
				{
					System.out.println(arr[i] + "  " + arr[l] + "  " + arr[h]);
					flag = 1;
				}
				if(arr[i] + arr[l] + arr[h] < sum)
					l++;
				else
					h--;
			}			
		}

		if(flag == 0)
			System.out.println("No triplet found");
	}

	/*public int maximumSum(int[] arr)
	{
		
	}*/

	public boolean reachable(int[] arr, int index)
	{
		int n = arr.length;
		boolean result = false;

		if(arr[0] == 0)
			return false;
		else
		{
			if(arr[index]+index >= n)
				return true;
			else 
			{
				int k=arr[index];
				while( k>0 )
				{
					result = reachable(arr, index+k);
					k--;
				}
				return result;
			}
		}
	}

	Integer getMedian(Integer a, Integer b)
	{
		return (a+b)/2;
	}

	public Integer medianSortedArraySameSize(int[] arr1, int[] arr2)
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

	int[] sortArraySpecificToNumber(int[] arr, int num)
	{
		TreeMap<Integer, Integer> t = new TreeMap<Integer, Integer>();
		for(int i=0;i<arr.length; i++)
		{
			t.put(Math.abs(num-arr[i]), arr[i]);
		}

		int i=0;
		for(Map.Entry entry : t.entrySet())
		{
			arr[i] = (int)entry.getValue();
			i++;
		}

		return arr;
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