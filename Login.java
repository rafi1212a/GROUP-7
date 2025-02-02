import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;

public class Login extends JFrame {
    private Container c;
    private ImageIcon icon;
    private JLabel label1;
    private Font f1, f2, f3, f4, f5, f6;
    private JTextField tf1;
    private JButton btn1, btn2, btn3;
    private JPasswordField tf2;
    private Cursor cursor;

    // Custom JPanel for background image
    private class BackgroundPanel extends JPanel {
        private Image backgroundImage;

        public BackgroundPanel() {
            // Load the background image
            backgroundImage = new ImageIcon(getClass().getResource("/images/Background4.jpg")).getImage();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }

    Login() {
        // Frame Layout
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Travel Agency");
        this.setSize(900, 450);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        // Use custom background panel
        BackgroundPanel backgroundPanel = new BackgroundPanel();
        c = backgroundPanel;
        c.setLayout(null);
        this.setContentPane(c);

        // Icon
        icon = new ImageIcon(getClass().getResource("/images/Icon.png"));
        this.setIconImage(icon.getImage());

        // Fonts
        f1 = new Font("Segoe UI Black", Font.BOLD, 60);
        f2 = new Font("Segoe UI Black", Font.PLAIN, 25);
        f3 = new Font("Segoe UI Semibold", Font.PLAIN, 35);
        f4 = new Font("Segoe UI", Font.PLAIN, 30);
        f5 = new Font("Segoe UI", Font.PLAIN, 22);
        f6 = new Font("Segoe UI", Font.PLAIN, 25);

        // Title
        label1 = new JLabel("User Login", JLabel.CENTER);
        label1.setBounds(250, 30, 400, 90); // Adjusted to be centered
        label1.setFont(f1);
        label1.setForeground(Color.BLACK); // Changed to black
        c.add(label1);

        // User Name
        JLabel usernameLabel = new JLabel("User Name", JLabel.CENTER);
        usernameLabel.setBounds(250, 135, 400, 50); // Adjusted to be centered
        usernameLabel.setFont(f4);
        usernameLabel.setForeground(Color.BLACK); // Changed to black
        c.add(usernameLabel);

        tf1 = new JTextField();
        tf1.setBounds(300, 185, 300, 35); // Adjusted to be centered
        tf1.setFont(f5);
        c.add(tf1);

        // Password
        JLabel passwordLabel = new JLabel("Password", JLabel.CENTER);
        passwordLabel.setBounds(250, 230, 400, 50); // Adjusted to be centered
        passwordLabel.setFont(f4);
        passwordLabel.setForeground(Color.BLACK); // Changed to black
        c.add(passwordLabel);

        tf2 = new JPasswordField();
        tf2.setBounds(300, 280, 300, 35); // Adjusted to be centered
        tf2.setFont(f5);
        tf2.setEchoChar('*');
        c.add(tf2);

        // Cursor for JButtons
        cursor = new Cursor(Cursor.HAND_CURSOR);

        // JButtons with colorful and beautiful shapes
        btn1 = new RoundedButton("Exit", new Color(255, 102, 102)); // Soft coral red
        btn1.setBounds(100, 350, 215, 50);
        btn1.setFont(f2);
        btn1.setCursor(cursor);
        c.add(btn1);

        btn2 = new RoundedButton("Back", new Color(102, 204, 102)); // Soft green
        btn2.setBounds(340, 350, 215, 50);
        btn2.setFont(f2);
        btn2.setCursor(cursor);
        c.add(btn2);

        btn3 = new RoundedButton("Login", new Color(255, 204, 153)); // Soft peach
        btn3.setBounds(580, 350, 215, 50);
        btn3.setFont(f2);
        btn3.setCursor(cursor);
        c.add(btn3);

        // Exit Button
        btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                System.exit(0);
            }
        });

        // Back Button
        btn2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                setVisible(false);
                Home frame = new Home();
                frame.setVisible(true);
            }
        });

        // Login Button
        btn3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                String textField1 = tf1.getText().toLowerCase(); // User Name
                String textField2 = String.valueOf(tf2.getPassword()); // Password
                if (textField1.isEmpty() || textField2.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please fill all of the fields.", "Warning!",
                            JOptionPane.WARNING_MESSAGE);
                } else {
                    try (BufferedReader reader = new BufferedReader(new FileReader(".\\Data\\user_data.txt"))) {
                        String line;
                        boolean loginSuccess = false;
                        while ((line = reader.readLine()) != null) {
                            String userNameS = "User Name : " + textField1;
                            String passwordS = "Password : " + textField2;
                            if (line.equals(userNameS)) {
                                String passwordLine = reader.readLine();
                                if (passwordLine.equals(passwordS)) {
                                    loginSuccess = true;
                                    JOptionPane.showMessageDialog(null, "Login Successful.", "Travel Agency!",
                                            JOptionPane.INFORMATION_MESSAGE);
                                    setVisible(false);
                                    Packs frame = new Packs();
                                    frame.setVisible(true);
                                    break;
                                }
                            }
                        }
                        if (!loginSuccess) {
                            JOptionPane.showMessageDialog(null, "Invalid User Name or Password!", "Warning!",
                                    JOptionPane.WARNING_MESSAGE);
                        }
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Error reading file!", "Error!",
                                JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
    }

    // Custom JButton class for colorful rounded buttons
    private class RoundedButton extends JButton {
        private Color backgroundColor;

        public RoundedButton(String text, Color bgColor) {
            super(text);
            this.backgroundColor = bgColor;
            setContentAreaFilled(false);
            setFocusPainted(false);
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(backgroundColor);
            g2.fillRoundRect(0, 0, getWidth(), getHeight(), 30, 30); // Rounded corners
            super.paintComponent(g2);
            g2.dispose();
        }

        @Override
        public void setContentAreaFilled(boolean b) {
            // Do nothing
        }
    }

    public static void main(String[] args) {
        Login frame = new Login();
        frame.setVisible(true);
    }
}
