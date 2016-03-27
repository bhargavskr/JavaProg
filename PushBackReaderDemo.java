import java.io.*;

class PushBackReaderDemo
{
	public static void main(String arg[])
	{
			int c;
			String s="a==b jskdfj =e";
			char c1[]=new char[s.length()];
			s.getChars(0,s.length(),c1,0);	
			CharArrayReader ca=new CharArrayReader(c1);
			try(PushbackReader p=new PushbackReader(ca))
			{
				while((c=p.read())!=-1)
				{
					switch(c)
					{	
					
						case '=':
						if((c=p.read())=='=')
						     System.out.print("eq");
						else
						{
							System.out.print("<-");
							p.unread(c);
						}	
						break;
						default:
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