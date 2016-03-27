class StackDisplay
{
	public static void main(String args[])
	{
		Stack_15 a=new Stack_15();
		Stack_15 b=new Stack_15();
		
		for(int i=0;i<10;i++)
			a.push(i);
		for(int j=0;j<20;j++)
			b.push(j);
			
		for(int i=0;i<10;i++)		
		System.out.println(a.pop());
		
		for(int i=0;i<10;i++)		
		System.out.println(b.pop());
		
	}
}