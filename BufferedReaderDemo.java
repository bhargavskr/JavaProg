import java.io.*;

class BufferedReaderDemo
{
	public static void main(String arg[])
	{
		boolean mark=false;
			String a="This is &copy; hi how are &copy rights;";
		char c1[]=new char[a.length()]; 
	
		a.getChars(0,a.length(),c1,0);
		CharArrayReader ca=new CharArrayReader(c1);	
		int c;
		try(BufferedReader bu=new BufferedReader(ca))
		{
		
			while((c=bu.read())!=-1)
			{
		
				switch(c)
				{
					case '&':
					if(!mark)
					{
					bu.mark(32);
					mark=true;
					}
					else
						mark=false;
					break;
					case ';':
					if(mark)
					{
						mark=false;
					System.out.print("(c)");
					}
					else
					System.out.print((char)c);
					break;	
					case ' ':
					if(mark)
					{
					mark=false;
					bu.reset();
					System.out.print((char)c);
					}
					else
					System.out.print((char)c);
					break;
					default:
					if(!mark)
					System.out.print((char)c);
					break;
				}
			}	
		}
		catch(IOException e)
		{
				System.out.println(e);
		}
			
		
	
	}

}