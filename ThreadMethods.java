class A extends Thread
{
   public void run()
   {
         for(int i=1;i<=5;i++)
         {
           if(i==1)
             yield();
            System.out.println("\t from Thread A :i="+i);
         }
         System.out.println(" exit from A");
   }
}
class B extends Thread
{
   public void run()
   {
         for(int j=1;j<=5;j++)
         {
           
            System.out.println("\t from Thread B :j="+j);
            if(j==3)
            stop();
         }
         System.out.println(" exit from b");
   }
}
class C extends Thread
{
   public void run()
   {
         for(int k=1;k<=5;k++)
         {
            System.out.println("\t from Thread C :k="+k);
            if(k==1)
                 try
                 {
                         sleep(1000);
                 }
                 catch(Exception e)
                 {
                 }
         }
         System.out.println(" exit from C");
   }
}
class ThreadMethods
{
   public static void main(String arg[])
   {
        System.out.println(" start Thread A");
        new A().start();
          System.out.println(" start Thread B");
        new B().start();
        System.out.println(" start Thread C");
        new C().start();
    }
}    