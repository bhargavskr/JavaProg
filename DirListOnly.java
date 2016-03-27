import java.io.*;


class OnlyExt implements FilenameFilter
{
	String ext;
	
	public OnlyExt(String str)
	{
		ext = "."+str;
	}
	public boolean accept(File dir,String name)
	{
		return name.endsWith(ext);
	}

}
class DirListOnly
{

	public static void main(String arg[])
	{
		String dirname="C:/Study/2/bhargav";
		File d=new File(dirname);
		FilenameFilter only=new OnlyExt("java");
		String s[]=d.list(only);
		for(String z:s)
		{
			System.out.println(z);
		
		}
	
	
	
	
	
	
	}

}