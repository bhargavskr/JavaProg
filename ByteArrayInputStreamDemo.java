import java.io.*;

class ByteArrayInputStreamDemo
{
  public static void main(String arg[])
  {
	String tmp="abcdefghijklmonpqrstuvwxyz";
	byte b[]=tmp.getBytes();
	
	ByteArrayInputStream i1=new ByteArrayInputStream(b);
	ByteArrayInputStream i2=new ByteArrayInputStream(b,0,2);
	
	
	
  }

}