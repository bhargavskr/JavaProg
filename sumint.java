import java.io.*;
class integer
{
  int n,a,b=0;
  void getdata()throws IOException
  { 
     DataInputStream dis=new DataInputStream(System.in); 
     System.out.println(" enter any value");
     n=Integer.parseInt(dis.readLine());
  }
  void calc()
  {
   while(n>0)
   {
   a=n%10;
   b=b+a;
   n=n/10;
   }
  }
  void display()
  {
    System.out.println(" sum of integers :"+b);
  }
}

class sumint
{
  public static void main(String arg[])throws java.io.IOException     
  {
    integer x=new integer();
    x.getdata();
    x.calc();
    x.display();
  }
}
   
     