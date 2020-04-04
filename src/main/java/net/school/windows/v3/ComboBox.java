package net.school.windows.v3;

import java.util.Objects;

public class ComboBox extends ListBox {
    private Integer selected;

    public ComboBox(Point topLeft, Point bottomRight, boolean active, String[] lines, Integer selected) {
        super(topLeft, bottomRight, active, lines);
        this.selected = selected;
    }

    public ComboBox(int xLeft, int yTop, int width, int height, boolean active, String[] lines, Integer selected) {
        super(xLeft, yTop, width, height, active, lines);
        this.selected = selected;
    }

    public ComboBox(Point topLeft, Point bottomRight, String[] lines, Integer selected) {
        super(topLeft, bottomRight, lines);
        this.selected = selected;
    }

    public ComboBox(int xLeft, int yTop, int width, int height, String[] lines, Integer selected) {
        super(xLeft, yTop, width, height, lines);
        this.selected = selected;
    }

    @Override
    public Point getTopLeft() {
        return super.getTopLeft();
    }

    @Override
    public Point getBottomRight() {
        return super.getBottomRight();
    }

    @Override
    public boolean isActive() {
        return super.isActive();
    }

    @Override
    public void setTopLeft(Point topLeft) {
        super.setTopLeft(topLeft);
    }

    @Override
    public void setBottomRight(Point bottomRight) {
        super.setBottomRight(bottomRight);
    }

    @Override
    public void setActive(boolean active) {
        super.setActive(active);
    }

    @Override
    public int getWidth() {
        return super.getWidth();
    }

    @Override
    public int getHeight() {
        return super.getHeight();
    }

    @Override
    public String[] getLines() {
        return super.getLines();
    }

    @Override
    public void setLines(String[] lines) {
        super.setLines(lines);
    }

    public Integer getSelected() {
        return selected;
    }

    public void setSelected(Integer selected) {
        this.selected = selected;
    }

    @Override
    public String[] getLinesSlice(int from, int to) {
        return super.getLinesSlice(from, to);
    }

    @Override
    public String getLine(int index) {
        return super.getLine(index);
    }

    @Override
    public void setLine(int index, String line) {
        super.setLine(index, line);
    }

    @Override
    public Integer findLine(String line) {
        return super.findLine(line);
    }

    @Override
    public void reverseLineOrder() {
        super.reverseLineOrder();
    }

    @Override
    public void reverseLines() {
        super.reverseLines();
    }

    @Override
    public void duplicateLines() {
        super.duplicateLines();
    }

    @Override
    public void removeOddLines() {
        super.removeOddLines();
    }

    @Override
    public boolean isSortedDescendant() {
        return super.isSortedDescendant();
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

    public boolean isIntersects(ComboBox comboBox) {
        return super.isIntersects(comboBox);
    }

    public boolean isInside(ComboBox comboBox) {
        return super.isInside(comboBox);
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
        ComboBox comboBox = (ComboBox) o;
        return selected.equals(comboBox.selected);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), selected);
    }

}
