public class QuickSort
{
	int[] arr;

	public static void main(String[] args)
	{
		QuickSort qs = new QuickSort();
		qs.arr = new int[]{5,4,3,2,1};
		qs.quick_sort(qs.arr, 0, qs.arr.length-1);
		qs.printArray(qs.arr);
		System.out.println();
	}

	void printArray(int[] arr)
	{
		for(int i=0; i<arr.length; i++)
		{
			System.out.print(arr[i] + "	");
		}
	}

	void swap(int[] arr, int l, int r)
	{
		int temp;
		temp = arr[l];
		arr[l] = arr[r];
		arr[r] = temp;
	}

	int partition ( int A[],int start ,int end)
	{
	    int i = start + 1;
	    int piv = A[start] ;            //make the first element as pivot element.
	    for(int j =start + 1; j <= end ; j++ )  {
	    /*rearrange the array by putting elements which are less than pivot
	       on one side and which are greater that on other. */

	          if ( A[ j ] < piv) {
	                 swap(arr, i, j);
	            i += 1;
	        }
	   }
	   swap(arr, start, i-1) ;  //put the pivot element in its proper place.
	   return i-1;                      //return the position of the pivot
	}

	void quick_sort ( int A[ ] ,int start , int end ) {
   		if( start < end ) {
	        //stores the position of pivot element
	        int piv_pos = partition (A,start , end ) ;     
	        quick_sort (A,start , piv_pos -1);    //sorts the left side of pivot.
	        quick_sort ( A,piv_pos +1 , end) ; //sorts the right side of pivot.
   		}
	}
}