//import java.io.*;
class Light
{
	public static void main(String args[])
	{
		byte a=40;
	   int lightspeed;
	   long days;
	   long seconds;
	   long distance;
	   lightspeed=186000;
	   days=100;
	   seconds=days*24*60*60;
	   distance=lightspeed*seconds;
	   System.out.println(a);
	   System.out.print("In"+days);
	   System.out.println("Days light wll travel about");
	   System.out.println(distance+"miles.");
	}
}	