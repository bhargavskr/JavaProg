import java.util.*;

class LinkedListDemo
{
	public static void main(String args[])
	{
		LinkedList<String> st=new LinkedList<String>();
		st.add("a");
		st.add("b");
		st.add("c");
		st.add("d");
		st.addFirst("e");
		st.addLast("f");
		
		st.add(1,"k");
		
		System.out.println("Contents:"+st);
		System.out.println(st.remove("f"));
		System.out.println(st.remove("2"));
		
		System.out.println("COntents "+st);
		st.removeFirst();
		st.removeLast();
		
		System.out.println(" contents"+st);
		
		String Val=st.get(2);
		st.set(2,Val+" Changed ");
		
		System.out.println(st);
	
	
	
	}

}