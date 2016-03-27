import java.io.*;

class PrintfDemo
{
	public static void main(String arg[])
	{
		System.out.println(" Here are some values"+"in diffrent formats");
		System.out.printf(" %d %(d %+d %05d\n", 3,-3,3,3);
		System.out.println();
		System.out.printf(" Default floating point format %f \n",123.72);
		System.out.printf(" Floating point with commas:%,f \n",287812.22);
		System.out.printf(" Negative point defalut: %,f\n ", -1267621.22);
		System.out.printf(" Negative option: %,(f \n",-78628162.22);
		
		System.out.printf(" % ,.2f\n% ,.2f\n",12123.22,-2123.22);
		
	
	
	}


}
