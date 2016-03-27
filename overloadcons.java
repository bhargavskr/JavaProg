class box
{
  double width;
  double height;
  double breadth;
  box()
  {
    width=10;
    height=38;
    breadth=22;
  }
  box(double a,double b,double c)
  {
    width=a;
    height=b;
    breadth=c;
  }
  box(double j)
  {
   width=height=breadth=j;
  }
  double show()
  {
    return width*breadth*height;
  }
}
class overloadcons
{
    public static void main(String arg[])
    {
    box b1=new box();
    box b2=new box(10,20,30);
    box b3=new box(33);
    System.out.println(" volume is "+b1.show());
    System.out.println(" volume is "+b2.show());
    System.out.println(" volume is "+b3.show());
    }
}
