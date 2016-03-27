class NewThread3 extends Thread
{
    NewThread3(String threadname,ThreadGroup tgOb)
    {
           System.out.println(" new thread:"+this);
           start();
    }
    public void run()
    {
         try
         {
             for(int i=5;i>0;i--)
             {
                 System.out.println(" child thread :"+i);
                 Thread.sleep(500);
             }
         }
         catch(InterruptedException e)
         {
              System.out.println(" child interrupted ");
         }
         System.out.println(" exiting child thread ");
    }   
 }
class ThreadGroupDemo
{
    public static void main(String arg[])
    {
        ThreadGroup tg=new ThreadGroup("IT");
        NewThread3 ob1=new NewThread3("one",tg);
        NewThread3 ob2=new NewThread3("two",tg);
        tg.list();
    }
} 