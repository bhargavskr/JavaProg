import java.io.*;
interface sta
{  
   final int MAX=100;
   void push(int data); 
   void pop();
   void display();
}
class inf implements sta
{ 
   int top,temp,i;
   int a[]=new int[MAX];
   inf()
   {
     top=-1;
   }
   public void push(int data)
   {
       if(top==MAX-1)
       {
          System.out.println(" \t\t stack is full ");
       }
       else
       {
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
       for(i=top;i>=0;i--)
       {
         System.out.println(+a[i]);
       }  
      }
    }
}
class stackr
{
  public static void main(String arg[])throws IOException
  {
     inf a=new inf();
     int ch,data;
     do
     {
     System.out.println(" enter your choice ");
     System.out.println(" 1.push 2.pop 3.display 4.exit");
     DataInputStream dis=new DataInputStream(System.in);
     ch=Integer.parseInt(dis.readLine());
     switch(ch)
     {
     case 1:
            System.out.println(" enter the value ");
            data=Integer.parseInt(dis.readLine());
            a.push(data);
            break;
     case 2:
  
               a.pop();
              break;
     case 3:
    
                a.display();
               break;
      }
     }while(ch!=4);
  }
}   
                                                                                       
                        
                






























