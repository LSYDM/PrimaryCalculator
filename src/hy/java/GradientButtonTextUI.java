import javax.swing.*;
import javax.swing.plaf.basic.BasicButtonUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.FontRenderContext;
import java.awt.font.TextLayout;

public class GradientButtonTextUI extends BasicButtonUI {
    private final Color[] colors = {Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN,
            Color.BLUE, new Color(75, 0, 130), new Color(238, 130, 238)};
    private float currentColorIndex = 0;
    private float currentOutlineColorIndex = 2;

    public GradientButtonTextUI(AbstractButton button) {
        Timer timer = new Timer(5, e -> {
            currentColorIndex = (currentColorIndex + 0.05f) % colors.length;
            currentOutlineColorIndex = (currentOutlineColorIndex + 0.05f) % colors.length;
            button.repaint();
        });
        timer.start();
    }

    @Override
    public void paint(Graphics g, JComponent c) {
        AbstractButton b = (AbstractButton) c;

        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // 设置渐变
        int index = (int) currentColorIndex;
        float fraction = currentColorIndex - index;
        Color startColor = interpolate(colors[index], colors[(index + 1) % colors.length], fraction);
        Color endColor = interpolate(colors[(index + 1) % colors.length], colors[(index + 2) % colors.length], fraction);
        GradientPaint gp = new GradientPaint(0, 0, startColor, 10, 30, endColor);
        g2.setPaint(gp);

        // 绘制文本
        Font font = new Font("宋体", Font.BOLD, 28);
        FontRenderContext frc = g2.getFontRenderContext();
        TextLayout tl = new TextLayout(b.getText(), font, frc);
        Shape shape = tl.getOutline(null);
        Rectangle r = shape.getBounds();
        g2.translate((b.getWidth() - r.width) / 2 - r.x, (b.getHeight() - r.height) / 2 - r.y);
        g2.fill(shape);

        // 设置轮廓颜色
        index = (int) currentOutlineColorIndex;
        fraction = currentOutlineColorIndex - index;
        Color outlineColor = interpolate(colors[index], colors[(index + 1) % colors.length], fraction);
        g2.setColor(outlineColor);

        // 绘制轮廓
        g2.draw(shape);
    }

    public static Color interpolate(Color startColor, Color endColor, float fraction) {
        int red = (int)(startColor.getRed() + fraction * (endColor.getRed() - startColor.getRed()));
        int green = (int)(startColor.getGreen() + fraction * (endColor.getGreen() - startColor.getGreen()));
        int blue = (int)(startColor.getBlue() + fraction * (endColor.getBlue() - startColor.getBlue()));
        return new Color(red, green, blue);
    }
}