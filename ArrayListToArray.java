import java.util.*;

class ArrayListToArray
{
 public static void main(String arg[])
 {
	ArrayList<String> al=new ArrayList<String>();
	al.add("Bhargav");
	al.add("Krishna");
	al.add(1,"Sai");
	al.add("Ravuri");
	System.out.println(al);
	String[] st=new String[al.size()];
	st=al.toArray(st);
	
	String na=new String();
	for( String i:st)
	   na+=i;
	System.out.println(na);
 }	
}