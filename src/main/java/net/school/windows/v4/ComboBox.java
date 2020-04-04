package net.school.windows.v4;

import net.school.windows.v4.base.WindowErrorCode;
import net.school.windows.v4.base.WindowException;
import net.school.windows.v4.base.WindowState;

import java.util.Objects;

public class ComboBox extends ListBox {
    private Integer selected;

    public ComboBox(Point topLeft, Point bottomRight, WindowState state, String[] lines, Integer selected) throws WindowException {
        super(topLeft, bottomRight, state, lines);
        this.selected = selected;
        if (lines == null) {
            if (selected != null) throw new WindowException(WindowErrorCode.EMPTY_ARRAY);
        }
        if (selected != null && selected > lines.length - 1) throw new WindowException(WindowErrorCode.WRONG_INDEX);
    }

    public ComboBox(Point topLeft, Point bottomRight, String state, String[] lines, Integer selected) throws WindowException {
        super(topLeft, bottomRight, state, lines);
        this.selected = selected;
        if (lines == null) {
            if (selected != null) throw new WindowException(WindowErrorCode.EMPTY_ARRAY);
        }
        if (selected != null && selected > lines.length - 1) throw new WindowException(WindowErrorCode.WRONG_INDEX);
    }

    public ComboBox(int xLeft, int yTop, int width, int height, WindowState state, String[] lines, Integer selected) throws WindowException {
        super(xLeft, yTop, width, height, state, lines);
        this.selected = selected;
        if (lines == null) {
            if (selected != null) throw new WindowException(WindowErrorCode.EMPTY_ARRAY);
        }
        if (selected != null && selected > lines.length - 1) throw new WindowException(WindowErrorCode.WRONG_INDEX);
    }

    public ComboBox(int xLeft, int yTop, int width, int height, String state, String[] lines, Integer selected) throws WindowException {
        super(xLeft, yTop, width, height, state, lines);
        this.selected = selected;
        if (lines == null) {
            if (selected != null) throw new WindowException(WindowErrorCode.EMPTY_ARRAY);
        }
        if (selected != null && selected > lines.length - 1) throw new WindowException(WindowErrorCode.WRONG_INDEX);
    }

    public ComboBox(Point topLeft, Point bottomRight, String[] lines, Integer selected) throws WindowException {
        super(topLeft, bottomRight, lines);
        this.selected = selected;
        if (lines == null) {
            if (selected != null) throw new WindowException(WindowErrorCode.EMPTY_ARRAY);
        }
        if (selected != null && selected > lines.length - 1) throw new WindowException(WindowErrorCode.WRONG_INDEX);
    }

    public ComboBox(int xLeft, int yTop, int width, int height, String[] lines, Integer selected) throws WindowException {
        super(xLeft, yTop, width, height, lines);
        this.selected = selected;
        if (lines == null) {
            if (selected != null) throw new WindowException(WindowErrorCode.EMPTY_ARRAY);
        }
        if (selected != null && (selected > lines.length - 1 || selected < 0))
            throw new WindowException(WindowErrorCode.WRONG_INDEX);
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
    public void setTopLeft(Point topLeft) {
        super.setTopLeft(topLeft);
    }

    @Override
    public void setBottomRight(Point bottomRight) {
        super.setBottomRight(bottomRight);
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
    public String[] getLines() throws WindowException {
        try {
            return super.getLines();
        } catch (NullPointerException ex) {
            return null;
        } catch (IndexOutOfBoundsException ex) {
            throw new WindowException(WindowErrorCode.WRONG_INDEX);
        }
    }

    @Override
    public void setLines(String[] lines) throws WindowException {
        super.setLines(lines);
        this.selected = null;
    }

    public Integer getSelected() {
        return selected;
    }

    public void setSelected(Integer selected) throws WindowException {
        if ((selected != null) && ((selected < 0) || (selected > getLines().length))) {
            throw new WindowException(WindowErrorCode.WRONG_INDEX);
        } else {
            this.selected = selected;
        }
    }

    @Override
    public String[] getLinesSlice(int from, int to) throws WindowException {
        return super.getLinesSlice(from, to);
    }

    @Override
    public String getLine(int index) throws WindowException {
        return super.getLine(index);
    }

    @Override
    public void setLine(int index, String line) throws WindowException {
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
