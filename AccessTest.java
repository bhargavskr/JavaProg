class Test
{
	int a;
	public int b;
	private int c;
	
	void setc(int i)
	{
		c=i;
	}
	 
	 int getc()
	 {
		return c;
	}
}
class AccessTest
{
	public static void main(String arg[])
	{
		Test ob=new Test();
		ob.a=20;
		ob.b=72;
//		ob.c=87;
		
		ob.setc(879);
		
		System.out.println(" c is "+ob.getc());

	}
}
	 
	 