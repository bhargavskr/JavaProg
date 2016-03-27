class Multiple 
{


	boolean isMultiple(long n,long m)
	{
		if(n%m==0)
		  return true;

		  return false;
		  
	
	}
	
	public static void main(String arg[])
	{
		Multiple a=new Multiple();	
	   System.out.println(a.isMultiple(12,3));
		
	}
	
}	