import java.io.*;
import java.net.*;
public class TCPServer {

    
    public static void main(String[] args) throws Exception {

        String clientSentence;
        System.out.println("1");
        String capitalizedSentence;
 System.out.println("2");
        ServerSocket welcomeSocket=new ServerSocket(6789);
 System.out.println("3");       
 while(true)
        {
 System.out.println("4");
        Socket connectionSocket=welcomeSocket.accept();
 System.out.println("5");        
BufferedReader inFromClient=new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
 System.out.println("6");    
    DataOutputStream outToClient=new DataOutputStream(connectionSocket.getOutputStream());
 System.out.println("7");    
    clientSentence=inFromClient.readLine();
 System.out.println("8");        
capitalizedSentence=clientSentence.toUpperCase();
 System.out.println(capitalizedSentence);
       
 outToClient.writeBytes(capitalizedSentence+'\n');
 System.out.println("10");
        }




    }

}
