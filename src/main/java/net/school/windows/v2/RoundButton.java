package net.school.windows.v2;

import java.util.Objects;

public class RoundButton {
    private int xCenter;
    private int yCenter;
    private int radius;
    private boolean active;
    private String text;

    public RoundButton(Point center, int radius, boolean active, String text) {
        this.xCenter = center.getX();
        this.yCenter = center.getY();
        this.radius = radius;
        this.active = active;
        this.text = text;
    }

    public RoundButton(int xCenter, int yCenter, int radius, boolean active, String text) {
        this.xCenter = xCenter;
        this.yCenter = yCenter;
        this.radius = radius;
        this.active = active;
        this.text = text;
    }

    public RoundButton(Point center, int radius, String text) {
        this.xCenter = center.getX();
        this.yCenter = center.getY();
        this.radius = radius;
        this.active = true;
        this.text = text;
    }

    public RoundButton(int xCenter, int yCenter, int radius, String text) {
        this.xCenter = xCenter;
        this.yCenter = yCenter;
        this.radius = radius;
        this.active = true;
        this.text = text;
    }

    public Point getCenter() {
        return new Point(xCenter, yCenter);
    }

    public int getRadius() {
        return this.radius;
    }

    public boolean isActive() {
        return active;
    }

    public void moveTo(int x, int y) {
        this.xCenter = x;
        this.yCenter = y;
    }

    public void moveTo(Point point) {
        this.xCenter = point.getX();
        this.yCenter = point.getY();
    }

    public void setCenter(int x, int y) {
        this.xCenter = x;
        this.yCenter = y;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public void setActive(boolean active) {
        this.active = active;
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
        RoundButton that = (RoundButton) o;
        return xCenter == that.xCenter &&
                yCenter == that.yCenter &&
                radius == that.radius &&
                active == that.active &&
                Objects.equals(text, that.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(xCenter, yCenter, radius, active, text);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
