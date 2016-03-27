import java.io.*;   
import java.net.*;   
import java.util.*;   

public class PingClientbasic {   
  
    final static String CRLF = "\r\n";   
  public static void main(String[] args)throws Exception {   
    long array[]=new long[10];
    long totalrtt = 0;
    long maxrtt = -9999;
    long minrtt = 9999;
    int drops = 0;
    int retPacket;
	int sentSequence;
	int sendtimes=0;
	//int expectedSequnecenumber=1;
//System.out.println(args.length);
    if (args.length<2) { 
	// check if number of arguments are correct
      
	  System.out.println("Required arguments: host and port");   
      return;   
    }   
    String server = new String(args[0]);   // Read first argument from user 
    String serport =new String(args[1]);  // Read second argument from user
//    System.out.println(server);
//	System.out.println(serport);
	int serverPort = Integer.parseInt(serport);   
   // System.out.println(serverPort);
    DatagramSocket socket =new DatagramSocket(); // Create new datagram socket
    socket.setSoTimeout(1000); // Set socket timeout value. Read API for DatagramSocket to do this
//InetAddress IPAddress=InetAddress.getByName("localhost");
//System.out.println(IPAddress);
    InetAddress serverAddress = InetAddress.getByName(server);; //Convert server to InetAddress format; Check InetAddress API for this
    byte[] sendData = new byte[1024];   
    byte[] receiveData = new byte[1024];   
   // System.out.println(serverAddress);
	
    int sequence=0;
	 sentSequence=sequence;
      Long time = new Long(System.currentTimeMillis());
      String payload ="PING " + sequence + "  " + time + CRLF; // Construct data payload for PING as per the instructions
      sendData = payload.getBytes(); // Convert payload into bytes
      DatagramPacket packet = new DatagramPacket(sendData,sendData.length,serverAddress,serverPort);    // Create new datagram packet
      socket.send(packet); // send packet
     sendtimes++;
     ;; // Create datagram packet for reply
      while(true){
      try {
 DatagramPacket reply = new DatagramPacket(receiveData,receiveData.length);     
	 socket.receive(reply);// wait for incoming packet reply
        byte[] buf = reply.getData();          
        ByteArrayInputStream bais = new ByteArrayInputStream(buf);   
        InputStreamReader isr = new InputStreamReader(bais);   
        BufferedReader br = new BufferedReader(isr);
        String line = br.readLine();   
        StringTokenizer tokens = new StringTokenizer(line);
		//System.out.println(tokens.countTokens());
		String pong=tokens.nextToken();
        //System.out.println(ping); 		
		int sequence1= Integer.parseInt(tokens.nextToken());
	
	     long millitime= Long.parseLong(tokens.nextToken());
         //System.out.println(millitime);
		 // Parse incoming string "line"

	  // extract packet sequence number into the variable retPacket
        retPacket = sequence1;
        sentSequence++;
        if (retPacket != sentSequence) {   
          System.out.print("Received out of order packet");
         
             continue;				   
		}
	  else{
	    System.out.println("Received from " + reply.getAddress().getHostAddress() + " ," + new String(line)); 
          System.out.println();
          long rtt =new Long(System.currentTimeMillis())-millitime;   // calculate roundtrip time
          sequence+=2;
		  sentSequence=sequence;
		  //long rtt1 =new Long(System.currentTimeMillis())-time;		 
		 //System.out.println(rtt1);
		 System.out.println(" Round Trip Time (RTT):"+rtt+"\n");  
 time = new Long(System.currentTimeMillis());		 
	 payload ="PING " + sequence + "  " + time + CRLF; // Construct data payload for PING as per the instructions
      sendData = payload.getBytes(); // Convert payload into bytes
     packet = new DatagramPacket(sendData,sendData.length,serverAddress,serverPort);    // Create new datagram packet
       //System.out.println(3);
	  socket.send(packet); 
	  sendtimes++;
	  //continue;
	
	

		
		
		
		
		continue;
		}    //else    
      } //try
      catch(SocketTimeoutException e) {
        System.out.println(" \n Error: Request timed out: Request Sent Again\n");
		drops++;
		time = new Long(System.currentTimeMillis());		 
	 payload ="PING " + sequence + "  " + time + CRLF; // Construct data payload for PING as per the instructions
      sendData = payload.getBytes(); // Convert payload into bytes
     packet = new DatagramPacket(sendData,sendData.length,serverAddress,serverPort);
 //System.out.println(2);     
	 socket.send(packet);
sendtimes++;     
	 }
      
	  
     }//while
	
	// print and store average, max, min rtt and drops
  }    
}   