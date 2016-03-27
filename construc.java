class rectangle
{
  int length;
  int breadth;
  rectangle()
  {
  length=10;
  breadth=20;
  }
  rectangle(int x,int y)
  {
     length=x;
     breadth=y;
  }
 rectangle(int x)
 {
   length=x;
   breadth=x;
 }
 rectangle(rectangle r)
{
  this.length=r.length;
  this.breadth=r.breadth;
}
  void area()
 {
  System.out.println(" area of rectangle "+length*breadth);
 }
}
class construc
{
  public static void main(String arg[])
  {
     rectangle i1=new rectangle();
     rectangle i2=new rectangle(10,20);
     rectangle i3=new rectangle(10);
     rectangle i4=new rectangle(i3);
     i1.area();
     i2.area();
     i3.area();
     i4.area();
  }
}