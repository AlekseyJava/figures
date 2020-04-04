package net.school.windows.v3.base;

import net.school.windows.v3.Desktop;
import net.school.windows.v3.Point;
import net.school.windows.v3.iface.Movable;
import net.school.windows.v3.iface.Resizable;

import java.util.Objects;

public abstract class RoundWindow extends Window implements Movable, Resizable {
    private int xCenter;
    private int yCenter;
    private int radius;

    public RoundWindow(Point center, int radius, boolean active, String text) {
        super(active, text);
        this.xCenter = center.getX();
        this.yCenter = center.getY();
        this.radius = radius;
    }

    public RoundWindow(int xCenter, int yCenter, int radius, boolean active, String text) {
        super(active, text);
        this.xCenter = xCenter;
        this.yCenter = yCenter;
        this.radius = radius;
    }

    public RoundWindow(Point center, int radius, String text) {
        super(true, text);
        this.xCenter = center.getX();
        this.yCenter = center.getY();
        this.radius = radius;
    }

    public RoundWindow(int xCenter, int yCenter, int radius, String text) {
        super(true, text);
        this.xCenter = xCenter;
        this.yCenter = yCenter;
        this.radius = radius;
    }

    public Point getCenter() {
        return new Point(xCenter, yCenter);
    }

    public int getRadius() {
        return this.radius;
    }

    public void moveTo(int x, int y) {
        this.xCenter = x;
        this.yCenter = y;
    }

    public void setCenter(int x, int y) {
        this.xCenter = x;
        this.yCenter = y;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public void moveRel(int dx, int dy) {
        xCenter = xCenter + dx;
        yCenter = yCenter + dy;
    }

    public void resize(double ratio) {
        radius = (int) (radius * ratio);
        if (radius < 1) radius = 1;
    }

    public boolean isInside(int x, int y) {
        if (Math.sqrt((x - this.xCenter) * (x - this.xCenter) + (y - this.yCenter) * (y - this.xCenter)) <= this.radius)
            return true;
        else return false;
    }

    public boolean isInside(Point point) {
        if (Math.sqrt((point.getX() - this.xCenter) * (point.getX() - this.xCenter) + (point.getY() - this.yCenter) * (point.getY() - this.xCenter)) <= this.radius)
            return true;
        else return false;
    }

    public boolean isFullyVisibleOnDesktop(Desktop desktop) {
        if ((((xCenter - radius) >= 0) && ((xCenter + radius) < desktop.getWidth())) &&
                (((yCenter - radius) >= 0) && ((yCenter + radius) < desktop.getHeight()))) return true;
        else return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        RoundWindow that = (RoundWindow) o;
        return xCenter == that.xCenter &&
                yCenter == that.yCenter &&
                radius == that.radius;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), xCenter, yCenter, radius);
    }
}
