public class Palindrom
{

	public boolean palindromIterator(String str, int s, int e)
	{
		if(s == e)
			return true;

		if(str.charAt(s) != str.charAt(e))
			return false;

		if(s<e)
			return palindromIterator(str, s+1, e-1);
	}

	public boolean isPalindrom(String str)
	{
		if(str.length() == 0)
		{
			return true;
		}
			
		return palindromIterator(str, 0, str.length()-1);
	}

	public static void main(String[] args)
	{
		Palindrom p = new Palindrom();
		String str = "malayalam";
		boolean result = p.isPalindrom(str);
		System.out.println(result);
	}
}