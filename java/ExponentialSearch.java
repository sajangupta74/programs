public class ExponentialSearch
{
	int[] arr;

	int binarySearch(int[] arr, int l, int r, int x)
	{	
		int mid;
		mid = l+(r-l)/2;

		if(arr[mid] == x)
			return mid;

		if(arr[mid] < x)
			return binarySearch(arr, mid+1, r, x);
		if(arr[mid] > x)
			return binarySearch(arr, l, mid, x);

		return -1;
	}

	int search(int[] arr, int x)
	{
		int i=1,
			n = arr.length;

		if(arr[0] == x)
			return 0;

		while(i < (n-1) && arr[i] < x)
		{
			i = i*2;
		}
		
		return binarySearch(arr, i/2, Math.min(i, n-1), x);
	}

	public static void main(String[] args)
	{
		ExponentialSearch es = new ExponentialSearch();

		es.arr = new int[]{1,2,3,4,5,6};
		int index = es.search(es.arr, 1);

		System.out.println("Index::	" + index);
	}
}