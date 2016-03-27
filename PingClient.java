import java.io.*;   
import java.net.*;   
import java.util.*;   

public class PingClient {   
   
    
  
    final static String CRLF = "\r\n";   
  public static void main(String[] args)throws Exception 
  { 
    long totalrtt = 0;
    long maxrtt = -9999;
    long minrtt = 9999;
    int drops = 0;   
   int sentSequence;
   int sendtimes=0;    
	int sequence=0;
			 byte[] sendData = new byte[1024]; 
			 byte[] receiveData = new byte[1024];	
//	 System.out.println("1");    
	if (args.length<2) { 
	// check if number of arguments are correct
      
	  System.out.println("Required arguments: host and port");   
      return;   
       }   
      String server = new String(args[0]);   // Read first argument from user 
      String serport =new String(args[1]);  // Read second argument from user
	  int serverPort = Integer.parseInt(serport);   
      InetAddress serverAddress = InetAddress.getByName(server);
	//  	 System.out.println("2");
	  DatagramSocket socket =new DatagramSocket(); 
      socket.setSoTimeout(1000);    
	Long time = new Long(System.currentTimeMillis());
      String payload ="PING " + sequence + "  " + time + CRLF; // Construct data payload for PING as per the instructions
      sendData = payload.getBytes(); // Convert payload into bytes
      DatagramPacket packet = new DatagramPacket(sendData,sendData.length,serverAddress,serverPort);    // Create new datagram packet
      socket.send(packet);
	  sendtimes++;
      	// System.out.println("3");
	  sentSequence=sequence;
     // DatagramPacket reply = new DatagramPacket(receiveData,receiveData.length);     
 
 
 while(true)
	{
      try{	
      	// System.out.println("4");
       
	   DatagramPacket reply = new DatagramPacket(receiveData,receiveData.length);   	
        socket.receive(reply);// wait for incoming packet reply
        byte[] buf = reply.getData();          
      //	 System.out.println("5");
     
	 ByteArrayInputStream bais = new ByteArrayInputStream(buf);   
        InputStreamReader isr = new InputStreamReader(bais);   
        BufferedReader br = new BufferedReader(isr);
        String line = br.readLine();   
        StringTokenizer tokens = new StringTokenizer(line);
        String pong=tokens.nextToken();
 		int sequence1= Integer.parseInt(tokens.nextToken());
	    long millitime= Long.parseLong(tokens.nextToken());
        long rtt =new Long(System.currentTimeMillis())-millitime; 		// calculate roundtrip time
        
		sentSequence++;
		      //	 System.out.println("6");

		if(sequence1==sentSequence)
	    {
     	      	// System.out.println("7");
         System.out.println("Received from " + reply.getAddress().getHostAddress() + " ," + new String(line)); 
          System.out.println();
        System.out.println(" Round Trip Time (RTT):"+rtt+"\n");
		sequence+=2;
		time = new Long(System.currentTimeMillis());		 
	    payload ="PING " + sequence + "  " + time + CRLF; // Construct data payload for PING as per the instructions
        sendData = payload.getBytes(); // Convert payload into bytes
        packet = new DatagramPacket(sendData,sendData.length,serverAddress,serverPort);    // Create new datagram packet
        socket.send(packet);
         sendtimes++;
		 sentSequence=sequence;		
          totalrtt+=rtt;
	     if(maxrtt<rtt)
           maxrtt=rtt;		  
		  if(minrtt>rtt)
		  minrtt=rtt;
		
		 if(sequence!=0&&sequence%20==0&&sequence!=1)
		 {
		System.out.println("Total number of times PING request is sent :"+sendtimes);
        long avgrtt = totalrtt/(sendtimes-drops);// calculate average rtt
   // System.out.println("Total RTT :"+totalrtt);
      System.out.println("Maximum RTT :"+maxrtt);
      System.out.println("Minimum RTT:" + minrtt);
	  System.out.println("Average RTT :"+avgrtt);
     System.out.println("Packet drops:" + drops);
    		 
		 }

		 
			//System.out.println("8");

	   }
       else
        {
		  //    	 System.out.println("9");

		 System.out.print("Received out of order packet: packet discarded");
		 System.out.println();
      	// System.out.println("10");
	
	}	   
		
	}   
   
     catch(SocketTimeoutException e) {
	      // 	 System.out.println("11");

          System.out.println(" \n Error: Request timed out: Request Sent Again\n");
               socket.send(packet);
			   sendtimes++;
			   drops++;
			         	// System.out.println("12");

			  }
   } 
 }  
}