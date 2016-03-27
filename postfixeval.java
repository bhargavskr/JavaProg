
import java.lang.*;
import java.io.*;
import java.util.*;

class postfixeval

{
   static int dooperation(int fo,int so,char op)
   {

       int val=0;
       switch(op)
       {
            case '+' : val=fo+so;
                       break;
            case '-' : val=fo-so;
                       break;
            case '*' : val=fo*so;
                       break;
            case '/' : val=fo/so;
                       break;
       }
   return val;
   }
   public static void main(String arg[])throws IOException
   {
     Stack stk=new Stack();
     DataInputStream dis=new DataInputStream(System.in);
     String str=dis.readLine();
     char ch;
     for(int pos=0;pos<str.length();pos++)
     {
        ch=str.charAt(pos);
        switch(ch)
        {
          case '0' :
          case '1' :
          case '2' :
          case '3' :
          case '4' :
          case '5' :
          case '6' :
          case '7' :
          case '8' :
          case '9' :
          stk.push(new Integer((Character.digit(ch,10))));
          break;
          case '+':
          case '-':
          case '/':
          case '*':
          int fo=((Integer)stk.pop()).intValue();
          int so=((Integer)stk.pop()).intValue();
          int result=dooperation(fo,so,ch);
          stk.push(new Integer(result));
          break;
         }

      }
      System.out.println("result is" +stk.pop());
   }
}</str.length();pos++)
 
