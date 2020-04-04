package net.school.windows.v4;

import net.school.windows.v4.base.RectWindow;
import net.school.windows.v4.base.WindowException;
import net.school.windows.v4.base.WindowState;

public class RectButton extends RectWindow {
    private String text;

    public RectButton(Point topLeft, Point bottomRight, WindowState state, String text) throws WindowException {
        super(topLeft, bottomRight, state);
        this.text = text;
    }

    public RectButton(Point topLeft, Point bottomRight, String state, String text) throws WindowException {
        super(topLeft, bottomRight, state);
        this.text = text;
    }

    public RectButton(int xLeft, int yTop, int width, int height, WindowState state, String text) throws WindowException {
        super(xLeft, yTop, width, height, state);
        this.text = text;
    }

    public RectButton(int xLeft, int yTop, int width, int height, String state, String text) throws WindowException {
        super(xLeft, yTop, width, height, state);
        this.text = text;
    }

    public RectButton(Point topLeft, Point bottomRight, String text) throws WindowException {
        super(topLeft, bottomRight);
        this.text = text;
    }

    public RectButton(int xLeft, int yTop, int width, int height, String text) throws WindowException {
        super(xLeft, yTop, width, height);
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
