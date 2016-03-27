import java.io.*;
class Bread
{
  public static void main(String args[])throws IOException
  {
    char c;
    BufferedReader b=new BufferedReader(new InputStreamReader(System.in));
    System.out.println("enter characters, 'q' to qiut ");
do
{
   c=(char)b.read();
   System.out.println(c);
}while(c!='q');
}
}    