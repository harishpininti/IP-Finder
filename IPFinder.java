package socket;
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class IPFinder 
{
    public static void main(String [] args)
    {
    	
        try
        {  
        	// 1-----> The Host name and IP
            InetAddress address = InetAddress.getLocalHost();
            System.out.println("***************************************** ");
            System.out.println("The Host Name and IP is ");
            System.out.println(address.getHostAddress());
            System.out.println(address.getHostName());
            System.out.println("***************************************** ");
            //// 2-------> The Domain name and IP
            System.out.println("Enter the Domain Name to get the IP "); 
            Scanner sc = new Scanner(System.in);
            String val = sc.next();
            InetAddress address2 = InetAddress.getByName(val);
            System.out.println(address2.getHostAddress());
            System.out.println(address2.getHostName());
            System.out.println("***************************************** ");
            
            System.out.println("Pinging to the IP");
            // 3...calling the Ping Request  (Pinging The IP of value)
            sendPingRequest(val); 
            
            
            System.out.println("Calculating the PING  Execution Time");
            System.out.println("***************************************** ");
            // 4-----> Calculating Ping Execution Time
            long currentTime = System.currentTimeMillis();
            boolean isPinged = InetAddress.getByName(val).isReachable(2000); // 2 seconds
            currentTime = System.currentTimeMillis() - currentTime;
            if(isPinged) {
            	System.out.println("***************************************** ");
                System.out.println("pinged successfully in "+ currentTime+ "millisecond");
                System.out.println("***************************************** ");
            } else {
                System.out.println("Ping failed.");
                System.out.println("***************************************** ");
            }
            
            
        }
           
      
        catch(IOException e)
        {
            System.out.println(e.toString());
        }
        
        
    }
         // 3--------> Pinging The IP of value
	   private static void sendPingRequest(String val) throws IOException {
		System.out.println("Pinging the IP");
        InetAddress geek = InetAddress.getByName(val); 
        
        System.out.println("Sending Ping Request to " + val); 
        if (geek.isReachable(5000)) 
          System.out.println("Host is reachable " +val); 
        else
          System.out.println("Sorry ! We can't reach to this host"); 
		// TODO Auto-generated method stub
		
	}
}
