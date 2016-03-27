class Box
{
	double width;
	double height;
	double length;
	Box()
	{
		width=38;
		height=72;
		length=73;
	
	}
	Box(Box o)
	{
		width=o.width;
		height=o.height;
		length=o.length;
	
	
	}
	
	Box(double l)
	{
		width=l;
		length=l;
		height=l;
		
	}
	
	Box(double l,double w,double h)
	{
	width=l;
	height=w;
	length=h;
	
	}
	
	
	
	double volume()
	{
		double v=width*height*length;
		return v;
		//System.out.println(" Volume "+v);
	
		}		
	
	
	
	
}