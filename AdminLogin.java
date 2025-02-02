import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.nio.file.*;

public class AdminLogin extends JFrame {

    private Container c;
    private ImageIcon icon, background;
    private JLabel label1, backgroundLabel;
    private Font f1, f2, f4, f5;
    private JTextField tf1;
    private CustomButton btn1, btn2, btn3; // Use CustomButton for colorful buttons
    private JPasswordField tf2;
    private Cursor cursor;

    AdminLogin() {
        // Frame Layout
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Travel Agency");
        this.setSize(900, 450);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        c = this.getContentPane();
        c.setLayout(null);

        // Background Image
        background = new ImageIcon(getClass().getResource("/images/Background4.jpg"));
        backgroundLabel = new JLabel(background);
        backgroundLabel.setBounds(0, 0, 900, 450);
        c.add(backgroundLabel);

        // Icon
        icon = new ImageIcon(getClass().getResource("/images/Icon.png"));
        this.setIconImage(icon.getImage());

        // Fonts
        f1 = new Font("Segoe UI Black", Font.BOLD, 60);
        f2 = new Font("Segoe UI Black", Font.PLAIN, 25);
        f4 = new Font("Segoe UI", Font.PLAIN, 30);
        f5 = new Font("Segoe UI", Font.PLAIN, 22);

        // Title
        label1 = new JLabel("Admin Login");
        label1.setBounds(250, 50, 500, 90); // Centered horizontally
        label1.setFont(f1);
        backgroundLabel.add(label1);

        // User Name
        label1 = new JLabel("Name");
        label1.setBounds(250, 160, 150, 50);
        label1.setFont(f4);
        backgroundLabel.add(label1);

        tf1 = new JTextField();
        tf1.setBounds(410, 170, 210, 35);
        tf1.setFont(f5);
        backgroundLabel.add(tf1);

        // Password
        label1 = new JLabel("Password");
        label1.setBounds(250, 220, 150, 50);
        label1.setFont(f4);
        backgroundLabel.add(label1);

        tf2 = new JPasswordField();
        tf2.setBounds(410, 230, 210, 35);
        tf2.setFont(f2);
        tf2.setEchoChar('*');
        backgroundLabel.add(tf2);

        // Cursor for JButtons
        cursor = new Cursor(Cursor.HAND_CURSOR);

        // JButtons with soft gradient backgrounds
        btn1 = new CustomButton("Exit", Color.decode("#FF6F61"), Color.decode("#FFB3A7")); // Soft coral red gradient
        btn1.setBounds(100, 325, 215, 50);
        btn1.setFont(f2);
        btn1.setCursor(cursor);
        backgroundLabel.add(btn1);

        btn2 = new CustomButton("Back", Color.decode("#FFAEBC"), Color.decode("#FFC3C3")); // Soft pink gradient
        btn2.setBounds(340, 325, 215, 50);
        btn2.setFont(f2);
        btn2.setCursor(cursor);
        backgroundLabel.add(btn2);

        btn3 = new CustomButton("Login", Color.decode("#B3E5C5"), Color.decode("#7FE9B4")); // Soft green gradient
        btn3.setBounds(580, 325, 215, 50);
        btn3.setFont(f2);
        btn3.setCursor(cursor);
        backgroundLabel.add(btn3);

        // Exit Button Action
        btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                System.exit(0);
            }
        });

        // Back Button Action
        btn2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                setVisible(false);
                Home frame = new Home();
                frame.setVisible(true);
            }
        });

        // Login Button Action
        btn3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                String textField1 = tf1.getText().toLowerCase(); // Admin Name
                String textField2 = new String(tf2.getPassword()); // Password

                if (textField1.isEmpty() || textField2.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please fill all of the fields.", "Warning!",
                            JOptionPane.WARNING_MESSAGE);
                } else {
                    try {
                        String userNameS = "Name : " + textField1;
                        String passwordS = "Password : " + textField2;
                        BufferedReader reader = new BufferedReader(new FileReader(".\\Data\\admin_data.txt"));

                        int totalLines = 0;
                        while (reader.readLine() != null)
                            totalLines++;
                        reader.close();

                        for (int i = 0; i < totalLines; i++) {
                            String line = Files.readAllLines(Paths.get(".\\Data\\admin_data.txt")).get(i);
                            if (line.equals(userNameS)) {
                                String line2 = Files.readAllLines(Paths.get(".\\Data\\admin_data.txt")).get(i + 1);
                                if (line2.equals(passwordS)) {
                                    JOptionPane.showMessageDialog(null, "Admin Login Successful.", "Travel Agency!",
                                            JOptionPane.INFORMATION_MESSAGE);

                                    setVisible(false);
                                    Admin frame = new Admin();
                                    frame.setVisible(true);
                                    break;
                                }
                            }
                        }
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Invalid Name or Password!", "Warning!",
                                JOptionPane.WARNING_MESSAGE);
                    }
                }
            }
        });
    }

    public static void main(String[] args) {
        AdminLogin frame = new AdminLogin();
        frame.setVisible(true);
    }
}

