class A
{
  int x=10;
  void display()
  {
     B b=new B(3);
     b.test();
     System.out.println(b.y);
  }
  class B
  {
      int y;
      B(int s)
      {
          y=s;
      }
      void test()
      {
         System.out.println(x);
      }
  }
}
class nonstaticnest
{
 public static void main(String arg[])
 {
   A a=new A();
   a.display();
  }
}