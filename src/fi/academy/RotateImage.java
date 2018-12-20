package fi.academy;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;

public class RotateImage {
    public static void main(String[] args) throws IOException {

        URL url = new URL("https://upload.wikimedia.org/wikipedia/commons/1/1b/Square_200x200.png");
        InputStream in = new BufferedInputStream(url.openStream());
        OutputStream out = new BufferedOutputStream(new FileOutputStream("rotatoitava.png"));
        for ( int i; (i = in.read()) != -1; ) {
            out.write(i);
        }
        in.close();
        out.close();

        BufferedImage bkuva = ImageIO.read(new File("rotatoitava.png"));
        int w = bkuva.getWidth();
        int h = bkuva.getHeight();
        BufferedImage bkuva2 = new BufferedImage(h, w, bkuva.getType());
        Graphics2D g2 = bkuva2.createGraphics();
        g2.translate(h, 0);
        g2.rotate(Math.PI/2);
        g2.drawImage(bkuva, 0, 0, null);
        g2.dispose();
        ImageIO.write(bkuva2, "png", new File("uusikuva.png"));

    }

}
