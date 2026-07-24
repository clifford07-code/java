
package exp13;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
public class ImageGallery extends JFrame implements ActionListener {
    JLabel imageLabel, infoLabel;
    JButton prevButton, nextButton;
    JTable table;
    ImageIcon[] images;
    String[][] imageData = {
            {"Tiger", "800x600", "120 KB"},
            {"Beach", "1024x768", "200 KB"},
            {"car", "1280x720", "300 KB"}
    };
    int current = 0;
    public ImageGallery() {
        try {
            for (UIManager.LookAndFeelInfo info :
                    UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(
                            info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        setTitle("Image Gallery");
        setSize(700, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        Container c = getContentPane();
        c.setLayout(new BorderLayout(10, 10));
        images = new ImageIcon[]{
                new ImageIcon("exp13/image1.png"),
                new ImageIcon("exp13/image2.png"),
                new ImageIcon("exp13/image3.jpeg")
        };
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(400, 300));
        layeredPane.setBorder(
                new TitledBorder(
                        new EmptyBorder(10,10,10,10),
                        "Image Gallery"));
        imageLabel = new JLabel();
        imageLabel.setBounds(50, 20, 500, 250);
        imageLabel.setIcon(images[current]);
        imageLabel.setBorder(new LineBorder(Color.BLACK, 2));
        imageLabel.setOpaque(true);
        layeredPane.add(imageLabel,
                JLayeredPane.DEFAULT_LAYER);
        c.add(layeredPane, BorderLayout.NORTH);
        String[] columns = {
                "Image Name",
                "Resolution",
                "Size"
        };
        DefaultTableModel model =
                new DefaultTableModel(imageData, columns);
        table = new JTable(model);
        table.setBorder(
                new EmptyBorder(10,10,10,10));
        JScrollPane scrollPane =
                new JScrollPane(table);
        scrollPane.setBorder(
                new TitledBorder(
                        new EmptyBorder(10,10,10,10),
                        "Image Details"));
        c.add(scrollPane, BorderLayout.CENTER);
        JPanel bottomPanel = new JPanel();
        prevButton = new JButton("Previous");
        nextButton = new JButton("Next");
        prevButton.setToolTipText("Show Previous Image");
        nextButton.setToolTipText("Show Next Image");
        prevButton.setMnemonic(KeyEvent.VK_P);
        nextButton.setMnemonic(KeyEvent.VK_N);
        prevButton.addActionListener(this);
        nextButton.addActionListener(this);
        prevButton.setBorder(new LineBorder(Color.BLACK, 2));
        nextButton.setBorder(new LineBorder(Color.BLACK, 2));
        prevButton.setOpaque(true);
        nextButton.setOpaque(true);
        infoLabel = new JLabel();
        infoLabel.setFont(
                new Font("Arial", Font.BOLD, 18));
        infoLabel.setForeground(Color.BLUE);
        updateImageInfo();
        bottomPanel.add(prevButton);
        bottomPanel.add(nextButton);
        bottomPanel.add(infoLabel);
        c.add(bottomPanel, BorderLayout.SOUTH);
        setVisible(true);
    }
public void updateImageInfo() {
    Image originalImage = images[current].getImage();
    Image scaledImage = originalImage.getScaledInstance(
            imageLabel.getWidth() > 0 ? imageLabel.getWidth() : 500, 
            imageLabel.getHeight() > 0 ? imageLabel.getHeight() : 250, 
            Image.SCALE_SMOOTH
    );
    imageLabel.setIcon(new ImageIcon(scaledImage));
    String info = imageData[current][0] + " | "
            + imageData[current][1] + " | "
            + imageData[current][2];
    infoLabel.setText(info);
}
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == nextButton) {
            current++;
            if (current >= images.length) {
                current = 0;
            }
        }
        if (e.getSource() == prevButton) {
            current--;
            if (current < 0) {
                current = images.length - 1;
            }
        }
        updateImageInfo();
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ImageGallery();
        });
    }
}

