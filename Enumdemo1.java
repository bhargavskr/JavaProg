enum Letters
{
	x,y,z,o,p
}
class EnumDemo1
{
	public static void main(String arg[])
	{
			Letters a1;
			a1=Letters.x;
			System.out.println("Value of a1"+a1);
			switch(a1)
			{
					case x: 
					System.out.println(a1);
					break;
					default: 
					System.out.println("hello");
					
			}
					
					
					
					
	}
	
}