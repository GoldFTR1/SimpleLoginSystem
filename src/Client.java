import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	public static void main(String[] args) {
		
		try {
			Socket s = new Socket("127.0.0.1",1211);
	
			Scanner scan2 = new Scanner(System.in);
			System.out.println("Enter an email");
			String email = scan2.nextLine();
			System.out.println("Enter your password");
			String password = scan2.nextLine();
			
			PrintStream printout = new PrintStream(s.getOutputStream());
			
			printout.println(email);
			printout.println(password); 
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
