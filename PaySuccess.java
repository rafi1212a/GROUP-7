
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class PaySuccess extends JFrame {

    private ImageIcon icon;
    private JLabel label1;
    private Font f1, f2;
    private JButton btn1;
    private Cursor cursor;

    // Panel to draw the background image
    class BackgroundPanel extends JPanel {
        private Image backgroundImage;

        public BackgroundPanel() {
            backgroundImage = new ImageIcon(getClass().getResource("/images/payment success.jpg")).getImage();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(backgroundImage, 0, 0, this.getWidth(), this.getHeight(), this);
        }
    }

    PaySuccess() {
        // Frame Layout
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Travel Agency");
        this.setSize(900, 450);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        // Create background panel and set layout
        BackgroundPanel backgroundPanel = new BackgroundPanel();
        backgroundPanel.setLayout(null);
        this.setContentPane(backgroundPanel);

        // Icon
        icon = new ImageIcon(getClass().getResource("/images/Icon.png"));
        this.setIconImage(icon.getImage());

        // Fonts
        f1 = new Font("Segoe UI Black", Font.BOLD, 35); // Set to bold
        f2 = new Font("Segoe UI Black", Font.PLAIN, 25);

        // Gold color for text
        Color gold = new Color(255, 215, 0); // RGB for Gold

        // Title
        label1 = new JLabel("Your Payment Has");
        label1.setBounds(430, 130, 500, 50);
        label1.setFont(f1);
        label1.setForeground(gold); // Set to gold
        backgroundPanel.add(label1);

        label1 = new JLabel("Successfully Completed.");
        label1.setBounds(430, 180, 500, 50);
        label1.setFont(f1);
        label1.setForeground(gold); // Set to gold
        backgroundPanel.add(label1);

        label1 = new JLabel("Happy Travel :)");
        label1.setBounds(430, 230, 500, 50);
        label1.setFont(f1);
        label1.setForeground(gold); // Set to gold
        backgroundPanel.add(label1);
        
        // Cursor for JButtons
        cursor = new Cursor(Cursor.HAND_CURSOR);

        btn1 = new JButton("Finish");
        btn1.setBounds(475, 350, 300, 50);
        btn1.setFont(f2);
        btn1.setCursor(cursor);
        btn1.setForeground(Color.WHITE);
        btn1.setBackground(new Color(25, 25, 112)); // Midnight Blue
        btn1.setBorder(BorderFactory.createLineBorder(Color.decode("#FFD700"), 2)); // Gold border
        btn1.setFocusPainted(false); // Remove focus outline
        backgroundPanel.add(btn1);

        btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                System.exit(0);
            }
        });
    }
    
    public static void main(String[] args) {
        PaySuccess frame = new PaySuccess();
        frame.setVisible(true);
    }
}
