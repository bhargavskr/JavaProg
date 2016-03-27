import java.io.*;

class PushBackInputStreamDemo
{
	public static void main(String arg[])
	{
			int c;
			String s="a==b jskdfj =e";
			byte a[]=s.getBytes();
			ByteArrayInputStream by=new ByteArrayInputStream(a);
			try(PushbackInputStream p=new PushbackInputStream(by))
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