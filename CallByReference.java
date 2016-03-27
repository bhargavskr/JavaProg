class TestCallReference
{	
	
	int k,o;
	TestCallReference()
	{
		k=9;
		o=7;
	}
	
	void change(TestCallReference g)
	{
	
			k*=g.k;
		 o*=g.o;
	}
	
}
class CallByReference 
{
	public static void main(String arg[])
	{
		TestCallReference l=new TestCallReference();
		
	//	System.out.println(" a and b are "+a+" "+b);

		System.out.println(" a and b are "+l.k+" "+l.o);
		
		
		l.change(l);
	
		System.out.println(" a and b are "+l.k+" "+l.o);
	}
}	
			