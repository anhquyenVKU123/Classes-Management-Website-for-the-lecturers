package tcp_javaproject;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ImageView {
    private JFrame imageFrame;
    private ImageIcon originalIcon;
    private Image originalImage;
    private Image scaledImage;
    private JLabel imageLabel;
    
    public ImageView(){
 
    }
    
    public void displayImage(String imagePath){
        imageFrame = new JFrame("Image Viewer");
        imageFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        originalIcon = new ImageIcon(imagePath);
        originalImage = originalIcon.getImage();

        // Lấy kích thước gốc của ảnh
        int originalWidth = originalIcon.getIconWidth();
        int originalHeight = originalIcon.getIconHeight();

        // Đặt kích thước khung dựa trên tỷ lệ
        int frameWidth = 400;
        int frameHeight = (originalHeight * frameWidth) / originalWidth;

        scaledImage = originalImage.getScaledInstance(frameWidth, frameHeight, Image.SCALE_SMOOTH);

        imageLabel = new JLabel(new ImageIcon(scaledImage));
        imageFrame.add(imageLabel);

        imageFrame.setSize(frameWidth, frameHeight);
        imageFrame.setLocationRelativeTo(null);
        imageFrame.setVisible(true);
    }
            
}
