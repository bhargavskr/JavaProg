import java.io.*;
class LastK
{
	public static void main(String arg[])
	{
		int k=Integer.parseInt(arg[0]);
		int f2,count=0;
		try(FileInputStream f=new FileInputStream("LastK.java");FileInputStream f1=new FileInputStream("LastK.java"))
		{
		int c;
			while((c=f.read())!=-1)
			{
				
				if(c=='\n')
					count++;
			}
			f2=count-k;
			System.out.println(count);
	
			count=0;
			
		
			while((c=f1.read())!=-1)
			{
				
				if(c=='\n')
					count++;
				if(count>f2)	
					System.out.print((char)c);	
			}	
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	
	
	
	
	
	
	
	
	}


}