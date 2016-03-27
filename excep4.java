public class excep4
{
  public static void main(String arg[])
  {
       try
       {
            int n=arg.length;
            int x[]=new int[-3];
            if(n>0)
            {
               int m=Integer.parseInt(arg[0]);
               System.out.println("given number is :"+m/(m-n));
             }
       }
       catch(NumberFormatException nfe)
       {
          System.out.println(" number format exception "+nfe);
       }
       catch(ArrayIndexOutOfBoundsException ai)
       {
          System.out.println(" array index out of range ");
       }
       catch(ArithmeticException ae)
       {
           System.out.println(" divide by 0 error");
       }
       catch(NegativeArraySizeException nase)
       {
           System.out.println("negative size .......");
       }
   }
}