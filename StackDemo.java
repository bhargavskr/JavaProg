import java.util.*;


class StackDemo
{

	public static void main(String arg[])
	{
    Stack<Integer> st=new Stack<Integer>();
	
	System.out.println(st.push(65));
	System.out.println(st.push(658));	
	System.out.println(st.push(7751));
	System.out.println(st.search(65));
	System.out.println(st.pop());
	System.out.println(st.pop());
	System.out.println(st);
	
	
	}
}

