import java.lang.String;
import java.io.*;
class sortnam2
{
  public static void main(String arg[])throws IOException
  { 
    int i,j;
    String temp;
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in)); 
		System.out.println("enter the number of strings");
		int n=Integer.parseInt(br.readLine());
		String s[]=new String[n];
		for(i=0;i<n;i++)
		{        
                        System.out.println("enter the string");
			s[i]=br.readLine();
                }
    for(i=0;i<n;i++)
    {
      for(j=i+1;j<n;j++)
      {
        if(s[j].compareTo(s[i])<0)
        {
          temp=s[i];
          s[i]=s[j];
          s[j]=temp;
        }
      }
    }
       System.out.println(" strings in sorted order ");
     for(i=0;i<n;i++)
     {
       System.out.println(s[i]);
     }
 }
}