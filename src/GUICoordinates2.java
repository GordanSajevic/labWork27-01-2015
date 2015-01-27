import java.awt.AWTException;
import java.awt.Robot;
import java.util.Scanner;


public class GUICoordinates2 {
	
	public static void main(String[] args) throws AWTException 
	{
		Scanner input = new Scanner (System.in);
		System.out.println("Enter x coordinate: ");
		int x = input.nextInt();
		System.out.println("Enter y coordinate: ");
		int y = input.nextInt();
		Robot robot = new Robot();
		robot.mouseMove(x, y);
	}

}
