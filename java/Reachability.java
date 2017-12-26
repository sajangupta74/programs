public class Reachability
{
	int[] arr;

	public static void main(String[] args)
	{
		Reachability reach = new Reachability();
		reach.arr = new int[]{1,2,1,1,1,1,2,3,4,1,1,1};
		System.out.println(reach.reachable(reach.arr, 0));
	}

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
}