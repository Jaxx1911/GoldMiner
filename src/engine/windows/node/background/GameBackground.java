package engine.windows.node.background;

import engine.windows.Tool;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GameBackground {
    BufferedImage UpBackground;

    BufferedImage HalfCircle;

    public GameBackground(){
        try {
            UpBackground = ImageIO.read(new File("Resources/GameBackGround/Rec.png"));
            HalfCircle = ImageIO.read(new File("Resources/GameBackGround/Up.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    public void draw(Graphics g){
        g.setColor(Color.ORANGE);
        g.fillRect(0,0,800,600);
        g.drawImage(ScaleImage(UpBackground,1600, HalfCircle.getHeight()),-400,30,null);
        g.drawImage(HalfCircle,400 - HalfCircle.getWidth()/2,ScaleImage(UpBackground,1600, HalfCircle.getHeight()).getHeight()- HalfCircle.getHeight()+30,null);
    }

    public static BufferedImage ScaleImage(BufferedImage originalImage, double width,double height) {
        int originalWidth = originalImage.getWidth();
        int originalHeight = originalImage.getHeight();
        Image scaledImage = originalImage.getScaledInstance((int) width, (int) height, Image.SCALE_SMOOTH);
        BufferedImage image = new BufferedImage((int) width, (int) height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D graphics = image.createGraphics();
        graphics.drawImage(scaledImage, 0, 0, null);
        graphics.dispose();
        return image;
    }
}
