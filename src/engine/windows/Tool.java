package engine.windows;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Tool {
    public static BufferedImage rotate(BufferedImage bimg, double angle) {

        int w = bimg.getWidth();
        int h = bimg.getHeight();

        BufferedImage rotated = new BufferedImage(w+20, h+20, bimg.getType());
        Graphics2D graphic = rotated.createGraphics();
        graphic.rotate(angle, w/2, h/2);
        graphic.drawImage(bimg, null, 0, 0);
        graphic.dispose();
        return rotated;
    }
    public static BufferedImage ScaleImage(BufferedImage originalImage, double scale) {
        int originalWidth = originalImage.getWidth();
        int originalHeight = originalImage.getHeight();
        int width = (int) (originalWidth * scale);
        int height = (int) (originalHeight * scale);
        Image scaledImage = originalImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D graphics = image.createGraphics();
        graphics.drawImage(scaledImage, 0, 0, null);
        graphics.dispose();
        return image;
    }
}
