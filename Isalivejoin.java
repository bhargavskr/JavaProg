class NewThread4 implements Runnable
{
    String name;
    Thread t;
    NewThread4(String threadname)
    {
          name=threadname;
          t=new Thread(this,name);
          System.out.println("new thread :"+t); 
          t.start();
    }
    public void run()
    {
        try
        {
               for(int i=5;i>0;i--)
               {
                  System.out.println(name+":"+i);
                  Thread.sleep(1000);
               }
        }
        catch(InterruptedException e)
        {
           System.out.println(name+"interrupted");
        }
        System.out.println(name+"exiting");
    }
}
class Isalivejoin
{
   public static void main(String arg[])
   {
       NewThread4 ob1=new NewThread4("one");
       NewThread4 ob2=new NewThread4("two");
       NewThread4 ob3=new NewThread4("three");
       System.out.println(" thread one is alive:"+ob1.t.isAlive()); 
       System.out.println(" thread two is alive:"+ob2.t.isAlive());
       System.out.println(" thread three is alive:"+ob3.t.isAlive());
       try
       {
             System.out.println(" waiting for threads to finish ");
              ob1.t.join();
              ob2.t.join();
              ob3.t.join();
       }
       catch(InterruptedException e)
       {
          System.out.println(" main thread interrupted ");
       }
       System.out.println(" thread one is alive:"+ob1.t.isAlive()); 
       System.out.println(" thread two is alive:"+ob2.t.isAlive());
       System.out.println(" thread three is alive:"+ob3.t.isAlive());
       System.out.println(" main thread exiting ");
    }
}