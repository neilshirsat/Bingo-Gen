package io.neilshirsat.generation;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GenerateJPG {

    public static void generateJPG(
            JFrame frame,
            String name,
            String path
    ) {

        Container ImageContainer = frame.getContentPane();
        System.out.println(ImageContainer);
        BufferedImage image = new BufferedImage(
                ImageContainer.getWidth(),
                ImageContainer.getHeight(),
                BufferedImage.TYPE_INT_RGB
        );
        Graphics2D g2d = image.createGraphics();
        g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON );
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        ImageContainer.print( g2d );

        try {
            File file = new File(path + "\\" + name + ".jpg");
            System.out.println(file.getAbsoluteFile());
            ImageIO.write( image, "jpg", file );
        } catch (IOException e) {
            System.out.println("Failed");
        }

    }

}
