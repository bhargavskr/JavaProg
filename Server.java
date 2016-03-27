/*
 *
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sai
 */
import java.io.*;
import java.net.*;

public class Server {

public static void main(String arg[]) throws Exception
{
DatagramSocket serversocket= new DatagramSocket(9876);
byte[] senddata=new byte[1024];
byte[] receivedata=new byte[1024];
while(true)
{
System.out.println("1");
 DatagramPacket receivePacket=new DatagramPacket(receivedata,receivedata.length);
System.out.println("2");
 
 serversocket.receive(receivePacket);
System.out.println("3");
 String sentence=new String(receivePacket.getData());
System.out.println("4");
 InetAddress IPAddress=receivePacket.getAddress();
 System.out.println(IPAddress);
 int port=receivePacket.getPort();
System.out.println(port);
 String capitalizedSentence=sentence.toUpperCase();
System.out.println("6");
senddata=capitalizedSentence.getBytes();
System.out.println("7");
 DatagramPacket sendPacket=new DatagramPacket(senddata,senddata.length,IPAddress,port);
System.out.println("8");

 serversocket.send(sendPacket);



}
}
}
