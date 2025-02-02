import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Home extends JFrame {

    private Container c;
    private ImageIcon icon, background;
    private JLabel titleLabel1, titleLabel2, backgroundLabel;
    private Font titleFont, buttonFont;
    private CustomButton btnLogin, btnRegister, btnExit, btnAdminLogin;
    private Cursor cursor;

    Home() {
        // Frame Layout
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Travel Agency");
        this.setSize(900, 450);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        c = this.getContentPane();
        c.setLayout(null);

        // Background Image - Ensure this image has soft tones
        background = new ImageIcon(getClass().getResource("/images/Background4.jpg"));
        backgroundLabel = new JLabel(background);
        backgroundLabel.setBounds(0, 0, 900, 450); // Adjust size to fit the frame
        c.add(backgroundLabel);

        // Icon
        icon = new ImageIcon(getClass().getResource("/images/Icon.png"));
        this.setIconImage(icon.getImage());

        // Fonts
        titleFont = new Font("Segoe UI Black", Font.BOLD, 48);
        buttonFont = new Font("Segoe UI", Font.PLAIN, 20); // Adjusted button font size

        // Title - Line 1
        titleLabel1 = new JLabel("Travel Anywhere");
        titleLabel1.setBounds(200, 55, 500, 65);
        titleLabel1.setFont(titleFont);
        titleLabel1.setForeground(Color.WHITE); // Set title color to white
        titleLabel1.setHorizontalAlignment(SwingConstants.CENTER); // Center align
        backgroundLabel.add(titleLabel1); // Add to backgroundLabel

        // Title - Line 2
        titleLabel2 = new JLabel("In the World!");
        titleLabel2.setBounds(200, 120, 500, 65);
        titleLabel2.setFont(titleFont);
        titleLabel2.setForeground(Color.WHITE); // Set title color to white
        titleLabel2.setHorizontalAlignment(SwingConstants.CENTER); // Center align
        backgroundLabel.add(titleLabel2); // Add to backgroundLabel

        // Cursor for JButtons
        cursor = new Cursor(Cursor.HAND_CURSOR);

        // New y-axis starting point for buttons (moving them down)
        int yOffset = 280;

        // Login Button (Soft gradient with rounded corners)
        btnLogin = new CustomButton("Login", Color.decode("#A8E6CF"), Color.decode("#56C596")); // Soft green gradient
        btnLogin.setBounds(100, yOffset, 250, 50); // Moved down by increasing y-offset
        btnLogin.setFont(buttonFont);
        btnLogin.setCursor(cursor);
        backgroundLabel.add(btnLogin); // Add to backgroundLabel

        // Exit Button (Soft coral gradient with rounded corners)
        btnExit = new CustomButton("Exit", Color.decode("#FFAAA5"), Color.decode("#FF6F69")); // Soft coral red gradient
        btnExit.setBounds(100, yOffset + 60, 250, 50); // Below the Login button with the same gap
        btnExit.setFont(buttonFont);
        btnExit.setCursor(cursor);
        backgroundLabel.add(btnExit); // Add to backgroundLabel

        // Register Button (Soft pink gradient with rounded corners)
        btnRegister = new CustomButton("Register", Color.decode("#FF8B94"), Color.decode("#FF5E6C")); // Soft pink gradient
        btnRegister.setBounds(500, yOffset, 250, 50); // Moved down by increasing y-offset
        btnRegister.setFont(buttonFont);
        btnRegister.setCursor(cursor);
        backgroundLabel.add(btnRegister); // Add to backgroundLabel

        // Admin Login Button (Soft peach gradient with rounded corners)
        btnAdminLogin = new CustomButton("Admin Login", Color.decode("#FFD3B6"), Color.decode("#FFAB76")); // Soft peach gradient
        btnAdminLogin.setBounds(500, yOffset + 60, 250, 50); // Below the Register button with the same gap
        btnAdminLogin.setFont(buttonFont);
        btnAdminLogin.setCursor(cursor);
        backgroundLabel.add(btnAdminLogin); // Add to backgroundLabel

        // Action Listeners
        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                setVisible(false);
                Login frame = new Login();
                frame.setVisible(true);
            }
        });

        btnRegister.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                Registration frame = new Registration();
                frame.setVisible(true);
                setVisible(false);
            }
        });

        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                System.exit(0);
            }
        });

        btnAdminLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                setVisible(false);
                AdminLogin frame = new AdminLogin();
                frame.setVisible(true);
                JOptionPane.showMessageDialog(null, "By default, Admin Name and Password is: 'admin'", "Information!",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });
    }

    public static void main(String[] args) {
        Home frame = new Home();
        frame.setVisible(true);
    }
}

