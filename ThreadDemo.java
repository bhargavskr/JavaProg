class NewThread implements Runnable
{
        Thread t;
        NewThread()
        {
           t=new Thread(this,"Demo Thread");
           System.out.println(" child thread "+t);
           t.start();
        }
        public void run()
        {
             try
             {
                    for(int i=5;i>0;i--)
                    {
                           System.out.println(" child thread "+i);
                            t.sleep(500);
                     }
             }
             catch(InterruptedException e)
             { 
                 System.out.println(" child interrupted ");
             }
              System.out.println(" exiting child thread ");
        }
}
class ThreadDemo 
{
   public static void main(String arg[])
   {
       new NewThread();
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
      System.out.println(" exiting main thread ");
   }
}               
  
  