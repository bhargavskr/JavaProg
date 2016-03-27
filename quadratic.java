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
System.out.println(" roots are "+n+" "+m);
  
    }
    else if(d<0)
    {
      System.out.println(" no real solution roots are imaginary ");
    }
    else
    {
       n=((-b+Math.sqrt(d))/(2*a));
       m=((-b-Math.sqrt(d))/(2*a));
System.out.println(" roots are "+n+" "+m);
  
    }
  }
 
  
    
}
class Quadratic
{
  public static void main(String args[])
  {
    int a=Integer.parseInt(args[0]);
    int b=Integer.parseInt(args[1]);
    int c=Integer.parseInt(args[2]);
   qua z=new qua(a,b,c);
   z.code();
   
  }

}