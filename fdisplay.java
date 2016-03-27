//DISPLAYING A FILE//
import java.io.File;
import java.io.*;
class display
{
	String str=new String();
	void getfile()throws IOException
	{
		DataInputStream dis =new DataInputStream(System.in);
		System.out.println("enter file name");
		str=dis.readLine();
		FileInputStream f=new FileInputStream(str);
		int a=f.read(),i=1;
		if(a==-1)
			System.out.println("file does not exists");
		else
		{
			System.out.println("file  exists");	
			System.out.print(i+++" ");
			while(a!=-1)
			{
				System.out.print((char)a);
				if((char)a=='\n')
					System.out.print(i+++" ");
				a=f.read();
			}
		}
	}
}
class fdisplay
{
	public static void main(String args[])throws IOException
	{
		display d=new display();
		d.getfile();
	}
}
	