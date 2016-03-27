import java.util.*;

class TComp implements Comparator<String>
{
 public int compare(String a, String b)
 {
	String a1,b1;
	int i,j,k;
	a1=a;
	b1=b;
	
	i=a1.lastIndexOf(' ');
	j=b1.lastIndexOf(' ');
	
	k=a1.substring(i).compareTo(b1.substring(j));
	
	if(k==0)
	return a1.compareTo(b1);
	else
	  return k;
	  
	
 
 }




}

class TreeMapDemo2
{
public static void main(String arg[])
{
	TreeMap<String,Double> l=new TreeMap<String,Double>(new TComp());
	
	l.put("Rayn kim", new Double(65756.8));
	l.put("gom tim", new Double(64566.87));
	l.put("lolp bvva",new Double(675762.876));
	
	Set<Map.Entry<String,Double>> p=l.entrySet();
	
	for(Map.Entry q:p)
	System.out.println(q.getKey()+" "+q.getValue());
	
	double b=l.get("gom tim");
	l.put("gom tim",b+56627);
		
System.out.println(l.get("gom tim"));


}
}