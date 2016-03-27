package MySample;
class Balance 
{
	String name;
	double bal;
	Balance(String s,double b)
	{
		name=s;
		bal=b;
		
	}
	void show()
	{
		if(bal<0)
			System.out.println("--->");
		System.out.println(name+" "+bal);
	}
}

class  AccountBalance
{
   public static void main(String arg[])
   {
		Balance a=new Balance("x",265672);
	 a.show();
	}
}