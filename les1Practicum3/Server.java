package les1Practicum3;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

class Server {
  public static void main(String[] arg) throws Exception {
    ServerSocket ss = new ServerSocket(4711);
    Socket s = ss.accept();

    Scanner sc= new Scanner(s.getInputStream());
    while(sc.hasNextLine()) {
    	String c = sc.nextLine();
    	System.out.println(c);
    }
    sc.close();
    s.close();
    ss.close();
  }
}
