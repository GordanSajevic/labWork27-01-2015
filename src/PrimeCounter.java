import java.util.Date;


public class PrimeCounter extends Thread{

	private int start;
	private int end;
	private static int counter;
	
	public PrimeCounter(int start, int end)
	{
		this.start = start;
		this.end = end;
	}
	
	private static boolean isPrime(int num)
	{
		for (int i=2; i<num; i++)
		{
			if (num % i == 0)
			{
				return false;
			}
		}
		return true;
	}
	
	private static void primeCount(int start, int end)
	{
		for (int i=start; i<end; i++)
		{
			if (isPrime(i))
			{
				counter++;
			}
		}
	}
	
	public void run()
	{
		Date startDate = new Date();
		primeCount(start, end);
		Date endDate = new Date();
		System.out.println("Prime numbers: " + counter);
		System.out.println("Seconds: " + (double)(endDate.getTime() - startDate.getTime())/1000);
		
	}
	
	public static void main(String[] args) {
		PrimeCounter pc1 = new PrimeCounter(1, 2500000);
		pc1.start();
		PrimeCounter pc2 = new PrimeCounter(250000, 500000);
		pc2.start();
		PrimeCounter pc3 = new PrimeCounter(500000, 1000000);
		pc3.start();
		PrimeCounter pc4 = new PrimeCounter(1000000, 1250000);
		pc4.start();
		PrimeCounter pc5 = new PrimeCounter(1500000, 1750000);
		pc5.start();
		PrimeCounter pc6 = new PrimeCounter(1750000, 2000000);
		pc6.start();
		
	}

}
