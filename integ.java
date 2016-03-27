import java.util.StringTokenizer;
class integ
{
  public static void main(String arg[])
  {
    int x=0,y,i=0;;
    StringTokenizer st=new StringTokenizer(arg[0],":");
    y=st.countTokens();
    int s[]=new int[y];
    while(st.hasMoreTokens())
    {
       s[i]=Integer.parseInt(st.nextToken());
       x=x+s[i];
       i++;
    }
    System.out.println("the integers are");
    for(int j=0;j<s.length;j++)
	{
	 System.out.println(s[j ]);
	}
    System.out.println("sum of digits:"+x+" \n number of digits "+y);
   }
}  