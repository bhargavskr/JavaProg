import java.io.*;
class fact
{
  int n,facto;
  int calc(int n)
  {
    if(n==0||n==1)
    {
       facto=1;
    }
    else
    {
       facto=n*calc(n-1);
    }
  }
  void show()
  {
  System.out.println(" factorial is "+facto);
  } 
}
class recurfact
{
  public static void main(String arg[])throws IOException
  {
    fact a=new fact();
int x;
     DataInputStream dis=new DataInputStream(System.in); 
     System.out.println(" enter number");
     x=Integer.parseInt(dis.readLine());
     a.calc(x);
     a.show();
  }
}