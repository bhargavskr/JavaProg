import java.util.*;

class ForEachDemo
{
	public static void main(String arg[])
	{
		ArrayList<Integer> vals=new ArrayList<Integer>();
		vals.add(1);
		vals.add(2);
		vals.add(3);
		
		System.out.println(vals);
		for(int v:vals)
		System.out.print(v+" ");
		
		System.out.println();
		int sum=0;
		for(int v: vals)
		sum+=v;
		
	 System.out.println(sum);
	 
		
	
	}
	



}
