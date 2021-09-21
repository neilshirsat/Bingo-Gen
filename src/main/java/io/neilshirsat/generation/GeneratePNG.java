package io.neilshirsat.generation;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.plugins.jpeg.JPEGImageWriteParam;
import javax.imageio.stream.FileImageOutputStream;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GeneratePNG {

    public static void generatePNG(
            Container ImageContainer,
            String name,
            String path
    ) throws IOException {

        ImageContainer.doLayout();
        ImageContainer.validate();
        BufferedImage image = new BufferedImage(
                ImageContainer.getWidth(),
                ImageContainer.getHeight(),
                BufferedImage.TYPE_INT_ARGB
        );
        Graphics2D g2d = image.createGraphics();
        g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON );
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        ImageContainer.printAll( g2d );
        g2d.dispose();

        //System.out.println(ImageContainer);
        //System.out.println(image);
        //System.out.println(g2d);

        try {
            File file = new File(path + "\\" + name + ".png");
            ImageIO.write( image, "png", file );
        } catch (IOException e) {
            System.out.println("Failed");
        }

    }

}
