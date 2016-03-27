class A
{
  int x=10;
  void display()
  {
    B b=new B(43);
    b.test();
    System.out.println("outer class "+b.y);
  }
  static class B
  {
    int y;
    B(int s)
    {
      y=s;
    }
    void test()  
    {
      A a=new A();
      System.out.println("inner class "+a.x);
    }
 }
}
class staticnested
{
   public static void main(String arg[])
   {
      A a=new A();
      a.display();
   }
}