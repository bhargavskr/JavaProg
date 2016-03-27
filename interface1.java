interface draw
{
   final static double PI=3.14;
   double area(double d1,double d2);
}
class triangle implements draw
{
   public double area(double d1,double d2)
   {
     return d1*d2/2;
   }
}
class circle implements draw
{
   public double area(double d1,double d2)
   {
     return PI*d1*d1;
   }
}
class interface1
{
  public static void main(String arg[])
  {
     triangle t=new triangle();
     circle c=new circle();
     draw d;
     d=t;
     System.out.println(" area of triangle "+d.area(10,20));
     d=c;
     System.out.println(" area of circle "+d.area(20,29));
  }
} 