class TestObjectReturn
{
	int a;
	TestObjectReturn(int k)
	{
	   a=k;
	 }  
	
	TestObjectReturn objectMod()
	{
		TestObjectReturn k=new TestObjectReturn(a*56);
		return k;
	}
}

class ObjectReturn
{

	public static void main(String arg[])
	{
	TestObjectReturn l=new TestObjectReturn(7);
	
	System.out.println(" value of a "+l.a);
	
	TestObjectReturn p=l.objectMod();
	
	System.out.println("value of a "+p.a);
	}
}
	