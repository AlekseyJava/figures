package net.school.windows.managers;

import net.school.windows.v4.Desktop;
import net.school.windows.v4.base.Window;
import net.school.windows.v4.base.WindowErrorCode;
import net.school.windows.v4.base.WindowException;
import net.school.windows.v4.cursors.Cursor;

public class ArrayManager<T extends Window> {

    private T[] windows;

    public ArrayManager(T[] windows) throws WindowException {
        for (T window : windows) {
            if (window == null) throw new WindowException(WindowErrorCode.NULL_WINDOW);
        }
        this.windows = windows;
    }

    public T[] getWindows() {
        return windows;
    }

    public void setWindows(T[] windows) {
        this.windows = windows;
    }

    public T getWindow(int i) {
        return windows[i];
    }

    public void setWindow(T window, int i) {
        windows[i] = window;
    }

    public boolean isSameSize(ArrayManager sameArray) {
        return (this.windows.length == sameArray.windows.length);
    }

    public boolean allWindowsFullyVisibleOnDesktop(Desktop desktop) {
        for (T window : windows) {
            if ((window.isFullyVisibleOnDesktop(desktop)) == false) return false;
        }
        return true;
    }

    public boolean anyWindowFullyVisibleOnDesktop(Desktop desktop) {
        for (T window : windows) {
            if (window.isFullyVisibleOnDesktop(desktop)) return true;
        }
        return false;
    }

    public Window getFirstWindowFromCursor(Cursor cursor) {
        for (T window : windows) {
            if (window.isInside(cursor.getX(), cursor.getY())) return window;
        }
        return null;

    }

}
