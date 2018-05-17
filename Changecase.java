class ChangeCase
{
	public static String changecase(String s)
	{
		char ch[]=s.toCharArray();
		int num[]=new int[s.length()];
		for(int i=0;i<s.length();i++)
		{
			num[i]=ch[i];
			if(num[i]>=65&&num[i]<=90)
			num[i]=num[i]+32;
			else if(num[i]>=97&&num[i]<=122)
			num[i]=num[i]-32;
		}
		for(int i=0;i<s.length();i++)
		{
			ch[i]=(char)num[i];
		}
		String temp=new String(ch);
		return temp;
	}
	public static void main(String... s1)
	{
		String s2="iNDia Is GOOd";
		System.out.println("original string:"+s2);
		s2=changecase(s2);
		System.out.println("new string:"+s2);
	}
}	

