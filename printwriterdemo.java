import java.io.*;
public class printwriterdemo
{
public static void main(String arg[])
{
  PrintWriter pw=new PrintWriter(System.out,true);
  pw.println(" this is a string ");
  int i=-7;
  pw.println(i);
  double d=2782.27;
  pw.println(d);
 }
} 