import java.io.*;
class fileread
{  
  public static void main(String arg[])throws IOException
  {
  String st=new String(arg[0]);
  int s,i=1; 
  FileInputStream fin=new FileInputStream(st);
  s=fin.read();
  
  System.out.print(i+++" ");
  while(s!=-1) 
  {
   
    System.out.print((char)s);
    if((char)s=='\n')
    System.out.print(i+++" ");
    s=fin.read();
  }
  
  fin.close();
 } 
} 