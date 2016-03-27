import java.util.*;


class TreeMapDemo
{


	public static void main(String arg[])
	{
		TreeMap<String,Double> k=new TreeMap<String,Double>();
		
		
		
		k.put("Bhargav",new Double(65656.77));
		k.put("Sai", new Double(5456467.78));
		k.put("Krishna",new Double(6565.677));
		
		
		Set<Map.Entry<String,Double>> o=k.entrySet();
		
		
		for( Map.Entry<String,Double> j:o)
		System.out.println(j.getKey()+" "+j.getValue());
		
		double g=k.get("Sai");
		
		k.put("Sai",g+876252);
		
		System.out.println("Sai: "+k.get("Sai"));
		
		
		
		}
		}