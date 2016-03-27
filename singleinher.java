class rect
{
  int length,breadth;
  rect()
  {
     length=-1;
     breadth=-1;
  }
  rect(int a,int b)
  {
   length=a;
   breadth=b;
  }
  rect(rect m)
  {
    length=m.length;
    breadth=m.breadth;
  }
  void area()
  {
    System.out.println(" area :"+length*breadth);
  } 
}
class box extends rect
{
  int heigth;
  box(int x,int y,int z)
  { 
   length=x;
   breadth=y;
   heigth=z;
  }
  void volume()
 {
    System.out.println(" volume :"+length*breadth*heigth);
 } 
}
class singleinher
{
  public static void main(String arg[])
  {
  rect m=new rect(10,29);
  rect n=new rect(m);
  m.area();
  n.area();
  box l=new box(10,2,20);
  l.volume();
  l.area();
  }
}  