import java.io.*;
class Breadline
{
  public static void main(String arg[])throws IOException
  {
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    String str=new String();
    System.out.println("enter lines of text ");
    System.out.println(" enter stop to quit ");
    do
    {
       str=br.readLine();
       System.out.println(str);
    }while(!str.equals("stop"));
   }
}  
   
