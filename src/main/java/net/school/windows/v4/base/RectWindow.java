package net.school.windows.v4.base;

import net.school.windows.v4.iface.Movable;
import net.school.windows.v4.Desktop;
import net.school.windows.v4.Point;
import net.school.windows.v4.iface.Resizable;

import java.util.Objects;

public abstract class RectWindow extends Window implements Movable, Resizable {
    private int xLeft;
    private int yTop;
    private int width;
    private int height;

    public RectWindow(Point topLeft, Point bottomRight, WindowState state) throws WindowException {
        super(state);
        this.xLeft = topLeft.getX();
        this.yTop = topLeft.getY();
        this.width = bottomRight.getX() - topLeft.getX() + 1;
        this.height = bottomRight.getY() - topLeft.getY() + 1;
    }

    public RectWindow(Point topLeft, Point bottomRight, String state) throws WindowException {
        super(state);
        this.xLeft = topLeft.getX();
        this.yTop = topLeft.getY();
        this.width = bottomRight.getX() - topLeft.getX() + 1;
        this.height = bottomRight.getY() - topLeft.getY() + 1;
    }

    public RectWindow(int xLeft, int yTop, int width, int height, WindowState state) throws WindowException {
        super(state);
        this.xLeft = xLeft;
        this.yTop = yTop;
        this.width = width;
        this.height = height;
    }

    public RectWindow(int xLeft, int yTop, int width, int height, String state) throws WindowException {
        super(state);
        this.xLeft = xLeft;
        this.yTop = yTop;
        this.width = width;
        this.height = height;
    }

    public RectWindow(Point topLeft, Point bottomRight) throws WindowException {
        super();
        this.xLeft = topLeft.getX();
        this.yTop = topLeft.getY();
        this.width = bottomRight.getX() - topLeft.getX() + 1;
        this.height = bottomRight.getY() - topLeft.getY() + 1;
    }

    public RectWindow(int xLeft, int yTop, int width, int height) throws WindowException {
        super();
        this.xLeft = xLeft;
        this.yTop = yTop;
        this.width = width;
        this.height = height;
    }

    public Point getTopLeft() {
        return new Point(xLeft, yTop);
    }

    public Point getBottomRight() {
        return new Point(xLeft + width - 1, yTop + height - 1);
    }

    public void setTopLeft(Point topLeft) {
        this.xLeft = topLeft.getX();
        this.yTop = topLeft.getY();
    }

    public void setBottomRight(Point bottomRight) {
        this.width = bottomRight.getX() - this.xLeft + 1;
        this.height = bottomRight.getY() - this.yTop + 1;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void moveTo(int x, int y) {
        this.xLeft = x;
        this.yTop = y;
    }

    public void moveRel(int dx, int dy) {
        this.xLeft = this.xLeft + dx;
        this.yTop = this.yTop + dy;
    }

    public void resize(double ratio) {
        width = (int) (1.0 * ratio * width);
        height = (int) (1.0 * ratio * height);
        if (width < 1) width = 1;
        if (height < 1) height = 1;
    }

    public boolean isInside(int x, int y) {
        if ((xLeft <= x) && (x <= xLeft + width - 1) && (yTop <= y) && (y <= yTop + height - 1)) return true;
        else return false;
    }

    public boolean isInside(Point point) {
        if ((xLeft <= point.getX()) && (point.getX() < xLeft + width) && (yTop <= point.getY()) && (point.getY() < yTop + height))
            return true;
        else return false;
    }

    public boolean isIntersects(RectWindow rectButton) {
        int x1 = xLeft;
        int y1 = yTop;
        int x2 = xLeft + width;
        int y2 = yTop + height;
        int a1 = rectButton.xLeft;
        int b1 = rectButton.yTop;
        int a2 = rectButton.xLeft + rectButton.width - 1;
        int b2 = rectButton.yTop + rectButton.height - 1;

        return (((a1 <= x1 && x1 <= a2) || (x1 <= a1 && a1 <= x2)) &&
                ((b1 <= y1 && y1 <= b2) || (y1 <= b1 && b1 <= y2)));
    }

    public boolean isInside(RectWindow rectButton) {
        if (((this.xLeft <= rectButton.xLeft) && ((this.xLeft + this.width) >= (rectButton.xLeft + rectButton.width))) &&
                (((this.yTop <= rectButton.yTop) && ((this.yTop + this.height) >= (rectButton.yTop + rectButton.height)))))
            return true;
        else return false;
    }

    public boolean isFullyVisibleOnDesktop(Desktop desktop) {
        if (((xLeft >= 0) && ((xLeft + width) <= desktop.getWidth())) && (yTop >= 0) && ((yTop + height) <= desktop.getHeight()))
            return true;
        else return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        RectWindow that = (RectWindow) o;
        return xLeft == that.xLeft &&
                yTop == that.yTop &&
                width == that.width &&
                height == that.height;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), xLeft, yTop, width, height);
    }
}
