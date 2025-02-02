import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Packs extends JFrame {
    private Container c;
    private ImageIcon icon;
    private JLabel label1, backgroundLabel;
    private Font f1, f2, f3;
    private JButton btn1, btn2, btn3;
    private Cursor cursor;
    private JRadioButton selfChosenPacks;
    private ButtonGroup jButtonGroup;
    private int pack = 0;

    Packs() {
        // Frame Layout
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Travel Agency");
        this.setSize(900, 450);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        // Container
        c = this.getContentPane();
        c.setLayout(null);

        // Background Image (Ensure the image path is correct)
        icon = new ImageIcon(getClass().getResource("/images/Background4.jpg"));
        if (icon.getImageLoadStatus() == MediaTracker.ERRORED) {
            System.out.println("Background image not found!");
            icon = new ImageIcon("path/to/your/default/image.jpg"); // fallback if image not found
        }
        backgroundLabel = new JLabel(icon);
        backgroundLabel.setBounds(0, 0, this.getWidth(), this.getHeight()); // Set background label size to fill the frame
        c.add(backgroundLabel);

        // Icon
        icon = new ImageIcon(getClass().getResource("/images/Icon.png"));
        this.setIconImage(icon.getImage());

        // Fonts
        f1 = new Font("Segoe UI Black", Font.PLAIN, 40);
        f2 = new Font("Segoe UI Semibold", Font.PLAIN, 30);
        f3 = new Font("Segoe UI Black", Font.PLAIN, 25);

        // Cursor for JButtons and Radio Buttons
        cursor = new Cursor(Cursor.HAND_CURSOR);

        // Title
        label1 = new JLabel("Choose Your Package");
        label1.setBounds(200, 40, 500, 50); // Centered horizontally
        label1.setFont(f1);
        label1.setForeground(Color.BLACK); // Text color changed to black
        backgroundLabel.add(label1);

        JLabel typeLabel = new JLabel("Type");
        typeLabel.setBounds(200, 90, 500, 50); // Centered horizontally
        typeLabel.setFont(f1);
        typeLabel.setForeground(Color.BLACK); // Text color changed to black
        backgroundLabel.add(typeLabel);

        // Radio Buttons
        selfChosenPacks = new JRadioButton("Self-Chosen Packs");
        selfChosenPacks.setBounds(300, 200, 300, 50); // Centered horizontally
        selfChosenPacks.setFont(f2);
        selfChosenPacks.setCursor(cursor);
        selfChosenPacks.setOpaque(false); // Make background transparent
        selfChosenPacks.setForeground(Color.BLACK); // Text color changed to black
        backgroundLabel.add(selfChosenPacks);

        // Button Group for Radio Buttons
        jButtonGroup = new ButtonGroup();
        jButtonGroup.add(selfChosenPacks);

        // Define new colors
        Color darkRed = Color.decode("#B22222"); // Dark red for Exit button
        Color darkBlue = Color.decode("#003366"); // Dark blue for Back and Next buttons

        // Buttons with gradients and rounded corners
        btn1 = createGradientButton("Exit", darkRed, darkRed.darker(), 90, 325); // Dark red for Exit button
        btn2 = createGradientButton("Back", darkBlue, darkBlue.darker(), 340, 325); // Dark blue for Back button
        btn3 = createGradientButton("Next", darkBlue, darkBlue.darker(), 590, 325); // Dark blue for Next button

        // Add buttons to background label
        backgroundLabel.add(btn1);
        backgroundLabel.add(btn2);
        backgroundLabel.add(btn3);

        // Handler for radio buttons
        selfChosenPacks.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                pack = 1;
            }
        });

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
                new Login().setVisible(true); // Switch to Login frame
            }
        });

        // Next Button Action
        btn3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                if (pack == 1) {
                    setVisible(false);
                    new SelfChoosenPacks().setVisible(true); // Switch to SelfChosenPacks frame
                } else {
                    JOptionPane.showMessageDialog(null, "You forgot to select package type :(", "Warning!!!",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
        });
    }

    private JButton createGradientButton(String text, Color color1, Color color2, int x, int y) {
        JButton button = new JButton(text) {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D) g;
                GradientPaint gp = new GradientPaint(0, 0, color1, 0, getHeight(), color2);
                g2d.setPaint(gp);
                g2d.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20); // Rounded corners
                super.paintComponent(g);
            }
        };
        button.setBounds(x, y, 215, 50);
        button.setFont(f3);
        button.setCursor(cursor);
        button.setForeground(Color.WHITE); // Button text color
        button.setBorder(BorderFactory.createLineBorder(Color.decode("#FFD700"), 2)); // Gold border
        button.setFocusPainted(false); // Remove focus paint
        button.setContentAreaFilled(false); // Remove default background
        return button;
    }

    public static void main(String[] args) {
        Packs frame = new Packs();
        frame.setVisible(true);
    }
}

