public class TernarySearch
{
	int[] arr;

	int search(int[] arr, int l, int r, int key)
	{
		int mid1 = l + (r-l)/3;
		int mid2 = l + ((r-l)*2)/3;

		if(l <= r)
		{
			if(arr[mid1] == key)
				return mid1;

			if(arr[mid2] == key)
				return mid2;

			if(key < arr[mid1])
				return search(arr, l, mid1-1, key);

			if(key > arr[mid2])
				return search(arr, mid2+1, r, key);

			if(key < arr[mid2])
				return search(arr, mid1+1, mid2-1, key);		
		}

		return -1;
	}

	public static void main(String[] args)
	{
		TernarySearch ts = new TernarySearch();
		ts.arr = new int[]{1,4,6,8,10,14,18,37,46,59};
		int index = ts.search(ts.arr, 0, ts.arr.length-1, 0);
		if(index != -1)
			System.out.println("Element searched[" + ts.arr[index] + "] at index: " + index);
		else
			System.out.println("Element not found");
	}
}