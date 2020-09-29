import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GridWriter {
    public static void write(BufferedImage image, String formatName, File outputFile) {
        try {
            ImageIO.write(image, formatName, outputFile);
        } catch (IOException e) {
            System.err.println("Error while writing image down: " + e.getMessage());
        }
    }
}
