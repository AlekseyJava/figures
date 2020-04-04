package net.school.windows.v4.base;

import net.school.windows.v4.iface.Movable;
import net.school.windows.v4.Desktop;
import net.school.windows.v4.Point;
import net.school.windows.v4.iface.Resizable;

import java.util.Objects;

public abstract class Window implements Movable, Resizable {

    private WindowState state = WindowState.ACTIVE;

    public Window() {
    }

    public Window(WindowState state) throws WindowException {
        if ((state == null) || (state == WindowState.DESTROYED)) {
            throw new WindowException(WindowErrorCode.WRONG_STATE);
        } else {
            this.state = state;
        }
    }

    public Window(String state) throws WindowException {
        try {
            this.state = WindowState.valueOf(state);
            if (state.equals("DESTROYED"))
                throw new WindowException(WindowErrorCode.WRONG_STATE);
        } catch (NullPointerException | IllegalArgumentException ex) {
            throw new WindowException(WindowErrorCode.WRONG_STATE);
        }
    }


    public abstract boolean isInside(int x, int y);

    public WindowState getState() {
        return state;
    }

    public void setState(WindowState state) throws WindowException {
        if (this.state != WindowState.DESTROYED) {
            this.state = state;
        } else throw new WindowException(WindowErrorCode.WRONG_STATE);
    }

    public abstract boolean isInside(Point point);

    public abstract boolean isFullyVisibleOnDesktop(Desktop desktop);

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Window window = (Window) o;
        return state == window.state;
    }

    @Override
    public int hashCode() {
        return Objects.hash(state);
    }
}
