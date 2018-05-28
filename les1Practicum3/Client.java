package les1Practicum3;

import java.net.Socket;
import java.util.Scanner;
import java.io.PrintWriter;

class Client {
  public static void main(String[] arg) throws Exception {
    Socket s = new Socket("localhost", 4711);
    Scanner sc = new Scanner(System.in);
    PrintWriter writer = new PrintWriter(s.getOutputStream());
    System.out.println("client is aan");
    
    while(true){
		System.out.println("Voer een bericht in: ");
		String result = sc.nextLine();
		
		if(result.equals("stop")){
			break;
		}
		writer.write(result);
	}
	writer.flush();
	s.close();
	sc.close();
}
}
