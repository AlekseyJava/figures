package net.school.windows.v4.base;

import net.school.windows.v4.iface.Movable;
import net.school.windows.v4.Desktop;
import net.school.windows.v4.Point;
import net.school.windows.v4.iface.Resizable;

import java.util.Objects;

public abstract class RoundWindow extends Window implements Movable, Resizable {
    private int xCenter;
    private int yCenter;
    private int radius;
    private String text;

    public RoundWindow(Point center, int radius, WindowState state, String text) throws WindowException {
        super(state);
        this.xCenter = center.getX();
        this.yCenter = center.getY();
        this.radius = radius;
        this.text = text;
    }

    public RoundWindow(Point center, int radius, String state, String text) throws WindowException {
        super(state);
        this.xCenter = center.getX();
        this.yCenter = center.getY();
        this.radius = radius;
        this.text = text;
    }

    public RoundWindow(int xCenter, int yCenter, int radius, WindowState state, String text) throws WindowException {
        super(state);
        this.xCenter = xCenter;
        this.yCenter = yCenter;
        this.radius = radius;
        this.text = text;
    }

    public RoundWindow(int xCenter, int yCenter, int radius, String state, String text) throws WindowException {
        super(state);
        this.xCenter = xCenter;
        this.yCenter = yCenter;
        this.radius = radius;
        this.text = text;
    }

    public RoundWindow(Point center, int radius, String text) throws WindowException {
        super(WindowState.ACTIVE);
        this.xCenter = center.getX();
        this.yCenter = center.getY();
        this.radius = radius;
        this.text = text;
    }

    public RoundWindow(int xCenter, int yCenter, int radius, String text) throws WindowException {
        super(WindowState.ACTIVE);
        this.xCenter = xCenter;
        this.yCenter = yCenter;
        this.radius = radius;
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
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
        return (Math.sqrt((x - this.xCenter) * (x - this.xCenter) + (y - this.yCenter) * (y - this.xCenter)) <= this.radius);
    }

    public boolean isInside(Point point) {
        return (Math.sqrt((point.getX() - this.xCenter) * (point.getX() - this.xCenter) + (point.getY() - this.yCenter) * (point.getY() - this.xCenter)) <= this.radius);

    }

    public boolean isFullyVisibleOnDesktop(Desktop desktop) {
        return ((((xCenter - radius) >= 0) && ((xCenter + radius) < desktop.getWidth())) &&
                (((yCenter - radius) >= 0) && ((yCenter + radius) < desktop.getHeight())));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        RoundWindow that = (RoundWindow) o;
        return xCenter == that.xCenter &&
                yCenter == that.yCenter &&
                radius == that.radius &&
                text.equals(that.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), xCenter, yCenter, radius, text);
    }
}
