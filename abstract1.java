abstract class draw
{
  double d1,d2;
  abstract double area();
}
class triangle extends draw
{
  triangle(double a,double b)
  {
   d1=a;
   d2=b;
  }
  double area()
  {
      System.out.println(" area inside triangle");
      return d1*d2/2;
  }
}
class rectangle extends draw
{
  rectangle(double a,double b)
  {
    d1=a;
    d2=b;
  }
  double area()
  {
   System.out.println(" inside rectangle area ");
   return d1*d2;
  }
}
class abstract1
{ 
  public static void main(String arg[])
  {
  rectangle r=new rectangle(2,3);
  triangle t=new triangle(23,3);
   System.out.println(" area is "+r.area());
  System.out.println(" area is "+t.area());
  }
}