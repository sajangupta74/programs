
public class Temp
{
	public static void main(String[] args)
	{
		//printPascalTriangleRow(Integer.parseInt(args[0]));

		System.out.println("String \'ELEPHANT\' :: " + getSubString("elephant", "eph"));
	}

	static void printPascalTriangleRow(int row)
	{
		if(row < 1)
			return;
		else if(row == 1)
			System.out.println("1");
		else if(row == 2)
			System.out.println("1 1");
		else
			printRow(new int[]{1,1}, row, 3);
	}

	static void printRow(int[] arr, int max, int ctr)
	{
		int size = arr.length, i=0;
		int[] temp = new int[size+1];

		for(i=0; i<size; i++)
		{
			if(i == 0)
				temp[i] = 1;
			else
				temp[i] = arr[i-1] + arr[i];
		}
		temp[size] = 1;
		if( max == ctr )
		{
			for(i=0; i<ctr; i++)
			{
				System.out.print(temp[i] + " ");
			}
			System.out.println();
		}

		if(ctr<max)
			printRow(temp, max, ctr+1);
	}	

	static boolean stringMatch(String str1, String str2, int pos)
	{
		int s=str2.length()-1;
		while(s>0 && str1.charAt(pos) == str2.charAt(s))
		{
			s--;
			pos--;
		}
		if(s==0)
			return true;
		else
			return false;
	}

	static int getSubString(String str, String substring)
	{
		if(str == null || substring == null)
			return -1;
		else
		{
			int size = substring.length(), pos=0;
			for(int i=0;i<str.length();i++)
			{
				if(str.charAt(i) == substring.charAt(pos))
				{
					boolean match = stringMatch(str, substring, i+size-1);

					if(match == true)
						return i;
					else
					{
						pos = 0;
					}
				}
			}

			return -1;
		}
	}
}
