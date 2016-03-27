import java.io.*;
class FileDemo
{
	static void p(String s)
	{
		
			System.out.println(s);
	
	}
	public static void main(String arg[])
	{
		File f1 = new File("weka-output.txt");
		p(" File name "+f1.getName());
		p(" Path "+f1.getPath());
		p(" Abs Path "+f1.getAbsolutePath());
		p("Pareent "+f1.getParent());
		p(f1.exists()?" exsits ":" does not exists");
		p(f1.canRead()?" is readable ":" is not readable ");
		p(f1.canWrite()?" is writeable" :" is not writeable ");
		p(" is "+(f1.isDirectory()?"":" not " + " a directory" ));
		p(f1.isFile()? "is normal file ":" might be named file ");
		p(f1.isAbsolute()? " is absolute ":" is not absolute ");
		p(" File last modified "+f1.lastModified());
		p("File Size "+f1.length()+" Bytes");
		
	
	
	
	}
	
	
}	