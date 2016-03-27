class rect
{
  int length;
  int breadth;
  rect(int l,int b)
  {
    length=l;
    breadth=b;
  }
  int area()
  {
    return length*breadth;
  }
}
class passpara
{
  public static void main(String arg[])
  {
  rect r=new rect(10,20);
  int a;
  a=r.area();
  System.out.println(" area is "+a);
  }
}