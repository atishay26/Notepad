public class CharCount
{
	public static int charcount(String s)
	{
		int count=0;
		for(int i=0;i<s.length();i++)
		{
			if(s.charAt(i)!=' ')
			{
				count++;
			}
		}
		return count;
	}
	public static void main(String s2[])
	{
		String s3="jv rev      evev    bebe  sb    eb   ebb      b   d b fdb fb";//28
		System.out.println("char count is:"+charcount(s3));
	}
}
			
		

