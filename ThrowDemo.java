class ThrowDemo
{
  static void throwfunction()
  {
      try
      { 
         throw new ArithmeticException();
      }
      catch(ArithmeticException ae)
      {
          System.out.println("caught inside throwfunction ");
          throw ae;//rethrow the exception
      }
  }
  public static void main(String arg[])
  {
       try
       {
          throwfunction();
       }
       catch(ArithmeticException ae)
       {
          System.out.println("recaught:"+ae);
       }
  }
}

