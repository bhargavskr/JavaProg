class StaticDemo
{
	static int a=87;
	static int b=9876;
	
	static void calla()
	{
		System.out.println("a is :"+a);
	}

}

class StaticByName
{
	public static void main(String arg[])
	{
		StaticDemo.calla();
		System.out.println("b :"+StaticDemo.b);
	}
}
 