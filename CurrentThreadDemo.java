class CurrentThreadDemo
{
   public static void main(String arg[])
   {
         Thread t=Thread.currentThread();
         System.out.println(" current thread :"+t);
         t.setName(" my thread ");
          System.out.println(" after name change :"+t);
         try
         {
             for(int n=5;n>0;n--)
             {
                   System.out.println(n);
                   t.sleep(1000);
             }
          }
          catch(InterruptedException e)
          {
             System.out.println(" main thread interrupted ");
          }
    }
}