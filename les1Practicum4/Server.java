package les1Practicum4;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

class Server {
  public static void main(String[] arg) throws Exception {
    ServerSocket ss = new ServerSocket(4711);
    Socket s = ss.accept();
    InputStream is = s.getInputStream();
    OutputStream out = s.getOutputStream();
    String text = null;

    BufferedReader br = new BufferedReader(
      new InputStreamReader(is));

    while ((text = br.readLine()) != null) {
      if (!text.equals("")) {
        System.out.println(text);
      }else{
        break;
      }
    }
    String response="HTTP/1.1 200 OK\r\n";
    out.write(response.getBytes("UTF-8"));

    response="\r\n\r\n<html><h1>It works!</h1></html>\r\n\r\n";
    out.write(response.getBytes("UTF-8"));
    out.flush();

    
    is.close();
    s.close();
    ss.close();
  }
}
