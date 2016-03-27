abstract class A
{
	abstract void callme();
	
	
	void callmetoo()
	{
		System.out.println("Concrete Method");
	}
	
}
class B extends A
{
 void callme()
	{
	System.out.println("B implementation");
	}
}
class AbstractDemo
{
	public static void main(String arg[])
	{
		A a;
		B b=new B();
		a=b;
		
		a.callmetoo();
		b.callmetoo();
		b.callme();
		System.out.println(a.toString());
		System.out.println(a);
	}
}
