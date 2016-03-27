class excep1
{
  public static void main(String arg[])
  {
       int a=10;
       int b=0;
       try
       {
         a=a/b;
         System.out.println(" this will not be printed ");
       }
       catch(ArithmeticException ae)
       {
           System.out.println(" division by 0 error change the value ");
       }
       System.out.println("quitting ");
  }
}