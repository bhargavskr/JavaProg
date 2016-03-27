import java.io.*;
class pallindrome
{
  public static void main(String arg[])
  {
    String s=new String(arg[0]);
    int i,n;
    n=s.length();
    String str= new String();  
    for(i=n-1;i>=0;i--)
    {
       str=str+s.charAt(i);
    }
    if(str.equals(s))
    {
       System.out.println(" it is pallindrome "+s);
    }
    else
    {
       System.out.println(" it is not pallindrome "+s);
    }
   }
}     