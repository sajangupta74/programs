public class JumpSearch
{
	public int[] arr;

	public static void main(String[] args)
	{	
		JumpSearch js = new JumpSearch();

		js.arr = new int[]{1,3,5,7,9,11,13,15,16,17,19,24,29};
		int index = js.search(js.arr, 50);
		if(index != -1)
			System.out.println("Index of element[" + js.arr[index] + "] is:: " + index);
		else
			System.out.println("Element not found");
	}

	public int search(int[] arr, int x)
	{
		int step = (int)Math.floor(Math.sqrt(arr.length)),
			size = arr.length,
			prev = 0;

		if(arr[size-1] < x)
			return -1;

		while(arr[prev+step] < x)
		{
			prev = step + prev;
			if(prev > size)
				return -1;
		}

		while(prev <= Math.min(step+prev,size-1))
		{
			if(arr[prev] == x)
				return prev;
			prev++;
		}
		return -1;
	}
}