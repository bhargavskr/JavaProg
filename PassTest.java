class Test 
{
	int a,b;
	Test(int a, int b)
	{
		this.a=a;
		this.b=b;
		
	}
	Test()
	{
	a=2;
	b=2;
	}
	boolean boolTest(Test o)
	{
		if(o.a==a && o.b==b)
		return true;
		else
		return false; 
	
	}
	
}

class PassTest
{
		public static void main(String arg[])
		{
			Test m=new Test();
			Test n=new Test(2,2);
			Test l=new Test(67,88);
			
			System.out.println(" Result of test is "+l.boolTest(n));
				System.out.println(" Result of test is "+n.boolTest(m));
	
		}
}