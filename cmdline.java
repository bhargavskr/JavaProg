import java.io.*;

class cmdline
{  
   public static void main(String arg[])
   {  
     int n=arg.length;
      int i=0;
      while(i<=n)
      {
         try
         {
         System.out.println(i+" argument:"+arg[i]);
         i++;
         }
         catch(ArrayIndexOutOfBoundsException j)
         {
         }
       }
     
   }
}