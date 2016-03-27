abstract class SHape
{
	abstract void noofsize();
}
class Triangle extends SHape
{
	void noofsize()
	{
		System.out.println("The sides of triangle is 3");
	}
}
class Trapezoid extends SHape
{
	void noofsize()
	{
		System.out.println("The sides of trapezoid is 4");
	}
}
class Hexagon extends SHape
{
	void noofsize()
	{
		System.out.println("The sides of hexagon is 6");
	}
}
class Sha1 
{
	public static void main(String[] args) 
	{
		Triangle t=new Triangle();
		Trapezoid u=new Trapezoid();
		Hexagon v=new Hexagon();
		t.noofsize();
		u.noofsize();
		v.noofsize();
	}
}