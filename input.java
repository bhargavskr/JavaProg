import java.io.*;
class rect
{
  int length;

  int breadth;
  void accept()throws IOException
{
  DataInputStream dis=new DataInputStream(System.in); 
  System.out.println(" enter length");
  length=Integer.parseInt(dis.readLine());
  System.out.println(" enter breadth");
  breadth=Integer.parseInt(dis.readLine());
}
  int area()
 {
    return length*breadth;
 }
}
class input
{
  public static void main(String arg[])throws IOException
  {
  rect r=new rect();
  int x;
  r.accept();
  x=r.area();
  System.out.println("area is "+x);
  }
} 