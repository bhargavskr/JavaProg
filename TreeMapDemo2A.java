import java.util.*;

class CompLastName implements Comparator<String>
{
	public int compare(String a,String b)
	{
			int i,j;
			i=a.lastIndexOf(' ');
			j=b.lastIndexOf(' ');
			return a.substring(i).compareToIgnoreCase(b.substring(j));
			
		
	}


}
class CompThenByFirstName implements Comparator<String>
{
	public int compare(String a,String b)
	{
		int i,j;
		return a.compareToIgnoreCase(b);
	
	}

}

class TreeMapDemo2A 
{

	public static void main(String arg[])
	{
		
		CompLastName c=new CompLastName();
		Comparator<String> c1=c.thenComparing(new CompThenByFirstName());
		TreeMap<String,Double> l=new TreeMap<String,Double>(c1);
		l.put("c b",new Double(12.1));
		l.put("a b",new Double(12.1));
		l.put("k l",new Double(12.1));	
		
		Set<Map.Entry<String,Double>> set=l.entrySet();
		
		for(Map.Entry<String,Double> m:set)
		System.out.println(m.getKey()+" "+m.getValue());
		
		

	}
	
}