interface A
{
  void meth1();
  void meth2();
}
interface B extends A
{
  void meth3();
}
class myclass implements B
{
   public void meth1()
   {
      System.out.println(" implements meth1() ");
   }
   public void meth2()
   {
      System.out.println(" implements meth2() ");
   }
   public void meth3()
   {
      System.out.println(" implements meth3() ");
   }
}
class interface3
{
  public static void main(String arg[])
  {
    myclass ob=new myclass();
    ob.meth1();
    ob.meth2();
    ob.meth3();
  }
}