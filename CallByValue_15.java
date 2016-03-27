class TestCallValue
{	
	
	
	void change(int a,int b)
	{
	int k=8,o=7;
			k*=a;
		 o*=b;
	}
	
}
class CallByValue_15
{
	public static void main(String arg[])
	{
		TestCallValue l=new TestCallValue();
		
	//	System.out.println(" a and b are "+a+" "+b);
		int k,o;
		k=98;
		o=876;
		System.out.println(" a and b are "+k+" "+o);
		
		
		l.change(k,o);
	
		System.out.println(" a and b are "+k+" "+o);
	}
}	
			