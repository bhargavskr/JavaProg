import java.io.*;
class Showfile 
{
   public static void main(String arg[])throws IOException
   {
     int i;
     try
     {
     FileInputStream fin=new FileInputStream(arg[0]);
     }
     catch(FileNotFoundException e)
     {
        System.out.println(" file not found ");
     }
     do
     {
     i=fin.read();
     if(i!=-1)
     System.out.println((char)i);
      }while(i!=-1);
     fin.close();
   }
}  
       