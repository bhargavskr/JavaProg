class fib
{
  int a,b,c,d,i;
  fib()
  {
      a=1;
      b=1;
  }
  void calcnon(int n)
  {
   if(n==1)
   {
     System.out.println(" fibonacci series "+a);
   }
   else if(n==2)
   {
     System.out.println(" fibonacci series "+a+b);  
   }
   else
   {
     System.out.println(" fibonacci series "+a+b); 
     for(i=1;i<=n-2;i++)
      {
          
          System.out.println(" fibonacci series "+c);
          c=a;
          a=b;
          c=a+b;
      }
   }
  }
   void calcrec(int n)
   {
     if(n==1)
     {
       System.out.println(" fibonacci series "+a);
     }
     else if(n==2)
     {
       System.out.println(" fibonacci series "+b);  
     }
     else
     {
     d=calcrec(n-1)+calcrec(n-2);
      System.out.println(" fibonacci series "+d); 
     }
   }
}
class fibonac
{
    public static void main(String arg[])
    {
      fib x=new fib();
      x.calc(4);
      x.calcrec(4);
    }
}