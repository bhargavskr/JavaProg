class VarArgs3
{
	static void vaTest(int ... v)
	{
		System.out.print(" length "+v.length);
		for(int x:v)
			System.out.print(x+" ");
		System.out.println();
	}
	static void vaTest(String z,int ... v)
	{
		System.out.print(z+" length "+v.length);
		for(int x:v)
			System.out.print(x+" ");
		System.out.println();
	}
	static void vaTest(boolean ... v)
	{
		System.out.print(" length "+v.length);
		for(boolean x:v)
			System.out.print(x+" ");
		System.out.println();
	}
	
	public static void main(String args[])
	{
		vaTest(123,4,5,6,7);
		vaTest("hi ",234,6,6);
		vaTest(true,false);
		
	}
}