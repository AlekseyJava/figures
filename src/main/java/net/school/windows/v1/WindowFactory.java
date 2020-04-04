package net.school.windows.v1;

public class WindowFactory {
    private static int countRectButton = 0;
    private static int countRoundButton = 0;

    public static RectButton createRectButton(Point leftTop, Point rightBottom, boolean active) {
        countRectButton++;
        return new RectButton(leftTop, rightBottom, active);
    }

    public static RoundButton createRoundButton(Point center, int radius, boolean active) {
        countRoundButton++;
        return new RoundButton(center, radius, active);
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
