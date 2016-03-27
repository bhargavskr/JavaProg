 class A
{
 final  void show()
  {
      System.out.println(" inside a");
  }
}
class B extends A
{
  void show(String s)
  {
    System.out.println(" inside b "+s);
  }
}
class fin
{
  public static void main(String arg[])
  {
    A x=new A();
    x.show();
    B y=new B();
    y.show("hi how r u");
  }
}  