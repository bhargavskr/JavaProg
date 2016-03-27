import java.io.*;

class FileWriterDemo 
{
	public static void main(String arg[])
	{	
		
		String s=" Hi how are you";
		char bu[]=new char[s.length()];
		s.getChars(0,s.length(),bu,0);
		
		try(FileWriter f1=new FileWriter("fi1.txt");FileWriter f2=new FileWriter("fi2.txt");FileWriter f3=new FileWriter("fi3.txt"))
		{
			for(char c:bu)
			   f1.write(c);
			
			f2.write(bu);
			
			f3.write(bu,bu.length-bu.length/4,bu.length/4);
		
		
		
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	
	
	
	
	
	
	
	
	}











}