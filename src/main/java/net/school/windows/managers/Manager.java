package net.school.windows.managers;

import net.school.windows.v4.Point;
import net.school.windows.v4.base.Window;
import net.school.windows.v4.base.WindowErrorCode;
import net.school.windows.v4.base.WindowException;

public class Manager<T extends Window> {
    private T window;

    public Manager(T window) throws WindowException {
        if (window == null) {
            throw new WindowException(WindowErrorCode.NULL_WINDOW);
        } else {
            this.window = window;
        }
    }

    public T getWindow() {
        return window;
    }

    public void setWindow(T window) {
        this.window = window;
    }

    public void moveTo(int x, int y) {
        window.moveTo(x, y);
    }

    public void moveTo(Point point) {
        window.moveTo(point.getX(), point.getY());
    }
}
