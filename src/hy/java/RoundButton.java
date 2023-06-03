import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class RoundButton extends JButton {
    private final int radius;
    private Shape shape;
    public RoundButton(String label, int radius){
        super(label);
        this.radius = radius;
        setContentAreaFilled(false);
    }

    @Override
    public void setBounds(int x, int y, int width, int height){
        super.setBounds(x, y, width, height);
        shape = new RoundRectangle2D.Float(0, 0, width - 1, height - 1, radius, radius);
        repaint();
    }

    @Override
    public boolean contains(int x, int y){
        return shape != null && shape.contains(x, y);
    }
}


