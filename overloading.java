class overload
{
  void show()
  {
    System.out.println(" no arguments ");
  }
  void show(int x)
  {
    System.out.println(" one arguments  ");
  }
  void show(int x,int y)
  {
    System.out.println(" 2 integers "+x+" "+y);
  }
  void show(double m)
  {
    System.out.println(" double value "+m);
  }
}
class overloading 
{
  public static void main(String arg[])
 {
   overload a=new overload();
   a.show();
   a.show(1);
   a.show(2,3);
   a.show(12.8);
}
} 
