import java.util.*;

class HashmapDemo
{

	public static void main(String arg[])
	{
	
		HashMap<String,Double> hm=new HashMap<String,Double>();
		
		hm.put("Sai", new Double(1726.27));
		hm.put("Kris", new Double(175672.22));
		hm.put("Bhargav",new Double(76554.56));
		
		Set<Map.Entry<String,Double>> k=hm.entrySet();
		
		for( Map.Entry<String,Double> l:k)
			System.out.println(l.getKey()+" "+l.getValue());
			
	System.out.println();
	
	double b=hm.get("Bhargav");
	hm.put("Bhargav",b+78667);
	
	
	System.out.println(" Bhargav B: "+hm.get("Bhargav"));
	
	
	
	
	
	}












}

