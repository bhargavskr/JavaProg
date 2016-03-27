import java.util.*;

class Address
{

	private String name;
	private String street;
	private String city;
	private String state;
	private String code;
	
Address(String n,String s,String c,String st,String cd)
{

		name=n;
		street=s;
		city=n;
		state=st;
		code=cd;
}

public String toString()
 {
	return name+"\n"+street+" "+city+" "+state+" "+code;
 
 }
 
 }
 
 class MailList
 {
 
	public static void main(String arg[])
	{
		ArrayList<Address> s=new ArrayList<Address>();
		s.add(new Address("Bhargav","11 Oak Ave","Urbana","IL","61801"));
		s.add(new Address("Sai","12 Liu Ave","KIye","IL","886787"));
		
		for(Address v:s)
		System.out.println(v);
		
		
	}
	
	}
	
	
	
 
 