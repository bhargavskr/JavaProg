import java.io.*;

class CharArrayReaderDemo
{
	public static void main(String arg[])
	{
		String s="adhjgkfafffad";
		char c[]=new char[s.length()];
		s.getChars(0,s.length(),c,0);
		int c1;
		try(CharArrayReader ca=new CharArrayReader(c))
		{
			while((c1=ca.read())!=-1)
				System.out.print((char)c1);
				
		
		}
		catch(IOException e)
		{
		  System.out.println(e);
		}
		System.out.println();
		try(CharArrayReader ca=new CharArrayReader(c,0,6))
		{
		
			while((c1=ca.read())!=-1)
				System.out.print((char)c1);
				
		
		}
		catch(IOException e)
		{
		  System.out.println(e);
		}
		
		
		
	}

}