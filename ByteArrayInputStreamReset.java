import java.io.*;

class ByteArrayInputStreamReset
{
	public static void main(String arg[])
	{	
		String x="abc";
		byte l[]=x.getBytes();
		ByteArrayInputStream p=new ByteArrayInputStream(l);
		for(int i=0;i<2;i++)
		{
				int c;
				while((c=p.read())!=-1)
				{
					if(i==0)
						System.out.println((char)c);
					else
						System.out.println(Character.toUpperCase((char)c));
						
				}
			p.reset();
		}
		
	
	}

}