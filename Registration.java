



import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
import java.time.*;
import java.time.format.*;
import java.awt.geom.RoundRectangle2D;

public class Registration extends JFrame {

    private Container c;
    private ImageIcon icon, logo, backgroundImg;
    private JLabel label1, imgLabel, backgroundLabel;
    private Font f1, f2, f3, f4, f5, f6;
    private JTextField tf1, tf2, tf4, tf5;
    private JComboBox<String> securityQsn;
    private CustomButton btn1, btn2, btn3, btn4;
    private JPasswordField tf3;
    private Cursor cursor;
    private int a, b;

    Registration() {
        // Frame Layout
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Travel Agency");
        this.setSize(900, 450);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        c = this.getContentPane();
        c.setLayout(null); // We'll manually set the positions of components

        // Icon
        icon = new ImageIcon(getClass().getResource("/images/Icon.png"));
        this.setIconImage(icon.getImage());

        // Background Image
        backgroundImg = new ImageIcon(getClass().getResource("/images/Background4.jpg"));
        backgroundLabel = new JLabel(backgroundImg);
        backgroundLabel.setBounds(0, 0, this.getWidth(), this.getHeight()); // Cover the entire window with the background
        backgroundLabel.setLayout(null); // No layout manager, components will be positioned manually

        // Fonts
        f1 = new Font("Segoe UI Black", Font.PLAIN, 35);
        f2 = new Font("Segoe UI Black", Font.PLAIN, 25);
        f3 = new Font("Segoe UI Semibold", Font.PLAIN, 35);
        f4 = new Font("Segoe UI", Font.PLAIN, 25);
        f5 = new Font("Segoe UI", Font.PLAIN, 19);
        f6 = new Font("Segoe UI", Font.PLAIN, 25);

        int centerX = (this.getWidth() - 500) / 2;  // Calculate the starting x position for centering the components

        // Title
        label1 = new JLabel("Enter Your Information", SwingConstants.CENTER);
        label1.setBounds(centerX, 25, 500, 50);  // Centering the title
        label1.setFont(f1);
        backgroundLabel.add(label1);

        // User Name
        label1 = new JLabel("User Name");
        label1.setBounds(centerX, 75, 140, 50);  // Centering the labels
        label1.setFont(f4);
        backgroundLabel.add(label1);

        tf1 = new JTextField();
        tf1.setBounds(centerX + 140, 85, 260, 30);  // Aligning the text fields to the right of the labels
        tf1.setFont(f5);
        backgroundLabel.add(tf1);

        // Email
        label1 = new JLabel("Email");
        label1.setBounds(centerX, 110, 140, 50);  // Centering the labels
        label1.setFont(f4);
        backgroundLabel.add(label1);

        tf2 = new JTextField();
        tf2.setBounds(centerX + 140, 120, 260, 30);  // Aligning the text fields to the right of the labels
        tf2.setFont(f5);
        backgroundLabel.add(tf2);

        // Password
        label1 = new JLabel("Password");
        label1.setBounds(centerX, 145, 140, 50);  // Centering the labels
        label1.setFont(f4);
        backgroundLabel.add(label1);

        tf3 = new JPasswordField();
        tf3.setBounds(centerX + 140, 155, 260, 30);  // Aligning the text fields to the right of the labels
        tf3.setFont(f2);
        tf3.setEchoChar('*');
        backgroundLabel.add(tf3);

        // Question
        label1 = new JLabel("Question");
        label1.setBounds(centerX, 180, 140, 50);  // Centering the labels
        label1.setFont(f4);
        backgroundLabel.add(label1);

        String[] secQsn = { "Choose a Security Question...", "Your dream job?", "Your favorite song?", "First pet's name?", "Your favorite hobby?" };
        securityQsn = new JComboBox<>(secQsn);
        securityQsn.setBounds(centerX + 140, 190, 259, 30);  // Aligning the dropdown to the right of the labels
        securityQsn.setSelectedIndex(0);
        securityQsn.setFont(f5);
        securityQsn.setBackground(Color.white);
        backgroundLabel.add(securityQsn);

        // Answer
        label1 = new JLabel("Answer");
        label1.setBounds(centerX, 215, 140, 50);  // Centering the labels
        label1.setFont(f4);
        backgroundLabel.add(label1);

        tf4 = new JTextField();
        tf4.setBounds(centerX + 140, 225, 260, 30);  // Aligning the text fields to the right of the labels
        tf4.setFont(f5);
        backgroundLabel.add(tf4);

        // Captcha Label and Text Field
        label1 = new JLabel("Captcha");
        label1.setBounds(centerX, 250, 140, 50);  // Centering the labels
        label1.setFont(f4);
        backgroundLabel.add(label1);

        tf5 = new JTextField();
        tf5.setBounds(centerX + 140 + 85, 260, 215, 30);  // Aligning the text fields to the right of the labels
        tf5.setFont(f5);
        backgroundLabel.add(tf5);

        // To get a random number for captcha
        Random rand = new Random();
        a = rand.nextInt(10);
        b = rand.nextInt(10);

        // Captcha
        label1 = new JLabel(" " + a + " + " + b + " ");
        label1.setBounds(centerX + 140, 260, 75, 30);  // Captcha positioned before the text field
        label1.setFont(f4);
        label1.setForeground(Color.red);
        label1.setBackground(Color.decode("#FFD3D3"));
        label1.setOpaque(true);
        backgroundLabel.add(label1);

        // Cursor for JButtons
        cursor = new Cursor(Cursor.HAND_CURSOR);

        // Custom Buttons with Colorful Designs
        btn1 = new CustomButton("Exit", new Color(255, 182, 193), new Color(255, 105, 180)); // Soft Coral Red Gradient
        btn1.setBounds(53, 325, 183, 50);
        btn1.setFont(f2);
        btn1.setCursor(cursor);
        backgroundLabel.add(btn1);

        btn2 = new CustomButton("Back", new Color(255, 228, 196), new Color(255, 182, 193)); // Soft Peach Gradient
        btn2.setBounds(251, 325, 183, 50);
        btn2.setFont(f2);
        btn2.setCursor(cursor);
        backgroundLabel.add(btn2);

        btn3 = new CustomButton("Reset", new Color(144, 238, 144), new Color(50, 205, 50)); // Soft Green Gradient
        btn3.setBounds(450, 325, 183, 50);
        btn3.setFont(f2);
        btn3.setCursor(cursor);
        backgroundLabel.add(btn3);

        btn4 = new CustomButton("Register", new Color(255, 192, 203), new Color(255, 105, 180)); // Soft Pink Gradient
        btn4.setBounds(649, 325, 183, 50);
        btn4.setFont(f2);
        btn4.setCursor(cursor);
        backgroundLabel.add(btn4);

        // Adding the background label to the container
        c.add(backgroundLabel);

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

        // Reset Button
        btn3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                setVisible(false);
                Registration frame = new Registration();
                frame.setVisible(true);
            }
        });

                 // Register Button
        btn4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {

                String textField1 = tf1.getText().toLowerCase(); // User Name
                String textField2 = tf2.getText(); // Email
                String textField3 = tf3.getText(); // Password
                String textField4 = tf4.getText(); // Security Question Answer
                String textField5 = tf5.getText(); // Captcha
                String secQsn = String.valueOf(securityQsn.getSelectedItem()); // Security Question
                int result = 0;

                if (textField5.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please fill all of the fields.", "Warning!",
                            JOptionPane.WARNING_MESSAGE);
                } else {
                    result = Integer.parseInt(tf5.getText());
                    if (textField1.isEmpty() || textField2.isEmpty() || textField3.isEmpty() || textField4.isEmpty()
                            || textField5.isEmpty() || ((securityQsn.getSelectedIndex()) == 0)) {
                        JOptionPane.showMessageDialog(null, "Please fill all of the fields.", "Warning!",
                                JOptionPane.WARNING_MESSAGE);
                    } else if (result != (a + b)) {
                        JOptionPane.showMessageDialog(null, "Wrong Captcha.", "Warning!", JOptionPane.WARNING_MESSAGE);
                    } else {

                        try {
                            File file = new File(".\\Data\\user_data.txt");
                            if (!file.exists()) {
                                file.createNewFile();
                            }
                            FileWriter fw = new FileWriter(file, true);
                            BufferedWriter bw = new BufferedWriter(fw);
                            PrintWriter pw = new PrintWriter(bw);

                            LocalDateTime myDateObj = LocalDateTime.now();
                            DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("HH:mm a, dd/MM/yyyy");

                            String timeAndDate = myDateObj.format(myFormatObj);

                            pw.println("User Name : " + textField1);
                            pw.println("Password : " + textField3);
                            pw.println("Email : " + textField2);
                            pw.println("Security Question : " + secQsn);
                            pw.println("Answer : " + textField4);
                            pw.println("Time & Date : " + timeAndDate);
                            pw.println("===============================================");
                            pw.close();

                        } catch (Exception ex) {
                            System.out.print(ex);
                        }

                        JOptionPane.showMessageDialog(null, "Registration Successfully Completed.",
                                "Registration Complete", JOptionPane.WARNING_MESSAGE);
                        setVisible(false);
                        Home frame = new Home();
                        frame.setVisible(true);
                    }
                }
            }
        });


        // Frame visibility
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new Registration();
    }
}

