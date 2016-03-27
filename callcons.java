class A
{
   A()
   {
   System.out.println(" inside's A constructor ");
   }
}
class B extends A
{
   B()
   {
     System.out.println(" inside's B constructor");
   }
}
class C extends B
{
    C()
    {
     System.out.println(" inside's C constructor ");
    }
}
class callcons
{
  public static void main(String arg[])
  {
  C x=new C();
  }
}
