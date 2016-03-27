 class FibonnaciSeries
{
   int f1=1, f2 = 1, f3;
   void generateSeries(int num)
   {
    System.out.println(“fib= ” + f2);

   for (int i = 1; i <= num; i++) 
   {
   System.out.println("fib(" + i + ") = " + f3);
  f1 = f2;
  f2 = f3;
  f3 = f1 + f2;
  }
}
class fib
{
public static void main(String args[]) 
{
System.out.println("*****Fibonnaci Series*****");
FibonnaciSeries fb = new FibonnaciSeries();
fb.generateSeries(10);
}

}