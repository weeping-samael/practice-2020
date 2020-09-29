import java.awt.image.BufferedImage;
import java.io.File;

public class BlackAndWhite {
    private final static int CELL_WIDTH = 100;
    private final static int CELL_HEIGHT = 100;

    private final static int TABLE_WIDTH = 37;
    private final static int TABLE_HEIGHT = 37;

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Too few arguments\nFilename of the image is needed");
        } else {
            MyColor[][] table = GridParser.parse(
                    new File(args[0]),
                    TABLE_WIDTH,
                    TABLE_HEIGHT,
                    CELL_WIDTH,
                    CELL_HEIGHT
            );

            writeGrid(table);

            GridWriter.write(
                GridDrawer.draw(table),
                "png",
                new File("output.png")
            );
        }
    }

    private static void writeGrid(MyColor[][] table) {
        for (int y = 0; y < TABLE_HEIGHT; y++) {
            for (int x = 0; x < TABLE_WIDTH; x++) {
                Character ch = table[y][x] == MyColor.WHITE ? 'W' :
                        table[y][x] == MyColor.BLACK ? 'B' : '?';
                System.out.print(ch);
            }
            System.out.println();
        }
    }
}