import java.util.StringTokenizer;
import java.lang.String;
import java.io.*;
class freqcount
{
   public static void main(String arg[])throws IOException
   {
     int count=0,y,i=0;
     String st=new String();
     DataInputStream di=new DataInputStream(System.in);
     System.out.println(" enter the sentence ");
     st=di.readLine();
     StringTokenizer s=new StringTokenizer(st);
     y=s.countTokens();
     String str[]=new String[y];
     while(s.hasMoreTokens())
     {
       
                
         str[i]=s.nextToken();
         i++;       
     }
     
     for(i=0;i<y;i++)
     {
       System.out.println(str[i]);
     }
     DataInputStream dis=new DataInputStream(System.in);
     System.out.println(" enter the word to be counted ");
     String x=new String();
     x=dis.readLine();
     for(i=0;i<y;i++)
     {
       if(x.equals(str[i]))
       {
         count++;
       }
     }
     System.out.println(" frequency of "+x+" is "+count);
  }
}                    






                     





        
          

            
                       





