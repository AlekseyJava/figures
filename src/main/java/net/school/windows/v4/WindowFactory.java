package net.school.windows.v4;

import net.school.windows.v4.base.WindowException;
import net.school.windows.v4.base.WindowState;

public class WindowFactory {
    private static int countRectButton = 0;
    private static int countRoundButton = 0;

    public static RectButton createRectButton(Point leftTop, Point rightBottom, WindowState state, String text) throws WindowException {
        countRectButton++;
        return new RectButton(leftTop, rightBottom, state, text);
    }

    public static RoundButton createRoundButton(Point center, int radius, WindowState state, String text) throws WindowException {
        countRoundButton++;
        return new RoundButton(center, radius, state, text);
    }

    public static int getRectButtonCount() {
        return countRectButton;
    }

    public static int getRoundButtonCount() {
        return countRoundButton;
    }

    public static int getWindowCount() {
        return (countRectButton + countRoundButton);
    }

    public static void reset() {
        countRectButton = 0;
        countRoundButton = 0;
    }
}
