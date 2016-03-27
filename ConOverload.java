class ConOverload
{
	public static void main(String args[])
	{
		Box a=new Box();
		Box b=new Box(2);
		Box c=new Box(72,2,2);
		Box d=new Box(b);
		
		
		System.out.println(" Volume is "+a.volume());
		System.out.println(" Volume is "+b.volume());
		System.out.println(" Volume is "+c.volume());
		System.out.println(" Volume is "+d.volume());

	}
}