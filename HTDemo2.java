import java.util.*;


class HTDemo2
{
  public static void main(String arg[])
  {
  
	Hashtable<String,Double> l=new Hashtable<String,Double>();
		
		l.put("a",new Double(767));
		l.put("b",new Double(656));
			
		Set<String> s=l.keySet();
		 
		Iterator<String> i=s.iterator(); 
		while(i.hasNext())
		{
			String str=i.next();
			System.out.println(str+" "+l.get(str));
		}	
  
  }
  

}


