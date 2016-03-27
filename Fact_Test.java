class Factorial 
{

		int fact(int x)
	{
		System.out.println(x);
		if(x==1)
		return 1;
		int c=fact(x-1)*x;
		return c;
		
	}
}
class Fact_Test
{
	public static void main(String arg[])
	{
		Factorial a=new Factorial();
		Factorial b=new Factorial();
		
		System.out.println("Fact of  6 "+a.fact(6));
		System.out.println(" Fact of 5 "+b.fact(5));
	
	}
}	
		
		
		
		
		
		