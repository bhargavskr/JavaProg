import java.io.*;
import java.util.*;


class InputStreamEnumerator implements Enumeration<FileInputStream>
{
	private Enumeration<String> files;
	public InputStreamEnumerator(Vector<String> files)
	{
		this.files=files.elements();
	
	}
	
	public boolean hasMoreElements()
	{
		return files.hasMoreElements();
		
	}
	
	public FileInputStream nextElement()
	{
		try{
		return new FileInputStream(files.nextElement().toString());
		}
		catch(IOException e)
		{
			return null;
		}
	}
	

}
class SequenceInputStreamDemo
{
	public static void main(String arg[])
	{
		int c;
		Vector<String> v=new Vector<String>();
		v.addElement("f1.txt");
		v.addElement("f2.txt");
		v.addElement("f3.txt");
		InputStreamEnumerator ise= new InputStreamEnumerator(v);
		
		InputStream s=new SequenceInputStream(ise);
		
		try{
			while((c=s.read())!=-1)
			{
			System.out.print((char)c);
			}
		}
		catch(IOException e)
		{
			System.out.println(e);
			
		}
		finally
		{
			try{
				s.close();
			}
			catch(Exception e){
			System.out.println(e);
			
			}

		}			
		
		
		
		
	}


}