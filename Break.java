class Break
{
	public static void main(String arg[])
	{
		boolean t=true;
		
		first: 
		{
			second:
			{
				third:
				{
					System.out.println("Before the break");
					if(t)
					break second;
					System.out.println(" This won't execute");
				}
				System.out.println(" This won't execute");
			}	
			System.out.println(" This is after second block");
		}
	}
}