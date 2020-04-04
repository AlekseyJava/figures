package net.school.windows.v1;

import java.util.Objects;

public class RectButton {
    private boolean active;
    private int xLeft;
    private int yTop;
    private int width;
    private int height;

    public RectButton(Point topLeft, Point bottomRight, boolean active) {
        this.xLeft = topLeft.getX();
        this.yTop = topLeft.getY();
        this.width = bottomRight.getX() - topLeft.getX() + 1;
        this.height = bottomRight.getY() - topLeft.getY() + 1;
        this.active = active;
    }

    public RectButton(int xLeft, int yTop, int width, int height, boolean active) {
        this.xLeft = xLeft;
        this.yTop = yTop;
        this.width = width;
        this.height = height;
        this.active = active;
    }

    public RectButton(Point topLeft, Point bottomRight) {
        this.xLeft = topLeft.getX();
        this.yTop = topLeft.getY();
        this.width = bottomRight.getX() - topLeft.getX() + 1;
        this.height = bottomRight.getY() - topLeft.getY() + 1;
        this.active = true;
    }

    public RectButton(int xLeft, int yTop, int width, int height) {
        this.xLeft = xLeft;
        this.yTop = yTop;
        this.width = width;
        this.height = height;
        this.active = true;
    }

    public Point getTopLeft() {
        return new Point(xLeft, yTop);
    }

    public Point getBottomRight() {
        return new Point(xLeft + width - 1, yTop + height - 1);
    }

    public boolean isActive() {
        return active;
    }

    public void setTopLeft(Point topLeft) {
        this.xLeft = topLeft.getX();
        this.yTop = topLeft.getY();
    }

    public void setBottomRight(Point bottomRight) {
        this.width = bottomRight.getX() - this.xLeft + 1;
        this.height = bottomRight.getY() - this.yTop + 1;
    }

    public void setActive(boolean active) {
        this.active = active;
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

    public void moveTo(Point point) {
        this.xLeft = point.getX();
        this.yTop = point.getY();
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

    //Пояснение
    //Если прямоугольники заданы так:
    //Первый:
    //(x1,y1)(x2,y1)
    //(x1,y2)(x2,y2)
    //Второй:
    //(a1,b1)(a1,b2)
    //(a2,b1)(a2,b2)
    //То простым условием их пересечения явится выражение:
    //(a1<=x1<=a2 или x1<=a1<=x2) и (b1<=y1<=b2 или y1<=b1<=y2).
    public boolean isIntersects(RectButton rectButton) {
        int x1 = xLeft;
        int y1 = yTop;
        int x2 = xLeft + width;
        int y2 = yTop + height;
        int a1 = rectButton.xLeft;
        int b1 = rectButton.yTop;
        int a2 = rectButton.xLeft + rectButton.width - 1;
        int b2 = rectButton.yTop + rectButton.height - 1;

        if ((((a1 <= x1) && (x1 <= a2)) || ((x1 <= a1) && (a1 <= x2))) &&
                (((b1 <= y1) && (y1 <= b2)) || ((y1 <= b1) && (b1 <= y2)))) return true;
        else return false;
    }

    public boolean isInside(RectButton rectButton) {
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
        RectButton that = (RectButton) o;
        return active == that.active &&
                xLeft == that.xLeft &&
                yTop == that.yTop &&
                width == that.width &&
                height == that.height;
    }

    @Override
    public int hashCode() {
        return Objects.hash(active, xLeft, yTop, width, height);
    }

}
