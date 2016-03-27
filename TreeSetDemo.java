import java.util.*;

class TreeSetDemo
{
	public static void main(String arg[])
	{	
		
	TreeSet<String> st=new TreeSet<String>();
	st.add("C");
	st.add("M");
	st.add("K");
	st.add("Y");
	System.out.println(st.subSet("M","Y"));
	System.out.println(st);
		
		}




}