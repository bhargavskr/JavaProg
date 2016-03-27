class draw
{
  double d1,d2;
  draw(double a,double b)
  {
    d1=a;
    d2=b;
  }
  double area()
  {
      System.out.println(" area is undefined ");
      return 0;
  }
}
class triangle extends draw
{
  triangle(double a,double b)
  {
    super(a,b);
  }
  double area()
  {
    System.out.println("  inside area of triangle");
    return d1*d2/2;
  }
}
class rectangle extends draw
{
  rectangle(double a,double b)
  {
    super(a,b);
  }
  double area()
  {
       System.out.println(" inside area of rectangle ");
       return d1*d2;
  }
}
class dynamic 
{
  public static void main(String arg[])
  {
    draw d=new draw(10,20);
    triangle t=new triangle(12,8);
    rectangle r=new rectangle(4,3);
    draw ref;
    ref=d;
    System.out.println(" area is"+ref.area());
    ref=t;
    System.out.println(" area is"+ref.area());
    ref=r;
    System.out.println(" area is "+ref.area());
  }

}  