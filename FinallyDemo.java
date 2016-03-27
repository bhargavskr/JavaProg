class FinallyDemo
{
   static void procA()
   {
        try
        {
             System.out.println("inside procA ");
             throw new RuntimeException("demo");
        }
        finally
        {
            System.out.println("procA's finally ");
        }
   }
   static void procB()
   {
        try
        {
            System.out.println("inside procB");
            return;
        }
        finally
        {
           System.out.println(" inside finally ");
        }
    }
    static void procC()
    {
       try
       {
           System.out.println("inside procC");
       }
       finally
       {
           System.out.println(" procC's finally ");
       }
    }
    public static void main(String arg[])
    {
      try
      {
        procA();
      }
      catch(Exception e)
      {
            System.out.println("exception caught");
      }
        procB();
        procC();
     }
}