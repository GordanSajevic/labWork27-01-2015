import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;



public class Server {
	
	private static final int port = 1717;
	
	public static void startServer()
	{
		try {
			ServerSocket server = new ServerSocket(port);
			while(true)
			{
				System.out.println("Waiting...");
				Socket client = server.accept();
				InputStream in = client.getInputStream();
				StringBuilder sb = new StringBuilder();
				int byteRead = 0;
				int msgLength = in.read();
				byte[] buffer = new byte[msgLength];
				while ((byteRead += in.read(buffer)) >= 0) 
				{
					sb.append(new String(buffer).replaceAll("\\s+", " "));
					if (byteRead >= msgLength)
					{
						break;
					}
				}
				client.close();
				String message = sb.toString();
				for (int i=0; i<10; i++)
				{
					System.out.println(message);
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		startServer();
	}

}
