package FileIo;
 
import java.io.*;

import java.time.LocalDateTime;

import java.time.format.DateTimeFormatter;
 
public class UserRegistration {
 
    // Member variables for user data

    private String username;

    private String password;

    private String email;

    private String securityQuestion;

    private String securityAnswer;

    private String timeAndDate;
 
    // Constructor that initializes user information

    public UserRegistration(String username, String password, String email, String secQsn, String secAns) {

        this.username = username;

        this.password = password;

        this.email = email;

        this.securityQuestion = secQsn;

        this.securityAnswer = secAns;
 
        // Get current date and time

        LocalDateTime myDateObj = LocalDateTime.now();

        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("HH:mm a, dd/MM/yyyy");

        this.timeAndDate = myDateObj.format(myFormatObj);
 
        // Call method to save user data to the file

        saveToFile();

    }
 
    // Method to save user data to file

    private void saveToFile() {

        try {

            // Define the file path

            File file = new File(".\\data\\user_data.txt");
 
            // Check if the file exists; if not, create a new one

            if (!file.exists()) {

                file.createNewFile();

            }
 
            // Create file writers

            FileWriter fw = new FileWriter(file, true);

            BufferedWriter bw = new BufferedWriter(fw);

            PrintWriter pw = new PrintWriter(bw);
 
            // Write user information into the file

            pw.println("User Name : " + username);

            pw.println("Password : " + password);

            pw.println("Email : " + email);

            pw.println("Security Question : " + securityQuestion);

            pw.println("Answer : " + securityAnswer);

            pw.println("Time & Date : " + timeAndDate);

            pw.println("===============================================");
 
            // Close the writers

            pw.flush();

            pw.close();

            bw.close();

            fw.close();

        } catch (Exception ex) {

            System.out.print(ex);

        }

    }

}

 