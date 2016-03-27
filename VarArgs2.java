class VarArgs2
{
	static void vaTest(String z,int ... v)
	{
		System.out.print(z+" "+v.length+" ");
		
		for(int x:v)
		  System.out.print(x+" ");
		  
		 System.out.println();
	}
	public static void main(String arg[])
	{
		vaTest("4 argumenst ",1,2,34,4);
		vaTest("No arguments");
	}
	
}