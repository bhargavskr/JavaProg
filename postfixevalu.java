import java.io.*;
import java.lang.*;
class eval
{
   int i,j,top,max=100,val;
   char suf[]=new char[max];
   double s[]=new double[max];
   double op1,op2,temp,res;
   char ch;
   eval()
   {
     i=0;
     j=0;
     top=-1;
   }
   double pop()
   {
     return(s[top--]);
   }
   void push(double val)
   {
        top++;
        s[top]=val;
   }
}
class code extends eval
{
  double operate(double op1,double op2,char ch)
  {
    switch(ch)
    {
      case '+':temp=op1+op2;
               break;
      case '-':temp=op1-op2;
                break;
      case '*':temp=op1*op2;
                break;
      case '/':temp=op1/op2;
                break;
    }
    return(temp);
  }
   void calc()throws IOException
   {
   
        String s=new String();
        DataInputStream dis=new DataInputStream(System.in);
        System.out.println("enter the postfix expression");
        s=dis.readLine();
        suf=s.toCharArray();
        while(i<suf.length)
        {
          ch=suf[i];
          
          
         
            if(ch=='*'||ch=='/'||ch=='+'||ch=='-'||ch=='^')
            {
              op2=pop();
              op1=pop();
              res=operate(op1,op2,ch);
              push(res);
            }
	    else
            {
              DataInputStream di=new DataInputStream(System.in);
             System.out.println("enter value " );
             val=Integer.parseInt(di.readLine()); 
             push(val);
           }
           
           i=i+1;
         }
          temp=pop();
          System.out.println("the answer for given expression is");
          System.out.println(+temp);
   }
}
class postfixevalu
{
     public static void main(String arg[])throws IOException
     {
       code a=new code();
       a.calc();
     }
}
