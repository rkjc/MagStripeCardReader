import java.util.Scanner;

public class CardReaderMain {

	public static void main(String[] args) {
		System.out.println("Enter your username: ");
		Scanner scanner = new Scanner(System.in);
		String username = scanner.nextLine();
		System.out.println("Your username is " + username);
		
	}

}