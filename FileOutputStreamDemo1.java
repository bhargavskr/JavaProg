import java.io.*;

class FileOutputStreamDemo1
{
	public static void main(String arg[])
	{
		String s=new String(" Hi How are you \n	Hi where are you \n Hi who are you");
		byte buf[]=s.getBytes();
	
		
		try(FileOutputStream a=new FileOutputStream("f1.txt");FileOutputStream b=new FileOutputStream("f2.txt");FileOutputStream c=new FileOutputStream("f3.txt"))
		{
			for(int i=0;i<buf.length;i+=2)
					a.write(buf[i]);
					
			b.write(buf);
			
			c.write(buf,buf.length-buf.length/4,buf.length/4);
			
		}
		catch(IOException e)
		{
		
			System.out.println(e);
			
		}
		
		
		
		
	}
			
			
			
			
			
			
			
			
}


