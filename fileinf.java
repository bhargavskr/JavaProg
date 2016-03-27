import java.io.*;
import java.lang.String;
class fileinf
{
   public static void main(String arg[])throws IOException
   {
       String st=new String(arg[0]);
       int s,count=0;
       int word=0,line=1;
       FileInputStream fin=new FileInputStream(st);
       s=fin.read();
       while(s!=-1)
       {
         count++;
         if(((char)s)==' ' || ((char)s)=='\n')
         {
           word++;
         }
         if((char)s=='\n')
         {
            line++;
         }
         s=fin.read();
       }
       System.out.println(" no of characters in the file is "+count);
       System.out.println(" no of words "+word);
       System.out.println(" no of lines "+line); 
       fin.close();
   }
}
