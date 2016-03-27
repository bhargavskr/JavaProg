class BoxDemo5
{
	public static void main(String args[])
	{
		Box a=new Box();
		Box b=new Box();
		
		
		a.setDim(1922,33,33);
		b.setDim(2,44,44);
		
		System.out.println(" Volume "+a.volume());
		System.out.println(" Volume "+b.volume());
		
	}
}