import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class Payment extends JFrame {

    private Container c;
    private ImageIcon icon;
    private JLabel label1, label2, label3, imgLabel;
    private Font f1, f2, f3, f4, f5, f6;
    private ImageIcon img1, img2;
    private JTextField tf1, tf2, tf3;
    private JPasswordField pf;
    private JButton btn1, btn2, btn3, nBtn;
    private Cursor cursor;

    Payment() {
        // Frame Layout
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Travel Agency");
        this.setSize(900, 450);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        // Set Custom JPanel with Background Image
        c = new BackgroundPanel();
        c.setLayout(null);
        this.setContentPane(c);  // Set the custom panel as the content pane

        // Icon
        icon = new ImageIcon(getClass().getResource("/images/Icon.png"));
        this.setIconImage(icon.getImage());

        img1 = new ImageIcon(getClass().getResource("/images/VisaCard.png"));
        imgLabel = new JLabel(img1);
        imgLabel.setBounds(620, 90, img1.getIconWidth(), img1.getIconHeight());
        c.add(imgLabel);

        img2 = new ImageIcon(getClass().getResource("/images/MasterCard.png"));
        imgLabel = new JLabel(img2);
        imgLabel.setBounds(705, 90, img2.getIconWidth(), img2.getIconHeight());
        c.add(imgLabel);

        // Fonts
        f1 = new Font("Segoe UI Black", Font.BOLD, 35);
        f2 = new Font("Segoe UI Semibold", Font.BOLD, 25);
        f3 = new Font("Segoe UI", Font.BOLD, 20);
        f4 = new Font("Segoe UI", Font.PLAIN, 15);
        f5 = new Font("Segoe UI Black", Font.PLAIN, 15);
        f6 = new Font("Segoe UI Black", Font.PLAIN, 25);

        // Title
        label1 = new JLabel("Complete Your Payment");
        label1.setBounds(400, 20, 500, 50);
        label1.setFont(f1);
        label1.setForeground(Color.WHITE);
        c.add(label1);

        label2 = new JLabel("We Accept Only");
        label2.setBounds(420, 85, 500, 50);
        label2.setFont(f2);
        label2.setForeground(Color.WHITE);
        c.add(label2);

        label2 = new JLabel("Card Details");
        label2.setBounds(420, 140, 500, 50);
        label2.setFont(f2);
        label2.setForeground(Color.WHITE);
        c.add(label2);

        // Name On Card
        label3 = new JLabel("Name On Card");
        label3.setBounds(430, 180, 500, 50);
        label3.setFont(f3);
        label3.setForeground(Color.WHITE);
        c.add(label3);

        tf1 = new JTextField();
        tf1.setBounds(570, 190, 235, 30);
        tf1.setFont(f4);
        c.add(tf1);

        // Card Number
        label3 = new JLabel("Card Number");
        label3.setBounds(430, 220, 500, 50);
        label3.setFont(f3);
        label3.setForeground(Color.WHITE);
        c.add(label3);

        tf2 = new JTextField();
        tf2.setBounds(570, 230, 235, 30);
        tf2.setFont(f4);
        tf2.setHorizontalAlignment(JTextField.CENTER);
        c.add(tf2);

        // Valid On
        label3 = new JLabel("Valid On");
        label3.setBounds(430, 260, 500, 50);
        label3.setFont(f3);
        label3.setForeground(Color.WHITE);
        c.add(label3);

        tf3 = new JTextField();
        tf3.setBounds(520, 270, 90, 30);
        tf3.setFont(f4);
        tf3.setHorizontalAlignment(JTextField.CENTER);
        c.add(tf3);

        // CVV Code
        label3 = new JLabel("CVV Code");
        label3.setBounds(620, 260, 500, 50);
        label3.setFont(f3);
        label3.setForeground(Color.WHITE);
        c.add(label3);

        pf = new JPasswordField();
        pf.setBounds(725, 270, 80, 30);
        pf.setHorizontalAlignment(JPasswordField.CENTER);
        pf.setEchoChar('*');
        pf.setFont(f5);
        c.add(pf);

        // Cursor for JButtons
        cursor = new Cursor(Cursor.HAND_CURSOR);

        // JButtons with Rounded Corners and Soft Gradients
        btn1 = createGradientButton("Exit", Color.decode("#C70000"), Color.decode("#FF3D3D"), Color.WHITE); // Dark Red
        btn1.setBounds(75, 325, 190, 50);
        c.add(btn1);

        btn2 = createGradientButton("Back", Color.decode("#191970"), Color.decode("#1E90FF"), Color.WHITE); // Midnight Blue
        btn2.setBounds(300, 325, 190, 50);
        c.add(btn2);

        btn3 = createGradientButton("Confirm Payment", Color.decode("#191970"), Color.decode("#1E90FF"), Color.WHITE); // Midnight Blue
        btn3.setBounds(524, 325, 300, 50);
        c.add(btn3);

        nBtn = new JButton("");
        nBtn.setBounds(0, 0, 0, 0);
        c.add(nBtn);

        // Exit Button ActionListener
        btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                System.exit(0);
            }
        });

        // Back Button Logic
        btn2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                setVisible(false);
                SelfChoosenPacks frame = new SelfChoosenPacks();
                frame.setVisible(true);
            }
        });

        // Confirm Payment Button
        btn3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                String nameOnCard = tf1.getText();
                String cardNumber = tf2.getText();
                String validOn = tf3.getText();
                String cvvCode = pf.getText();

                if (nameOnCard.isEmpty() || cardNumber.isEmpty() || validOn.isEmpty() || cvvCode.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please fill all of the fields.", "Warning!",
                            JOptionPane.WARNING_MESSAGE);
                } else {
                    setVisible(false);
                    PaySuccess frame = new PaySuccess();
                    frame.setVisible(true);
                }
            }
        });
    }

    // Helper method to create gradient buttons with rounded corners
    private JButton createGradientButton(String text, Color color1, Color color2, Color textColor) {
        JButton button = new JButton(text) {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                GradientPaint gp = new GradientPaint(0, 0, color1, getWidth(), getHeight(), color2);
                g2d.setPaint(gp);
                g2d.fillRoundRect(0, 0, getWidth(), getHeight(), 30, 30);
                super.paintComponent(g);
            }
        };
        button.setForeground(textColor);
        button.setFont(f6);
        button.setCursor(cursor);
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        button.setFocusPainted(false); // Remove focus border
        button.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5)); // Add some padding
        button.setPreferredSize(new Dimension(190, 50)); // Set a preferred size for consistency
        return button;
    }

    // Custom JPanel class to handle background image
    class BackgroundPanel extends JPanel {
        private Image backgroundImage;

        public BackgroundPanel() {
            backgroundImage = new ImageIcon(getClass().getResource("/images/payment page.jpg")).getImage();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }

    public static void main(String[] args) {
        Payment frame = new Payment();
        frame.setVisible(true);
    }
}
