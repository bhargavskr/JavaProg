import java.util.*;

class HTDemo
{
	public static void main(String arg[])
	{
	Hashtable<String,Double> l=new Hashtable<String,Double>();
	
	l.put("l1",new Double(6575));
    l.put("p",new Double(677));
    l.put("u",new Double(77));

	Enumeration<String> names;
	
	
	names=l.keys();
	while(names.hasMoreElements())
	{
	String str=names.nextElement();
	System.out.println(str+" "+l.get(str));
	}
	double k=l.get("l1");
	l.put("l1",k+7617);
	System.out.println(l.get("l"));
	
	}

}