import java.io.*;
import java.util.*;
class Shuffle_Songs
{
	public static void shufflesongs(List<String> s)
	{
		Collections.shuffle(s);
//		return s;		
	}	
	
	
	public static void main(String arg[])
	{
		List<String> songs=new ArrayList<>();
		
		songs.add("1 Andala Raaksive");
		songs.add("2 Awaara Bhavre");
		songs.add("3 Bombay Theme");		
		songs.add("4 Chale_Chalo");
		songs.add("5 Champakamala");
		int x=0;
		while(x!=10)
		{
		shufflesongs(songs);
		
		for(String st:songs)
			System.out.println(st+" ");
				System.out.println();
			
		x++;
		}
	}


}