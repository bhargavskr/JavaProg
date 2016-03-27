class NewThread1 extends Thread
{
     NewThread1()
     {
        System.out.println(" child thread "+this);
        start();
     }
     public void run()
     {
       try
       {
          for(int i=5;i>0;i--)
          {
              System.out.println(" child thread "+i);
              sleep(500);
          }
       }
       catch(InterruptedException e)
       {
        System.out.println(" child interrupted ");
       }
       System.out.println("exiting from child ");
     }
}
class ExtendThread 
{
   public static void main(String arg[])
   {
       new NewThread1();
       try
       {
         for(int i=5;i>0;i--)
         {
           System.out.println(" main thread "+i); 
           Thread.sleep(1000);
         }  
       }
       catch(InterruptedException e) 
       {
            System.out.println(" main interrupted ");
       }
     System.out.println("exiting main thead");
  }
} 