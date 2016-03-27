import java.io.*;
class String_insert
{
  public static void main(String args[])
 {
           String str="23 34 54";
           String str1="26";      
           String str2;
		   str2= new StringBuffer(str).insert(str.length()-str1.length(),str1+" ").toString();
		   System.out.println(str2);
		   
		   
		   
 
 }
}