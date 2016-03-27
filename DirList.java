import java.io.File;

class DirList
{
	public static void main(String arg[])
	{
		String dirname="C:/Study/2/bhargav";
		File dir=new File(dirname);
		if(dir.isDirectory())
		{
				System.out.println(" Directory of "+dirname);
				
			String st[]=dir.list();
			for(String x:st)
			{
				File f=new File(x);
				if(f.isDirectory())
					System.out.println(x+" is directory");
				else
					System.out.println(x+" is File");
			}	
		}
		else
				System.out.println(" not directory ");
		
	}			

}