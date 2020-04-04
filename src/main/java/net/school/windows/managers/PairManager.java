package net.school.windows.managers;

import net.school.windows.v4.base.WindowErrorCode;
import net.school.windows.v4.base.WindowException;
import net.school.windows.v4.Desktop;
import net.school.windows.v4.base.Window;

public class PairManager<T, V> {

    private T firstWindow;
    private V secondWindow;

    public PairManager(T firstWindow, V secondWindow) throws WindowException {
        if (firstWindow == null || secondWindow == null) {
            throw new WindowException(WindowErrorCode.NULL_WINDOW);
        } else {
            this.firstWindow = firstWindow;
            this.secondWindow = secondWindow;
        }
    }

    public T getFirstWindow() {
        return firstWindow;
    }

    public void setFirstWindow(T firstWindow) throws WindowException {
        try {
            this.firstWindow = firstWindow;
        } catch (NullPointerException ex) {
            throw new WindowException(WindowErrorCode.NULL_WINDOW);
        }
    }

    public V getSecondWindow() {
        return secondWindow;
    }

    public void setSecondWindow(V secondWindow) throws WindowException {
        try {
            this.secondWindow = secondWindow;
        } catch (NullPointerException ex) {
            throw new WindowException(WindowErrorCode.NULL_WINDOW);
        }
    }

    public static boolean allWindowsFullyVisibleOnDesktop(PairManager firstPair, PairManager secondPair, Desktop desktop) throws WindowException {
        Window[] windows = {
                (Window) firstPair.getFirstWindow(),
                (Window) firstPair.getSecondWindow(),
                (Window) secondPair.getFirstWindow(),
                (Window) secondPair.getSecondWindow()
        };
        return new ArrayManager(windows).allWindowsFullyVisibleOnDesktop(desktop);
    }

    public boolean allWindowsFullyVisibleOnDesktop(PairManager firstPair, Desktop desktop) throws WindowException {
        Window[] windows = {
                (Window) firstPair.getFirstWindow(),
                (Window) firstPair.getSecondWindow(),
        };
        return new ArrayManager(windows).allWindowsFullyVisibleOnDesktop(desktop);
    }
}
