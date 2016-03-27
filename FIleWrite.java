import java.io.*;
class FileWrite
{
		public static void main(String arg[])
		{
			File f=new File("Example.txt");
			if(f.exists())
			{
				
				System.out.println(" File is already created ");
			
			
			
			}
			else
			{
				try
				{
				FileWriter fw=new FileWriter(f,true);
				String s=" Good Morning";
				fw.write(s);
				fw.close();
				}
				catch(IOException e)
				{
					System.out.println("IO Exception Generated ");
					
				}
				
			}
		}
}		



