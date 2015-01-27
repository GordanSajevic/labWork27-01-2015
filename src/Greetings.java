import java.util.concurrent.CountDownLatch;


public class Greetings extends Thread{

	private static int id;
	private static int totalCount;
	
	public Greetings(int id)
	{
		super();
		this.id = id;
	}
	
	public static void greetingCount()
	{
		for (int i=0; i<5; i++)
		{
			System.out.printf("\nHello from %d! Just counted to: %d, total count is: %d", id, i, totalCount++);
			increaseCount();
		}
	}
	
	public synchronized static void increaseCount()
	{
		totalCount++;
	}
	
	public void run()
	{
		greetingCount();
	}
	
	public static void main(String[] args) {
		Greetings[] gr = new Greetings[5];
		for (int i=0; i<gr.length; i++)
		{
			gr[i] = new Greetings(i);
			gr[i].start();
		}
		for (Greetings g: gr)
		{
			try
			{
				g.join();
			}
			catch(InterruptedException e)
			{
				e.printStackTrace();
			}
		}
		System.out.println("\nThis is the end, my only friend");

	}

}
