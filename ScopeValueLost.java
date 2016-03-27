import java.io.*;
class ScopeValueLost
{
  public static void main(String args[])
 { 
int x=20;
int i;

for(i=0;i<3;i++)
{  
int y=0;   
   System.out.println(y);
//y=i;
  // System.out.println(y);
   y=100;
 System.out.println(y);
 }
//System.out.println(y);
} 
}   