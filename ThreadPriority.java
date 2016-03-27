class A extends Thread
{
  public void run()
  {
      for(int i=1;i<=5;i++)
      {
          System.out.println(" \t from thread A:i="+i);
      }
      System.out.println("exit from A");
   }
}
class B extends Thread
{
   public void run()
   {
          for(int j=1;j<=5;j++)
          {
              System.out.println(" \t from thread B :j="+j);
          }
          System.out.println(" exit from B ");
   }
}
class C extends Thread
{
   public void run()
   {
       for(int k=1;k<=5;k++)
       {
         System.out.println(" \t from thread C:k="+k);
       }
       System.out.println(" exit from C");
   }
}
class ThreadPriority
{
  public static void main(String arg[])
  {
      A a=new A();
      B b=new B();
      C c=new C();
      c.setPriority(Thread.MAX_PRIORITY);
      b.setPriority(Thread.NORM_PRIORITY);
      a.setPriority(Thread.MIN_PRIORITY);
      System.out.println(" start thread c");
      c.start();
      System.out.println(" start thread b");
      b.start();       
      System.out.println(" start thread a");
      a.start();
      System.out.println(" end of main thread ");
  }
}

 