class Box extends Object
{
	private double width;
	private double height;
	private double depth;
		
	Box(Box ob)
	{
		width=ob.width;
		height=ob.height;
		depth=ob.depth;
	}
	Box(double w,double h,double d)
	{
		width=w;
		height=h;
		depth=d;
	}
	Box()
	{
		width=-1;
		height=-1;
		depth=-1;
	}
	Box(double len)
	{
		width=height=depth=len;
	}
	double volume()
	{
	   return width*height*depth;
	 
	 
	 
	 }
/*
	 String toString()
	{
		return "hi";
		
			
	}
	 */
	 }

class BoxWeight extends Box
{
	double weight;
	BoxWeight(double le)
	{
		super(le);
		weight=le;
	}
	BoxWeight(BoxWeight ob)
	{
	
		super(ob);
		weight=ob.weight;
	
	}
	 public String toString()
{
		return "hi";
		
			
	}
	
}


class DemoSuper
{
  public static void main(String arg[])
{
	BoxWeight a=new BoxWeight(82);
	BoxWeight b=a;
	System.out.println(" Volume of a"+a.volume());
	
	System.out.println(" Volume of b"+b.volume());

	System.out.println(a);
	System.out.println(a.hashCode());
	System.out.println(b.hashCode());

	} 
	


}