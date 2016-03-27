class VarArgs
{
	static void vaTest(int ... v)
	{
		System.out.println(" number of args "+v.length);
		for(int x:v)
		 System.out.print(x+" ");
		 
		 System.out.println();
		 
	}
	public static void main(String arg[])
	{
		vaTest(1,2,3,4);
		vaTest(20);
		vaTest();
		
	}
}	