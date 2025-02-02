import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import FileIo.UserRegistration;  // Import the UserRegistration class from the FileIo package
 
public class Start {
 
    public static void main(String[] args) {
        // Example: Simulating a user registration process happening in the background
        // This will execute the file-writing process, but it won't display any information or interfere with the GUI
        String username = "testUser";      // You can hard-code these values or fetch them from elsewhere
        String password = "password123";
        String email = "user@example.com";
        String secQsn = "What is your pet's name?";
        String secAns = "Fluffy";
 
        // Create a new UserRegistration object to write data into the file
        new UserRegistration(username, password, email, secQsn, secAns);
        // Now proceed with displaying the welcome frame
        Welcome frame = new Welcome();
        frame.setVisible(true);
    }
}
