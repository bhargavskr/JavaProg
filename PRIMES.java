class number
{
	int i=1,j,n,nof,nop=0;
	number()
	{
		n=20;
		j=1;
		nof=0;
	}
	void getData()
	{
		while(i<=n)
		{
			j=1;
			nof=0;
			while(j<=i)
			{
				if(i%j==0)
				nof++;
				j++;
			}
			if(nof==2)
			{
				System.out.println(i);
				nop++;
			}
			i++;
		}
		System.out.println("No. of Prime Numbers :"+nop);
	}
}
class primes
{
	public static void main(String str[])
	{
		number pr= new number();
		pr.getData();
	}
}