class A
{
  int i,j;
  A(int a,int b)
  {
     i=a;
     j=b;
  }
  void show()
  {
     System.out.println(" i and j "+i+" "+j);
  }
}
class B extends A
{
  int k;
  B(int a,int b,int c)
  {
    super(a, b);
    k=c;
  }
  void show()
  {
    System.out.println("k:"+k);
  }
}
class override
{
  public static void main(String arg[])
  {
  B x=new B(10,20,30);
  x.show();
  }
}