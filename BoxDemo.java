class BoxDemo
{
	public static void main(String args[])
	{
		Box mybox=new Box();
		mybox.width=10;
		mybox.height=10;
		mybox.length=10;
		
		double volume=mybox.width*mybox.height*mybox.length;
		
		System.out.println(" Volume "+volume);
		
	}
}
		