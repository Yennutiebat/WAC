package les1Practicum6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.Socket;

public class MyServlet extends Thread {
	private Socket socket = null;

	public MyServlet(Socket sock) {
		socket = sock;
	}

	public void run() {
		InputStream is = null;
		try {
			is = socket.getInputStream();
		} catch (IOException e) {
			e.printStackTrace();
		}
		OutputStream out = null;
		try {
			out = socket.getOutputStream();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String line = null;

		BufferedReader br = new BufferedReader(new InputStreamReader(is));

		try {
			while ((line = br.readLine()) != null) {
				if (!line.equals("")) {
					System.out.println(line);
				} else {
					break;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		String response = "HTTP/1.1 200 OK\r\n";
		try {
			out.write(response.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		response = "\r\n\r\n<html><h1>It works!</h1></html>\r\n\r\n";
		try {
			out.write(response.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			is.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
