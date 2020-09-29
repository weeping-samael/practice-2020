import java.awt.*;
import java.awt.image.BufferedImage;

public class GridDrawer {
    private final static int PIXEL_WIDTH = 5;
    private final static int PIXEL_HEIGHT = 5;

    public static BufferedImage draw(MyColor[][] table) {
        final int tableHeight = table.length;
        final int tableWidth = table[0].length;
        BufferedImage image = new BufferedImage(
            tableWidth * PIXEL_WIDTH,
            tableHeight * PIXEL_HEIGHT,
            BufferedImage.TYPE_INT_RGB
        );

        Graphics2D graphics = image.createGraphics();
        for (int y = 0; y < tableHeight; y++) {
            for (int x = 0; x < tableWidth; x++) {
                graphics.setColor(table[y][x].toColor());
                graphics.fillRect(
                    x * PIXEL_WIDTH,
                    y * PIXEL_HEIGHT,
                    PIXEL_WIDTH,
                    PIXEL_HEIGHT
                );
            }
        }

        return image;
    }
}
