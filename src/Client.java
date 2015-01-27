import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;


public class Client {

	public static final int port = 1717;
	public static final String address = "127.0.0.1";
	
	public static void connect()
	{
		Scanner input = new Scanner(System.in);
		try {
			Socket client = new Socket(address, port);
			InputStream in = client.getInputStream();
			OutputStream out = client.getOutputStream();
			while(true)
			{
				System.out.println("Enter message: ");
				String message = input.nextLine();
				byte[] msgByte = message.getBytes();
				out.write(msgByte.length);
				out.write(msgByte);
			}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		connect();
	}
}
