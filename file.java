import java.io.*;
class file1
{
  public static void main(String arg[])
  { 
    String st=new String(arg[0]);
     file f=new file(st);
    if(f.exists())
    {
      System.out.println(" file exists ");
    }
    else
    {
      System.out.println(" file does not exist ");
    }
    if(f.canRead())
    {
         System.out.println(" readable file");
    }
    else
    {
         System.out.println(" file is not readable ");
    }
    if(f.canWrite())
    {
         System.out.println(" writable file ");
    }
    else 
    {
         System.out.println(" not a writable file "); 
    }
    if(f.isFile())
    {
          System.out.println(" it is a file ");
    }
    else if(f.isdirectory())
    {
          System.out.println(" it is directory ");
    }
    System.out.println(" size of file is  "+f.length());
   }  
}    
      