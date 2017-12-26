public class SubString
{
	public static void main(String[] args)
	{
		SubString ss = new SubString();
		String t = ss.validSubString("Saaaaaaajaaaaaaaan");
		System.out.println(t);
	}

	String replacementString(String str, int l, int r)
	{
		int i=0;
		System.out.println("l:: " + l + "r:: " + r + "	length:: " + str.length());
		while(l<=r)
		{
			i++;
			l++;
		}
		if(i%2 == 0)
			return "";
		else
			return Character.toString(str.charAt(r));
	}

	String validSubString(String str)
	{
		int n = str.length();
		char c;
		String temp="";

		for(int i=0; i<str.length()-1; i++)
		{
			c = str.charAt(i);
			if(i<(n-1) && c == str.charAt(i+1) )
			{
				int j = i+1;
				while( j<n && c == str.charAt(j))
				{
					j++;
				}
				j = j-1;

				System.out.println(str);
				System.out.println("i:: " + i + " j:: " + j);
				System.out.println("Str1: " + str.substring(0,i) + " Str2:: " + " Str3:: " + str.substring(j+1, n));
				String replace = replacementString(str, i, j);

				temp = str.substring(0,i) + replace + str.substring(j+1, n);
				str = temp;
				i = 0;
			}
		}
		
		return str;
	}
}