import java.io.*;
import java.lang.Math;
class qua
{
  int a,b,c;   
  double n,m;
  qua(int x,int y,int z)
  {
     a=x;
     b=y;
     c=z;
  }
  void code()
  {
    int d;
    d=(b*b)-(4*a*c);
    if(d==0)
    {
      n=m=(-b/(2*a));
    }
    else if(d<0)
    {
      System.out.println(" roots are imaginary ");
    }
    else
    {
       n=((-b+Math.sqrt(d))/(2*a));
       m=((-b-Math.sqrt(d))/(2*a));
    }
  }
  void display()
  {
    System.out.println(" roots are "+n+m);
  }
}
class quadratic
{
  public static void main(String arg[])
  {
   qua a=new qua(1,5,6);
   a.code();
   a.display();
  }
}