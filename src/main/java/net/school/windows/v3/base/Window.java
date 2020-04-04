package net.school.windows.v3.base;

import net.school.windows.v3.Desktop;
import net.school.windows.v3.Point;
import net.school.windows.v3.iface.Movable;
import net.school.windows.v3.iface.Resizable;

import java.util.Objects;

public abstract class Window implements Movable, Resizable {

    private boolean active;
    private String text;

    public Window(boolean active, String text) {
        this.active = active;
        this.text = text;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public abstract boolean isInside(int x, int y);

    public abstract boolean isInside(Point point);

    public abstract boolean isFullyVisibleOnDesktop(Desktop desktop);

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Window window = (Window) o;
        return active == window.active &&
                text.equals(window.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(active, text);
    }
}
