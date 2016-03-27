import java.util.*;

class Even
{


	boolean isEven(int i)
	{	
		if((i & 1 )==0)
	     return true;
		 return false;
	}
	
	public static void main(String arg[])
	{
	
		Even a=new Even();
		Scanner in=new Scanner(System.in);
			System.out.println(a.isEven(in.nextInt()));
	
	
	}
	
}	



