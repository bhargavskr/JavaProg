import java.util.*;

class IteratorDemo
{
	public static void main(String arg[])
	{
		ArrayList<String> al=new ArrayList<String>();
		al.add("C");
		al.add("N");
		al.add("L");
		al.add("O");
		
		System.out.println(" Original : "+al);
		Iterator<String> itr=al.iterator();
		while(itr.hasNext())
		{
		   String ele=itr.next();
		   System.out.print(ele+" ");
        }
		System.out.println();
		
		
		ListIterator<String> litr=al.listIterator();
		//		System.out.println("k");

		while(litr.hasNext())
		{
		 String ele=litr.next();
//		System.out.println("k");

		 litr.set(ele+"+");
		 
	
		}

		System.out.println("k");
		
		System.out.print(" Modified ");
        itr=al.iterator();
         while(itr.hasNext())
		{
		  String ele=itr.next();
		  System.out.print(ele+" ");
		 }
       	System.out.println();
        System.out.print(" Modified ");
        while(litr.hasPrevious())
      {
			String ele=litr.previous();
			System.out.print(ele+" ");
			
	}
}
}	
  		 

              










	
