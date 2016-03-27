import  java.io.*;
class Scope
{

 public static void main(String args[])
 {
     int x=10;
   if(x==10)
   {
     int y=20;   
     System.out.println("x and y are " +x+ " and "+y);
     x=y*20;   }

//   y=90;
   System.out.println(" x is "+x);
 }
}