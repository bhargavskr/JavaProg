class nesttry
{
   public static void main(String args[])
   {
       try
       {
          int a=args.length;
          int b=12/a;
          System.out.println("a = "+a);
          try
          {
             if(a==1)
                      a=a/(a-a);
             String s=args[4];
          }
          catch(ArrayIndexOutOfBoundsException e)
          {
              System.out.println("array index out of bounds :"+e);
          }
       }
       catch(ArithmeticException ae)
       {
           System.out.println("divide by 0:"+ae);
        }
    }
} 