import java.io.*;
class fib  
{
  int d,a=1,b=1,c,i;
  void calc(int n)
  {
   if(n==1)
   {
     System.out.println(" fibonacci series "+a);
   }
   else if(n==2)
   {
     System.out.println(" fibonacci series \n"+a+" \n "+b);  
   }
   else
   {
     System.out.println(" fibonacci series  by non recursion \n"+a+" \n"+b); 
     for(i=1;i<=n-2;i++)
      {
          c=a+b;
          System.out.println(+c);
           a=b;
          b=c;
      }
   } 
 }
  int calcrec(int n)
   {
     if(n==1)
     {
       return 1;
     }
     else if(n==2)
     {
      return 1;
     }  
     else  
     {   

     d=calcrec(n-1)+calcrec(n-2);
     return d; 
     } 
  }
}
class fibonac1
{
    public static void main(String arg[])throws IOException
    {
      fib x=new fib();
       int y,i;
      DataInputStream dis=new DataInputStream(System.in); 
  System.out.println(" enter no of digits of fibonacci series");
  y=Integer.parseInt(dis.readLine());
      x.calc(y);
   System.out.println("fibonacci series by recursion ");
     for(i=1;i<=y;i++)
         System.out.println(+x.calcrec(i));
  }
}