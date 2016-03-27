import java.util.*;

class MyComp implements Comparator<String>
{
	public int compare(String s1,String s2)
	{
		String a,b;
		a=s1;b=s2;
		return b.compareTo(a);
	}
}

class CompDemo
{


	public static void main(String arg[])
	{
		TreeSet<String> k=new TreeSet<String>(new MyComp());
		
		k.add("Krishna");
		k.add("Sai");
		k.add("Bhargav");
		
	for(String m:k)
	System.out.print(m);
		
	}
	
}
 


