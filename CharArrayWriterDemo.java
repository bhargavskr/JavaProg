import java.io.*;

class CharArrayWriterDemo
{
	public static void main(String arg[])
	{
		String s="Hi how are you";
		char b[]=new char[s.length()];
		s.getChars(0,s.length(),b,0);
		CharArrayWriter f=new CharArrayWriter();
		
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
		char c2[]=f.toCharArray();
		for(char i:c2)
			System.out.print(i);
			
		System.out.println(" To a output Stream");	
		
		try(FileWriter f1=new FileWriter("text.txt"))
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