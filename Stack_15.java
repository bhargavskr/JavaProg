class Stack_15
{
	int a[]=new int[10];
	int tos;
	Stack_15()
	{
		tos=-1;
	}
	void push(int x)
	{
	
		if(tos==9)
		 System.out.println(" Stack is full ");
		else
		a[++tos]=x;
	}
	int pop()
	{
		if(tos<0)
		{
		System.out.println(" Understacked");
		return 0;
		}
		else
		return a[tos--];
	}
}
