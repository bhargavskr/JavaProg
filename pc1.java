class Q
{
   int n;
    boolean valueset=false;
    synchronized int get()
    {
         if(!valueset)
         {
             try
              {
                   wait();
              }
              catch(InterruptedException e)
              {
                  System.out.println(" interrupted exception caught ");
              }
          }
        System.out.println(" GOT:"+n);
        valueset=false;
        notify();
        return n;
      }
      synchronized void put(int n)
      {
             if(valueset)
             {
                try
                {
                    wait();
                }
                catch(InterruptedException e)
                {
                   System.out.println(" interruptedException caught ");
                }
             }
             this.n=n;
             valueset=true;
             System.out.println("PUT:"+n);
             notify();
        
      }
}
class producer implements Runnable
{
      Q q;
      producer(Q q)
      {
              this.q=q;
              new Thread(this,"producer").start();
      }
      public void run()
      {
        int i=0;
        while(true)
        {
             q.put(i++);
        }
      }
}
class consumer implements Runnable
{
  Q q;
  consumer(Q q)
  {
    this.q=q;
    new Thread(this,"consumer").start();
  }
  public void run()
  {
      while(true)
      {
           q.get();
      }
  }
}
class pc1
{
  public static void main(String arg[])
  {
       Q q=new Q();
       new producer(q);
       new consumer(q);
       System.out.println(" press control+c to stop " );
  }
}        