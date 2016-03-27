import java.io.*;

class FileInputStreamDemo
{
	public static void main(String arg[])
	{
		int size;
		try(FileInputStream f=new FileInputStream("FileInputStreamDemo.java"))
		{
			System.out.println(" Total Bytes Available "+(size=f.available()));
			int n=size/40;
			
			System.out.println(" First " +n+" bytes of the file read() at a time");
				
			for(int i=0;i<n;i++)
				System.out.println((char)f.read());
				
			System.out.println(" Still Available "+f.available());
			
			System.out.println(" Reading the next "+n+" with one read(b[]) ");
			byte b[]=new byte[n];
			if(f.read(b)!=n)	{
				System.err.println(" couldn't read "+n+" bytes ");
			}
			
			System.out.println(new String(b,0,n));
			
			System.out.println(" Still Available"+(size=f.available()));
			
			System.out.println(" Skipping half of the remaining bytes");

			f.skip(size/2);

			System.out.println(" Still available"+f.available());
			
			System.out.println(" Reading "+size/2+" bytes in the array");
			if(f.read(b,n/2,n/2)!=n/2)
			 System.err.println(" couldn't read "+n/2+"bytes."); 
			
			System.out.println(new String(b,0,b.length));
			System.out.println(" Still Available"+f.available());
			
		}
		catch(Exception e)
			{
			
				System.out.println("I/O Error "+e);
				
			}
			
		
	
			
			
		
	
	}
	
}