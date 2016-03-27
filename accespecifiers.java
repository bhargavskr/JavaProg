class access
{
  int x;
  private int y;
  public int z;
  void sety(int m)
  {
    y=m;
  }
  int gety()
  {
    return y;
  }
}
class accespecifiers
{
  public static void main(String arg[])
  {
    access a=new access();
    a.x=10;
    a.z=98;
    a.sety(10);
    System.out.println("y="+a.gety());
    System.out.println("z="+a.z);
    System.out.println("x="+a.x);
  }
}
  