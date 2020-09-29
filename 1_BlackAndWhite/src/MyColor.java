import java.awt.*;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public enum MyColor {
    BLACK,
    WHITE,
    UNKNOWN;

    private final static Map<MyColor, List<String>> VALUES = Map.of(
        MyColor.BLACK,
        List.of(
            "biackest ceii ever",
            "b m for b\\ack",
            "b\\ackgg0 ch ww",
            "b is f0r black",
            "very biack",
            "dummss",
            "darkness",
            "b\\ack",
            "blﬂcr",
            "b ls {or mm",
            "black",
            "not white",
            "n0t white",
            "biack",
            "blﬂciust mm ever",
            "darkmgg",
            "9 l 7]",
            "b is for biack",
            "bis f0r biack",
            "vew biack",
            "vwy mm",
            "mm mm",
            "vsrg mm",
            "wa b\\ack",
            "ndt mm"
        ),
        MyColor.WHITE,
        List.of(
            "white",
            "w m for thng",
            "w is f0r white",
            "whitc",
            "this one is aiso white",
            "w is for white",
            "simpiy white",
            "r+q+e",
            "simply whitc",
            "r+g+b",
            "this 0ne is ais0 white",
            "w ls {or wmlts",
            "§\\mp\\y thwg",
            "wm lts",
            "tmls om ls mm wmlts",
            "msz",
            "vawpl5 w lts"
        )
    );

    private final static Map<MyColor, Color> COLORS = Map.of(
        MyColor.BLACK, Color.BLACK,
        MyColor.WHITE, Color.WHITE,
        MyColor.UNKNOWN, Color.MAGENTA
    );

    public static MyColor[] arrayOfDefault(int length) {
        MyColor[] array = new MyColor[length];
        Arrays.fill(array, UNKNOWN);
        return array;
    }

    public static MyColor[][] tableOfDefault(int width, int height) {
        MyColor[][] table = new MyColor[height][];
        for (int k = 0; k < height; k++) {
            table[k] = arrayOfDefault(width);
        }
        return table;
    }

    public static MyColor parse(String string) {
        if (string == null || string.isEmpty()) {
            return UNKNOWN;
        }
        for (MyColor color : VALUES.keySet()) {
            if (VALUES.get(color).contains(string)) {
                return color;
            }
        }
        if (string.contains(",")) {
            return string.replaceAll("\\s", "").length() < 10
                    ? MyColor.BLACK : MyColor.WHITE;
        }
        return UNKNOWN;
    }

    public Color toColor() {
        return COLORS.get(this);
    }
}
