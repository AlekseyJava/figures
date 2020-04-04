package net.school.windows.v2;

import java.util.Objects;

public class RectButton3D extends RectButton {
    private int zHeight;

    public RectButton3D(Point topLeft, Point bottomRight, boolean active, String text, int zHeight) {
        super(topLeft, bottomRight, active, text);
        this.zHeight = zHeight;
    }

    public RectButton3D(int xLeft, int yTop, int width, int height, boolean active, String text, int zHeight) {
        super(xLeft, yTop, width, height, active, text);
        this.zHeight = zHeight;
    }

    public RectButton3D(Point topLeft, Point bottomRight, String text, int zHeight) {
        super(topLeft, bottomRight, text);
        this.zHeight = zHeight;
    }

    public RectButton3D(int xLeft, int yTop, int width, int height, String text, int zHeight) {
        super(xLeft, yTop, width, height, text);
        this.zHeight = zHeight;

    }

    public Point getTopLeft() {
        return super.getTopLeft();
    }

    public Point getBottomRight() {
        return super.getBottomRight();
    }

    public boolean isActive() {
        return super.isActive();
    }

    public void setTopLeft(Point topLeft) {
        super.setTopLeft(topLeft);
    }

    public void setBottomRight(Point bottomRight) {
        super.setBottomRight(bottomRight);
    }

    public void setActive(boolean active) {
        super.setActive(active);
    }

    public int getWidth() {
        return super.getWidth();
    }

    public int getHeight() {
        return super.getHeight();
    }

    public int getZHeight() {
        return this.zHeight;
    }

    public void setZHeight(int zHeight) {
        this.zHeight = zHeight;
    }

    @Override
    public String getText() {
        return super.getText();
    }

    @Override
    public void setText(String text) {
        super.setText(text);
    }

    public void moveTo(int x, int y) {
        super.moveTo(x, y);
    }

    @Override
    public void moveTo(Point point) {
        super.moveTo(point);
    }

    @Override
    public void moveRel(int dx, int dy) {
        super.moveRel(dx, dy);
    }

    @Override
    public void resize(double ratio) {
        super.resize(ratio);
    }

    @Override
    public boolean isInside(int x, int y) {
        return super.isInside(x, y);
    }

    @Override
    public boolean isInside(Point point) {
        return super.isInside(point);
    }

    @Override
    public boolean isIntersects(RectButton rectButton) {
        return super.isIntersects(rectButton);
    }

    @Override
    public boolean isInside(RectButton rectButton) {
        return super.isInside(rectButton);
    }

    public boolean isInside(RectButton3D rectButton3D) {
        boolean status;
        RectButton rectButton = rectButton3D;
        status = super.isInside(rectButton);
        if (status && (this.zHeight >= rectButton3D.zHeight)) status = true;
        else status = false;
        return status;
    }

    @Override
    public boolean isFullyVisibleOnDesktop(Desktop desktop) {
        return super.isFullyVisibleOnDesktop(desktop);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        RectButton3D that = (RectButton3D) o;
        return zHeight == that.zHeight;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), zHeight);
    }

}
