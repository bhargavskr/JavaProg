import java.io.*;

class FileOutputStreamDemo
{
	public static void main(String arg[])
	{
		String s=new String(" Hi How are you \n	Hi where are you \n Hi who are you");
		byte buf[]=s.getBytes();
		FileOutputStream a=null;
		FileOutputStream b=null;
		FileOutputStream c=null;
		
		try
		{
		a=new FileOutputStream("f1.txt");
		b=new FileOutputStream("f2.txt");
		c=new FileOutputStream("f3.txt");
		
			for(int i=0;i<buf.length;i+=2)
					a.write(buf[i]);
					
			b.write(buf);
			
			c.write(buf,buf.length-buf.length/4,buf.length/4);
			
		}
		catch(IOException e)
		{
		
			System.out.println(e);
			
		}
		finally
		{
			try
			{
				if(a!=null)
					a.close();
			
			}
			catch(IOException e)
			{
				System.out.println(e);
			}
			
			try
			{
				if(b!=null)
					b.close();
			
			}
			catch(IOException e)
			{
				System.out.println(e);
			}	
				
			try
			{
				if(c!=null)
					c.close();
			
			}
			catch(IOException e)
			{
				System.out.println(e);
			}
		
		
		
		}
			
			
			
			
			
			
			
			
	}


}