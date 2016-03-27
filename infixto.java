import java.io.*;
import java.lang.*;
class stack
{
   int max=100;
   int temp,i,data,tope=-1;
   char a[]=new char[max];
   char top()
   {
     return(a[tope]);
   }
   void push(char e)
   {
     if(tope==max-1)
            System.out.println(" stack is full");
     else      
          a[++tope]=e;
     
   }
    char pop()
   {
    if(tope==-1)
           return '&';
    else
           return(a[tope--]);
       
   }
   /*public void display()
    {
      if(tope==-1)
      {
        System.out.println(" Stack is empty ");
      }
      else 
      {
       for(i=0;i<=tope;i++)
       {
         System.out.println(+a[i]);
       }  
      }
    }*/
    
} 
class code extends stack
{
   int p;
   char t;
   int j=0;
   char post[]=new char[max];
   char infix[]=new  char[max]; 
   int precedence(char c)
   {
     switch(c)
     {
        case '(':
        case ')':
                   p=0;
                   break;
        case '+':
        case '-':
                   p=1;
                   break;
        case '*':
        case '/': 
                   p=2;
                   break;
        default : 
                  p=-1;
                   break;
      }
      return p;    
  }
       
         
    void con()throws IOException
     {
         int i=0,j=0;
         String s=new String();
         System.out.println(" enter the infix expression ");
         DataInputStream dis=new DataInputStream(System.in);
         s=dis.readLine();
         infix=s.toCharArray();
push('#');
System.out.println(" infix expression \n ");
for(i=0;i<infix.length;i++)
System.out.print(infix[i]);
         for(i=0;i<infix.length;i++)
         {
             
              t=infix[i];
                         
                switch(t)
                 {
                      case '(':push(t); 
                               break;
                      case '+':
                      case '-': 
                      case '*':
                      case '/':
                               while(precedence(t)<=precedence(top()))
                               post[j++]=pop(); 
                               push(t);
                               break; 
                      case ')':  while(top()!='(')                               
                                     post[j++]=pop();
                               

                       default:post[j++]=t;
                   }

          }        
                        
      while(top()!='#')
               post[j++]=pop();
       
        System.out.println("  \n postfix expression \n ");   
       for(i=0;i<j;i++)
       {
       System.out.print(post[i]);
       }
   
   }
   
}
class infixto
{
   public static void main(String arg[])throws IOException
   {
     code g=new code();
     g.con();
    
   }
}   
 
     
      
     
        
      
        
       
      
       
           