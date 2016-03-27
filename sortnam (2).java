import java.lang.String;
class sortnam
{
  public static void main(String arg[]) 
  { 
    String s[]=new String[10];
    String temp;
    int i,j;
    for(i=0;i<4;i++)
    {
   
    s[i]=arg[i];
    System.out.println("s["+i+"] :"+s[i]);
    }
    for(i=0;i<4;i++)
    {
      for(j=i+1;j<4;j++)
      {
        if(s[j].compareTo(s[i])<0)
        {
          temp=s[i];
          s[i]=s[j];
          s[j]=temp;
        }
      }
    }
     for(i=0;i<4;i++)
     {
       System.out.println(" s["+i+"] :"+s[i]);
     }
 }
}