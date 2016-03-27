class RecTest
{

	int val[];
	RecTest(int i)
	{
		val=new int[i];
		
	}
	
	
	void printarry(int n)
	{
		if(n==0) 
		return;
		//else 
		printarry(n-1);
		System.out.println("val["+(n-1)+"]"+val[n-1]);
	}
}
class Recursion2
{
	public static void main(String arg[])
	{
		RecTest m=new RecTest(10);
		
		for(int i=0;i<10;i++)
		m.val[i]=i;
		
		m.printarry(10);
		
		

	}

}
