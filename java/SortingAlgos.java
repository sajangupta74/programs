public class SortingAlgos
{
	int[] arr;

	public static void main(String[] args)
	{
		SortingAlgos sa = new SortingAlgos();

		sa.arr = new int[]{98,87,56,76,23,45,21,5,29,53};
		/*sa.arr = sa.selectionSort(sa.arr);

		for(int i=0; i<sa.arr.length; i++)
		{
			System.out.print(sa.arr[i] + "  ");
		}*/

		sa.mergeSort(sa.arr, 0, sa.arr.length-1);
		sa.printArray(sa.arr);
	}

	void printArray(int[] arr)
	{
		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i] + "	");
		System.out.println();
	}

	int[] selectionSort(int[] arr)
	{
		int size = arr.length;
		int min, temp;

		for(int i=0; i<size-1; i++)
		{
			min = i;
			for(int j=i+1; j<size; j++)
			{
				if(arr[min] > arr[j])
					min = j;
			}

			temp = arr[i];
			arr[i] = arr[min];
			arr[min] = temp;
		}

		return arr;
	}

	void mergeSort(int[] arr, int l, int r)
	{
		if(l < r)
		{
			int mid = (l+r)/2;
			mergeSort(arr, l, mid);
			mergeSort(arr, mid+1, r);
			merger(arr, l, mid, r);
		}
	}

	void merger(int[] arr, int start, int mid, int end)
	{
		int p,q,k=0;
		int[] a = new int[end-start+1];
		p = start;
		q = mid + 1;

		for(int i=start; i<=end; i++)
		{
			if(p>mid)
				a[k] = arr[q++];
			else if(q>end)
				a[k] = arr[p++];
			else if(arr[p] < arr[q])
				a[k] = arr[p++];
			else
				a[k] = arr[q++];
			k++;
		}

		for(int j=0;j<k; j++)
			arr[start++] = a[j];
	}
}