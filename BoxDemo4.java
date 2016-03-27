class BoxDemo4
{

	public static void main(String arg[])
	{
	Box mybox1=new Box();
	Box mybox2=new Box();
	
	
	mybox1.width=10;
	mybox1.height=10;
	mybox1.length=10;
	
	mybox2.height=29;
	mybox2.width=82;
	mybox2.length=7;
	
	double v1=mybox1.volume();
	double v2=mybox2.volume();
	
	
	System.out.println(" 1st Volume "+v1);
	
	System.out.println(" 2nd Volume "+v2);
	}
}