/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sai
 */
import java.io.*;
import java.net.*;

public class Client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception
    {
System.out.println("1");	
BufferedReader inFromUser=new BufferedReader(new InputStreamReader(System.in));
System.out.println("2");
DatagramSocket clientsocket=new DatagramSocket();
System.out.println("3");
InetAddress IPAddress=InetAddress.getByName("localhost");
System.out.println("4");
byte[] senddata=new byte[1024];
byte[] receivedata= new byte[1024];
String sentence=inFromUser.readLine();
System.out.println("5");
senddata=sentence.getBytes();
System.out.println("6");
DatagramPacket sendPacket=new DatagramPacket(senddata,senddata.length,IPAddress,9876);
System.out.println("7");
clientsocket.send(sendPacket);
System.out.println("8");
DatagramPacket receivePacket=new DatagramPacket(receivedata,receivedata.length);
System.out.println("9");
clientsocket.receive(receivePacket);
System.out.println("10");
String modifiedSentence= new String(receivePacket.getData());
System.out.println("modifiedSentence");
System.out.println("From Server:"+modifiedSentence);
clientsocket.close();
 









        // TODO code application logic here
    }

}
