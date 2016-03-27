import java.util.*;

class ArrayListDemo
{
	public static void main(String args[])
	{
		ArrayList<String> al=new ArrayList<String>();
		System.out.println("Initial size of the al: "+al.size());
		al.add("C");
		al.add("F");
		al.add("H");
		al.add("U");
		al.add("Y");
		al.add("M");
		al.add(1,"A2");
		System.out.println(" Size of the arralist al "+al.size());
System.out.println(" Contents of al: "+al);
		
	System.out.println(al.remove("F"));
		System.out.println(al.remove("2"));
		System.out.println(" Size of the arraylist al "+al.size());
		System.out.println(" Contents of al: "+al);
	}



}

