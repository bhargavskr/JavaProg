final class A
{
  void show()
  {
    System.out.println(" inside a");
  }
}
class B 
{
  void show()
  {
    System.out.println(" inside b ");
  }
}
class finalkeyword
{
 public static void main(String arg[])
 {
  A x=new A();
  B y=new B();
 x.show();
 y.show();
 }
} 