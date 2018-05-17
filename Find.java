public class Find
{
	public static boolean find(String s1, String s2)
	{
		int x=s1.length();
		int y=s2.length();
		int c=0;
		for(int i=0;i<=x-y&&c<y;i++)
		{
			c=0;
			int k=i;
			for(int j=0;j<y;j++)
			{
				if(s1.charAt(k)==s2.charAt(j))
				{		
					k++;
					c++;
				}
				else
				{
					break;
				}
			}
		}
		if(c==y)
		return true;
		else
		return false;
	} 	
	public static void main(String... s)
	{
		Strig p="india is beautiful. I love India";
		String q="pakistan";
		System.out.println("String 1: "+p);	
		System.out.println("String 2: "+q);
		System.out.println("Is q in p?");
		System.out.println(find(p,q));
	}
}			

