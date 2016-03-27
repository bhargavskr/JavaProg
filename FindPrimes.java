class FindPrimes
{
	public static void main(String args[])
	{
		int num;
		boolean inPrime;
		num=14;
		if(num<2) inPrime=false;
		else inPrime=true;
		for(int i=2;i<=num/i;i++)
		{
			if((num%i)==0)
			{
				inPrime=false;
				break;
			}
		}
			
		if(inPrime) System.out.println("Prime");
		else System.out.println(" Not Prime");
	}
}
			