import java.io.*;
class DataIODemo
{
  public static void main(String arg[])
  {
  
      try(DataOutputStream d=new DataOutputStream(new FileOutputStream("f1.txt")))
	  {
				
			d.writeDouble(32.44);
			d.writeInt(33);
			d.writeBoolean(true);	
				
					
	
	  }	
	  catch(Exception e)
	  {
			System.out.println(e);
	  }
	  try(DataInputStream di=new DataInputStream(new FileInputStream("f1.txt")))
	  {
				
			System.out.println(di.readDouble()+ " " + di.readInt()+" "+di.readBoolean());	
				
				
  
	  }	
	  catch(Exception e)
	  {
			System.out.println(e);
	  }
	  
	  
  }
  

}