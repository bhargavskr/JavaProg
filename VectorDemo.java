import java.util.*;

class VectorDemo
{
 public static void main(String args[])
 {	
	Vector<Integer> l=new Vector<Integer>();
	
	System.out.println(" Size "+l.size());
	System.out.println(" Capacity "+l.capacity());
	
	
	
	l.addElement(17);
	l.addElement(720);
	l.addElement(656);
	l.addElement(1);
	
	System.out.println(" Capacity "+l.capacity());
	
	l.addElement(8);
	System.out.println(" Size "+l.size());

	l.addElement(678);
	l.addElement(67);
	
	System.out.println(" Capacity "+l.capacity());
	
	l.addElement(67);
	l.addElement(545);
	
	System.out.println(" Capacity "+l.capacity());
	
	System.out.println(" First "+l.firstElement());
	System.out.println(" Last "+l.lastElement());
   
    if(l.contains(8))
	  System.out.println(" 8 ");
	  
	Enumeration<Integer> en=l.elements();

	while(en.hasMoreElements())
	System.out.print(en.nextElement()+" ");
	
	
	
 
 
 
 }
 
}