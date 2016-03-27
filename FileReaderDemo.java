import java.io.*;

class FileReaderDemo
{
	public static void main(String arg[])
	{
		int c;
		try(FileReader fr=new FileReader("f1.txt"))
		{
		
			while((c=fr.read())!=-1)
			System.out.print((char)c);
		
		}
		catch(IOException e)
		{
			System.out.println(e);
		}
 
	}
}