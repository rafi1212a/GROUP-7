import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Welcome extends JFrame {

    private Container c;
    private ImageIcon icon, welcome;
    private JLabel imgLabel, label1;
    private Font f1, f2;
    private CustomButton btn1, btn3, nBtn;
    private Cursor cursor;

    Welcome() {
        // Frame Layout
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Travel Agency");
        this.setSize(900, 450);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.decode("#34495E"));

        // Icon
        icon = new ImageIcon(getClass().getResource("/images/Icon.png"));
        this.setIconImage(icon.getImage());

        // Background Image
        welcome = new ImageIcon(getClass().getResource("/images/welcome page.jpg"));
        imgLabel = new JLabel(welcome);
        imgLabel.setBounds(0, 0, 900, 450);
        c.add(imgLabel);

        // Updated Fonts (Increased size, Italic)
        f1 = new Font("Segoe UI Black", Font.ITALIC | Font.BOLD, 45);
        f2 = new Font("Segoe UI Black", Font.ITALIC | Font.BOLD, 30);

        // Cursor for JButtons
        cursor = new Cursor(Cursor.HAND_CURSOR);

        // Label to display the welcome message (Centered, Increased size, New Color)
        label1 = new JLabel("Welcome To Travel Agency", JLabel.CENTER);
        label1.setBounds(0, 100, 900, 50);  // Setting bounds to span across the frame
        label1.setFont(f1);
        label1.setForeground(new Color(255, 153, 51));  // Beautiful orange color
        imgLabel.add(label1); // Add the label to the background image

        // Gradient and rounded buttons
        btn1 = new CustomButton("Exit", Color.decode("#FFAAA5"), Color.decode("#FF6F69")); // Coral gradient
        btn1.setBounds(120, 370, 200, 50);
        btn1.setFont(f2);
        btn1.setCursor(cursor);
        imgLabel.add(btn1); // Add button to the background label

        btn3 = new CustomButton("Next", Color.decode("#A8E6CF"), Color.decode("#56C596")); // Soft green gradient
        btn3.setBounds(540, 370, 200, 50);
        btn3.setFont(f2);
        btn3.setCursor(cursor);
        imgLabel.add(btn3); // Add button to the background label

        nBtn = new CustomButton("", Color.decode("#FFFFFF"), Color.decode("#FFFFFF")); // Hidden button
        nBtn.setBounds(0, 0, 0, 0);
        imgLabel.add(nBtn); // Add hidden button

        // Action Listener for JButtons
        // Exit Button
        btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                System.exit(0);
            }
        });

        // Next Button
        btn3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                setVisible(false);
                Home frame = new Home();
                frame.setVisible(true);
            }
        });
    }

    public static void main(String[] args) {
        Welcome frame = new Welcome();
        frame.setVisible(true);
    }
}