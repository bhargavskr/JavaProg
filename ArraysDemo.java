import java.util.*;

class ArraysDemo
{

	public static void main(String arg[])
	{
		int a[]=new int[10];
		for(int i=0;i<10;i++)
		{
			a[i]=-3*i;
			
		
		}
		System.out.print(" Contents");
		display(a);
		
		System.out.print(" Sorted ");
		Arrays.sort(a);
		display(a);
		
		Arrays.fill(a,2,6,-1);
		System.out.print(" Filled ");
		display(a);
		
		Arrays.sort(a);
		System.out.print(" SOrted ");
		display(a);
		
		int in=Arrays.binarySearch(a,-9);
		System.out.print("Search -9 at "+in);	
	}	
		static void display(int a[])
		{
			for(int m:a)
			System.out.print(m+" ");
			System.out.println();
		}
		
		
	
	










}

