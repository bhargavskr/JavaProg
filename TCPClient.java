  import java.io.*;
import java.net.*;

public class TCPClient {

   
    public static void main(String[] args)throws Exception {


     String sentence;
	 String modifiedSentence;
 System.out.println("1");	
 BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
 System.out.println("2");
	 Socket clientSocket=new Socket("localhost",6789);
 System.out.println("3");
	 DataOutputStream outToServer=new DataOutputStream(clientSocket.getOutputStream());
 System.out.println("4");     
BufferedReader inFromServer=new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
System.out.println("5");
 	 sentence=inFromUser.readLine();
 System.out.println("6");	 
outToServer.writeBytes(sentence+'\n');
 System.out.println("7");	 
modifiedSentence=inFromServer.readLine();
 System.out.println(modifiedSentence);	 
System.out.println("From Server"+modifiedSentence);
 System.out.println("9");	
 clientSocket.close();
 System.out.println("10");
  }

}