class A
{
  int i;
}
class B extends A
{
 int i;
 B(int x,int y)
 {
   super.i=x;
   i=y;
 }
 void display()
 {
   System.out.println(" super i ="+super.i);
   System.out.println(" sub i="+i);
 }
}
class super2
{
  public static void main(String arg[])
  {
     B p=new B(10,29);
     p.display();
  }
}
  