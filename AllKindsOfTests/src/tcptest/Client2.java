package tcptest;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client2 {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws UnknownHostException 
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws UnknownHostException, IOException, InterruptedException {
		for(int i =1; i<20;i++){
			Socket socket1= new Socket("127.0.0.1",8832);
			OutputStream os = socket1.getOutputStream();
			String msg = "higher salary!!";
			Thread.sleep(1000);
			os.write(msg.getBytes());
			os.flush();
			os.close();
			socket1.close();
		}
	}

}
