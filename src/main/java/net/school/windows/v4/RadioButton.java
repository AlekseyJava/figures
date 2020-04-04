package net.school.windows.v4;

import net.school.windows.v4.base.WindowException;
import net.school.windows.v4.base.WindowState;

import java.util.Objects;

public class RadioButton extends RoundButton {
    private boolean checked;

    public RadioButton(Point center, int radius, WindowState state, String text, boolean checked) throws WindowException {
        super(center, radius, state, text);
        this.checked = checked;
    }

    public RadioButton(Point center, int radius, String state, String text, boolean checked) throws WindowException {
        super(center, radius, state, text);
        this.checked = checked;
    }

    public RadioButton(int xCenter, int yCenter, int radius, WindowState state, String text, boolean checked) throws WindowException {
        super(xCenter, yCenter, radius, state, text);
        this.checked = checked;
    }

    public RadioButton(int xCenter, int yCenter, int radius, String state, String text, boolean checked) throws WindowException {
        super(xCenter, yCenter, radius, state, text);
        this.checked = checked;
    }

    public RadioButton(Point center, int radius, String text, boolean checked) throws WindowException {
        super(center, radius, text);
        this.checked = checked;
    }

    public RadioButton(int xCenter, int yCenter, int radius, String text, boolean checked) throws WindowException {
        super(xCenter, yCenter, radius, text);
        this.checked = checked;
    }

    public Point getCenter() {
        return super.getCenter();
    }

    public int getRadius() {
        return super.getRadius();
    }

    public boolean isChecked() {
        return checked;
    }

    @Override
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

    public void setCenter(Point center) {
        super.setCenter(center.getX(), center.getY());
    }

    @Override
    public void setRadius(int radius) {
        super.setRadius(radius);
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
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
    public boolean isFullyVisibleOnDesktop(Desktop desktop) {
        return super.isFullyVisibleOnDesktop(desktop);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        RadioButton that = (RadioButton) o;
        return checked == that.checked;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), checked);
    }
}
