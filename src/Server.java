import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Server {
	public static void main(String[] args) {
		
		try {
			ServerSocket server= new ServerSocket(1211);
			Socket socket = server.accept();
			
			
			Scanner scan = new Scanner(socket.getInputStream());
			
			String email = scan.nextLine();
			String password = scan.nextLine();
			
			
			

		    String url = "jdbc:mysql://localhost:3306/users";
		    String dbuser = "root";
		    String dbpass = "123456";
		    
		    try {
		    	Connection con = DriverManager.getConnection(url,dbuser,dbpass);
		    	String query = "SELECT * FROM users WHERE email = ? AND password = ?";
		    	
		    	PreparedStatement prs = con.prepareStatement(query);
		    	prs.setString(1, email);
		    	prs.setString(2, password);
		    	
		    	ResultSet resultSet = prs.executeQuery();
		    	
		    	
		    	if(resultSet.next()) {
		    		System.out.println("Login successful");
		    	}
		    	else {
		    		System.out.println("User not found");
		    	}
		    }catch(Exception e){
		    	e.printStackTrace();
		    }
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	

}
