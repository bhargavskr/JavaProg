class NewThread2 implements Runnable
{
       String name;
       Thread t;
       NewThread2(String threadname)
       {
           name=threadname;
           t=new Thread(this,name);
           System.out.println(" new thread "+t);
           t.start();
       }
       public void run()
       {
           try
           {
               for(int i=5;i>0;i--)
               {
                    System.out.println(name+"  "+i);
                    Thread.sleep(1000);
               }
           }
           catch(InterruptedException e)
           {
              System.out.println(" child interrupted ");
           }
           System.out.println(name+" exiting "); 
         }
 
}
class MultiThreadDemo
{
   public static void main(String arg[])
   {
      new NewThread2("one");
      new NewThread2("two");
      new NewThread2("three");
      System.out.println(" exiting main thread ");    
    }
}                   