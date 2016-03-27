import java.io.*;
import java.net.*;
import java.util.*;

/*
 * Server to process ping requests over UDP.
 */
public class PingServer1
{
   final static String CRLF = "\r\n";
   private static final double LOSS_RATE = 0.3;
   private static final int AVERAGE_DELAY = 100;  // milliseconds

   public static void main(String[] args) throws Exception
   {
//System.out.println("1");
   //System.out.println("2");
      // Get command line argument.
      if (args.length != 1) {
         System.out.println("Required arguments: port");
         return;
      }
	  //System.out.println("3");
      int port = Integer.parseInt(args[0]);

     

      DatagramSocket socket = new DatagramSocket(port);
//System.out.println("4");
	  while (true) 
		{
	//	System.out.println("5");
				DatagramPacket request = new DatagramPacket(new byte[1024], 1024);
                socket.receive(request);
				RequestProcess RP=new RequestProcess(socket,request);
				Thread thread = new Thread(RP);
				thread.start();
	//	System.out.println("6");
		}
		
	  
	  
	  
	}  
}	
	  
	final class RequestProcess implements Runnable
    {	
	  DatagramSocket socket;
	  DatagramPacket request;
       final static String CRLF = "\r\n";
   private static final double LOSS_RATE = 0.3;
   private static final int AVERAGE_DELAY = 100;  // milliseconds
       Random random = new Random();
	  RequestProcess(DatagramSocket socket,DatagramPacket request)
	  {
	    this.socket=socket;
	    this.request=request;
	  }
	  public void run() 
	  {
	    try
	    {
	//	System.out.println("7");
          process();
		// System.out.println("17"); 
        }
		catch(Exception e)
		{
		System.out.println(e);
		}
	 }
	 
	 private void process() throws Exception
	 {
	 
	//System.out.println("8");
       
		 byte[] buf = request.getData();          
        ByteArrayInputStream bais = new ByteArrayInputStream(buf);   
        InputStreamReader isr = new InputStreamReader(bais);   
        BufferedReader br = new BufferedReader(isr);
        String line = br.readLine();   
        StringTokenizer tokens = new StringTokenizer(line);
		String ping=tokens.nextToken();
        int sequence= Integer.parseInt(tokens.nextToken());
		long time= Long.parseLong(tokens.nextToken()); 
//System.out.println("9");		 
		 printData(request);
//System.out.println("13");	
	sequence+=1;
	     String payload ="PONG " + sequence + "  " + time + CRLF; // Construct data payload for PING as per the instructions
         byte[] sendData = payload.getBytes();
	   

         // Decide whether to reply, or simulate packet loss.
         if (random.nextDouble() < LOSS_RATE) {
     
	 System.out.println("   Reply not sent.");
//System.out.println("14");            
         }
         else{
	//	 System.out.println("15");
         // Simulate network delay.
         Thread.sleep((int) (random.nextDouble() * 2 * AVERAGE_DELAY));

         InetAddress clientHost = request.getAddress();
         int clientPort = request.getPort();
     
         DatagramPacket reply = new DatagramPacket(sendData, sendData.length, clientHost, clientPort);
         socket.send(reply);
  //    System.out.println("16");
         }
	  
	 }
	 
	 
   private static void printData(DatagramPacket request) throws Exception
   {
   //System.out.println("10");
      // Obtain references to the packet's array of bytes.
      byte[] buf = request.getData();

      // Wrap the bytes in a byte array input stream,
      // so that you can read the data as a stream of bytes.
      ByteArrayInputStream bais = new ByteArrayInputStream(buf);

      // Wrap the byte array output stream in an input stream reader,
      // so you can read the data as a stream of characters.
      InputStreamReader isr = new InputStreamReader(bais);
//System.out.println("11");
      // Wrap the input stream reader in a bufferred reader,
      // so you can read the character data a line at a time.
      // (A line is a sequence of chars terminated by any combination of \r and \n.)
      BufferedReader br = new BufferedReader(isr);

      // The message data is contained in a single line, so read this line.
      String line = br.readLine();
      
      // Print host address and data received from it.
      System.out.println("Received from " + request.getAddress().getHostAddress() + ": " + new String(line) );
//System.out.println("12");  
  }
}