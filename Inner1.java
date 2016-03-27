class Outer
{
	int x;
	Outer()
	{
	 x=87;
	 }
	 
	 void innerAccess()
	 {
		Inner b=new Inner();
		b.display();
	}
		class Inner{

		void display()
		{
			System.out.println("Value of x "+x);
			
		
		}
		
		}
		
}

class Inner1
{
	public static void main(String args[])
	{
		Outer a=new Outer();
		a.innerAccess();
	}
}
	