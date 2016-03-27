import java.io.*;
interface sta
{  
   final int MAX=100; 
   void push();
   void pop();
   void display();
}
class inf implements sta
{ 
   int top,temp,data,i;
   int a[]=new int[MAX];
   inf()
   {
     top=-1;
   }
   public void push()throws IOException
   {
       if(top==MAX-1)
       {
          System.out.println(" \t\t stack is full ");
       }
       else
       {
           
          DataInputStream dis=new DataInputStream(System.in);
          System.out.println(" \t\t enter the value ");
          data=Integer.parseInt(dis.readLine()); 
          top++;
          a[top]=data;
        }
    }
    public void pop()
    {
       if(top==-1)
       {
         System.out.println(" stack is empty");
       }
       else 
       {
          temp=a[top];
          System.out.println(" deleted element "+temp);
          top--;
       }
   }
    public void display()
    {
      if(top==-1)
      {
        System.out.println(" Stack is empty ");
      }
      else 
      {
       for(i=0;i<=top;i++)
       {
         System.out.println(+a[i]);
       }  
      }
    }
}
class stack
{
  public static void main(String arg[])throws IOException
  {
     inf a=new inf();
     a.push();
     a.pop();
     a.display();
  }
}   
                                                                                       
                        
                






























