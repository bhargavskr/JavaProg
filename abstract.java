abstract class draw
{
  double d1,d2;
  draw(double a,double b)
  {
        d1=a;
        d2=b;
  }
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
  draw d=new draw(8,8);
  rectangle r=new rectangle(2,3);
  triangle t=new triangle(23,3);
  draw ref;
  ref=r;
  System.out.println(" area is "+ref.area());
  ref=t;
  System.out.println(" area is "+ref.area());
  }
}