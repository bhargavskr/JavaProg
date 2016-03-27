class BreakLoop4
{
	public static void main(String arg[])
	{	
		outer: 
			for(int i=0;i<3;i++)
			{
				System.out.println("Pass "+i+" ");
				for (int j=0;i<100;j++)
				{
					if(j==10)
					break outer;
					System.out.print(j+" ");
				}
				System.out.println("This will not print");
			}
			
			System.out.println("Loop Completes");
	}
}
				