import java.io.*;

class ByteArrayOutputStreamDemo
{
	public static void main(String arg[])
	{
		String s="Hi how are you";
		byte b[]=s.getBytes();
		ByteArrayOutputStream f=new ByteArrayOutputStream();
		
		try
		{
	
		f.write(b);
}
		catch(Exception e)
		{
			System.out.println(e);
		}
		System.out.println("Buffer as String");
		System.out.println(f.toString());
		
		System.out.println(" To Array ");
		byte b1[]=f.toByteArray();
		for(byte i:b1)
			System.out.print((char)i);
			
		System.out.println(" To a output Stream");	
		
		try(FileOutputStream f1=new FileOutputStream("text.txt"))
		{
			f.writeTo(f1);
			
		}
		catch(IOException e)
		{
		
				System.out.println(e);
		}
		
		f.reset();
		
		for(int i=0;i<2;i++)
			f.write('X');
				
		System.out.println(f.toString());
		
	}
}