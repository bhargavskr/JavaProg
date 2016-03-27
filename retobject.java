class test
{
  int a;
  test(int i)
  {
    a=i;
  }
  test incr()
  {
      test temp=new test(a+10);
      return temp;
   }
}
class retobject
{
   public static void main(String arg[]) 
   {
     test ob1=new test(5);
     test ob2;
     ob2=ob1.incr();
     System.out.println(" ob1.a:"+ob1.a);
     System.out.println(" ob2.a:"+ob2.a);
   }
}