package tcptest;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ServerSocket serverSocket = new ServerSocket(8832);
		while(true){
			Socket socket = serverSocket.accept();
			System.out.println("connected");
			InputStream is = socket.getInputStream();
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			int len=0;
			byte [] buffer = new byte[1024];
			while((len=is.read(buffer))!= -1){
				bos.write(buffer,0,len);
			}
			is.close();
			bos.flush();
			bos.close();
			String msg = bos.toString();
			System.out.println("client ip:"+socket.getInetAddress().getHostAddress());
			System.out.println("client port:"+socket.getPort());
			System.out.println("client info:"+msg);
		}
		
	}

}
