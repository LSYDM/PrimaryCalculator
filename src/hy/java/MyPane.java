import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MyPane extends JPanel {
    private final BufferedImage image;
    private static final int WINDOW_WIDTH = 400;
    private static final int WINDOW_HEIGHT = 600;

    public MyPane() {
        try {
            image = ImageIO.read(new File("src/hy/resources/Image/March 7 vertical screen version.jpg"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        float alpha = 1f;
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));
        g.drawImage(image, 0, 0, WINDOW_WIDTH, WINDOW_HEIGHT, null);
    }
}