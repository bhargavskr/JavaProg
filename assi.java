class rect
{
  int length;
  int breadth;
  void area()
  {
    System.out.println(" area is"+length*breadth);
  }
   
}
class assi
{
  public static void main(String arg[])
  {
    rect r=new rect();
    r.length=100;
    r.breadth=200;
    r.area();
    rect f=r;
    f.length=20;
    f.area();
  }
}