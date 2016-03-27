class BoxDemo2
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
	
	double v1=mybox1.height*mybox1.length*mybox1.width;
	double v2=mybox2.length*mybox2.height*mybox2.width;
	
	
	System.out.println(" 1st Volume "+v1);
	
	System.out.println(" 2nd Volume "+v2);
	}
}