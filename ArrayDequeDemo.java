import java.util.*;

class ArrayDequeDemo
{
	public static void main(String arg[])
	{
		ArrayDeque<String> adq=new ArrayDeque<String>();
		adq.push("A");
		adq.push("D");
		adq.push("H");
		adq.push("G");
		
		while(adq.peek()!=null)
		System.out.println(adq.pop()+" ");
		
		
		
		System.out.println();
	}
}
	