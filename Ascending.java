import java.io.*;
class Ascending
{           public static void main(String[] args)throws IOException 
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in)); 
		System.out.println("enter the number of strings");
		int n=Integer.parseInt(br.readLine());
		String s[]=new String[n];
		for(int i=0;i<n;i++)
		{          System.out.println("enter the string");
			s[i]=br.readLine();
                       }
		System.out.println("the strings in ascending order are");
		for(int i=0;i<n-1;i++)
		{          for(int j=0;j<(n-(i+1));j++)
			{
				if(s[j].compareTo(s[j+1])>0)
				{
					String s1=new String();
					s1=s[j];
					s[j]=s[j+1];
					s[j+1]=s1;
				}
			}
		}
		for(int i=0;i<n;i++)
			System.out.println(s[i]);
	}
}
