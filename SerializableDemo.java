import java.io.*;
class MyClass implements Serializable
{
	String s;
	transient int i;
	double d;
	
public	MyClass(String s,int i, double d)
	{
		this.s=s;
		this.i=i;
		this.d=d;
	
	}
	
	public String toString()
	{
		return "s="+s+" i="+i+" d="+d;
	}
}
class SerializableDemo
{
	public static void main(String arg[])
	{
		try(ObjectOutputStream oo=new ObjectOutputStream(new FileOutputStream("serial")))
		{
			MyClass ob=new MyClass("d",2,2.2);
			System.out.println(ob);
			oo.writeObject(ob);
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		try(ObjectInputStream oi=new ObjectInputStream(new FileInputStream("serial")))
		{
			
			MyClass ob1=(MyClass)oi.readObject();
			System.out.println(ob1);
			
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}


