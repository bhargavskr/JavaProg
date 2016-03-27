import java.io.*;
class ConsoleDemo
{

	public static void main(String arg[])
	{
		String str;
		Console con;
		con = System.console();
	 
		if(con==null)
			return;
		str=con.readLine(" Enter");
	 con.printf(str);
	
	}


}

