import javax.swing.*;
import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.add(new Draw());
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

class Draw extends JComponent {
    private static final int DEFAULT_WIDTH = 800;
    private static final int DEFAULT_HEIGHT = 400;
    private Image image;

    Draw() {
        image = new ImageIcon("blue-ball.gif").getImage();
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        String message = "Hello, World!";

        Font f = new Font("Serif", Font.BOLD, 36);
        g2.setFont(f);

        FontRenderContext context = g2.getFontRenderContext();
        Rectangle2D bounds = f.getStringBounds(message, context);

        double x = (getWidth() / 2 - bounds.getWidth()) / 2;
        double y = (getHeight() - bounds.getHeight()) / 2;

        double ascent = -bounds.getY();
        double baseY = y + ascent;

        g2.drawString(message, (int) x, (int) baseY);

        g2.setPaint(Color.LIGHT_GRAY);

        g2.draw(new Line2D.Double(x, baseY, x + bounds.getWidth(), baseY));

        Rectangle2D rect = new Rectangle2D.Double(x, y, bounds.getWidth(), bounds.getHeight());
        g2.draw(rect);

        if (image == null) return;

        int imageWidth = image.getWidth(null);
        int imageHeight = image.getHeight(null);


        g.drawImage(image, getWidth() / 2, 0, null);

        for (int i = 0; i * imageWidth <= getWidth(); i++) {
            for (int j = 0; j * imageHeight <= getHeight(); j++) {
                if (i + j > 0)
                    g.copyArea(getWidth() / 2, 0, imageWidth, imageHeight, i * imageWidth, j * imageHeight);
            }
        }
    }

    public Dimension getPreferredSize() {
        return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }
}
