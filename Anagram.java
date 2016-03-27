import java.io.*;
import java.util.*;

class Anagram
{

	public static boolean 	check(String a, String b)
	{
		if(a.length()!=b.length())
			return false;	
		a=sort(a);	
		b=sort(b);	
		return a.equals(b);
	}
	
	public static String sort(String a)
	{
			char a2[]=a.toLowerCase().toCharArray();
			Arrays.sort(a2);	
			return String.valueOf(a2);
			
	}

	public static void main(String arg[])
	{
		
		String a=arg[0];
		String b=arg[1];
		
		boolean z=check(a,b);	
		if(z)
		System.out.println("Yes");
		else
		System.out.println("No");
	
		
		
		
		
	}

}
