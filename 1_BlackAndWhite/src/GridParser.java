import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

import java.awt.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class GridParser {
    public static MyColor[][] parse(File imageFile,
                                    int tableWidth,
                                    int tableHeight,
                                    int cellWidth,
                                    int cellHeight) {
        MyColor[][] table = MyColor.tableOfDefault(tableWidth, tableHeight);

        // Map<String, Point> options = new HashMap<>();
        
        Tesseract tesseract = new Tesseract();
        tesseract.setDatapath("Tess4J/tessdata");
        try (BufferedWriter writer = Files.newBufferedWriter(Path.of("output.txt"))) {
            for (int y = 0; y < tableHeight; y++) {
                for (int x = 0; x < tableWidth; x++) {
                    System.out.format("Parsing (%d, %d) cell...\n", y, x);
                    String text;
                    try {
                        text = tesseract.doOCR(
                                imageFile,
                                new Rectangle(
                                        x * cellWidth,
                                        y * cellHeight,
                                        cellWidth - 1,
                                        cellHeight - 1
                                )
                        ).trim()
                            .toLowerCase()
                            .replaceAll(System.lineSeparator(), " ");

                        table[y][x] = MyColor.parse(text);
                        if (table[y][x] == MyColor.UNKNOWN) {
                            writer.write(String.format("(%d, %d) --> \"%s\" --> %s\n",
                                    y, x, text, table[y][x]));
                        }

                        /*if (!text.contains(",")) {
                            options.putIfAbsent(text, new Point(y, x));
                        }*/
                    } catch (TesseractException e) {
                        writer.write(String.format("(%d, %d) --> \"???\"\n", y, x));
                        table[y][x] = MyColor.UNKNOWN;
                    }
                }
            }

            /*writer.write("-------- OPTIONS -----------\n");
            for (String str : options.keySet()) {
                writer.write(String.format("\"%s\" --> (%d, %d)\n",
                        str, options.get(str).x, options.get(str).y));
            }

            writer.write("-------- OPTIONS(w/o cells) -----------\n");
            for (String str : options.keySet()) {
                writer.write("\"" + str + "\"\n");
            }*/
        } catch (IOException e) {
            System.err.println("Error while writing out");
        }

        return table;
    }
}
