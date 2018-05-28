package les1Practicum5;

import java.net.ServerSocket;
import java.net.Socket;

class Server {
  public static void main(String[] arg) throws Exception {
    ServerSocket ss = new ServerSocket(4711);
    
    while(true) {
        Socket s = ss.accept();
        MyServlet NewServlet = new MyServlet(s);
        NewServlet.start();
    }

  }
}
