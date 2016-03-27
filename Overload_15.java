class Overload_15
{
	public static void main(String args[])
	{
		OverLoadDemo a=new OverLoadDemo();
		double result;
		a.test();
		a.test(1);
		a.test(1,4);
		result=a.test(76.8);
		
		System.out.println(" Result of a.test(76.8)"+result);
	}
}
		
		
		