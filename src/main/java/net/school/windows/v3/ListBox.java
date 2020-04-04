package net.school.windows.v3;

import java.util.Arrays;
import java.util.Objects;

public class ListBox {
    private int xLeft;
    private int yTop;
    private int width;
    private int height;
    private boolean active;
    private String[] lines;

    public ListBox(Point topLeft, Point bottomRight, boolean active, String[] lines) {
        xLeft = topLeft.getX();
        yTop = topLeft.getY();
        width = bottomRight.getX() - topLeft.getX() + 1;
        height = bottomRight.getY() - topLeft.getY() + 1;
        this.active = active;
        this.lines = new String[lines.length];
        System.arraycopy(lines, 0, this.lines, 0, lines.length);
    }

    public ListBox(int xLeft, int yTop, int width, int height, boolean active, String[] lines) {
        this.xLeft = xLeft;
        this.yTop = yTop;
        this.width = width;
        this.height = height;
        this.active = active;
        this.lines = new String[lines.length];
        System.arraycopy(lines, 0, this.lines, 0, lines.length);
    }

    public ListBox(Point topLeft, Point bottomRight, String[] lines) {
        xLeft = topLeft.getX();
        yTop = topLeft.getY();
        width = bottomRight.getX() - topLeft.getX() + 1;
        height = bottomRight.getY() - topLeft.getY() + 1;
        this.active = true;
        this.lines = new String[lines.length];
        System.arraycopy(lines, 0, this.lines, 0, lines.length);
    }

    public ListBox(int xLeft, int yTop, int width, int height, String[] lines) {
        this.xLeft = xLeft;
        this.yTop = yTop;
        this.width = width;
        this.height = height;
        this.active = true;
        if (lines == null) this.lines = null;
        else {
            this.lines = new String[lines.length];
            System.arraycopy(lines, 0, this.lines, 0, lines.length);
        }
    }

    public Point getTopLeft() {
        return new Point(xLeft, yTop);
    }

    public Point getBottomRight() {
        return new Point((xLeft + width - 1), yTop + height - 1);
    }

    public boolean isActive() {
        return active;
    }

    public void setTopLeft(Point topLeft) {
        this.xLeft = topLeft.getX();
        this.yTop = topLeft.getX();
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

    public String[] getLines() {
        return lines;
    }

    public void setLines(String[] lines) {
        if (lines == null) this.lines = null;
        else {
            this.lines = new String[lines.length];
            System.arraycopy(lines, 0, this.lines, 0, lines.length);
        }
    }

    public String[] getLinesSlice(int from, int to) {
        if (lines == null) return null;
        if (to > lines.length) to = lines.length;
        String lines[] = new String[to - from];
        int count = 0;
        for (int i = from; i < to; i++) {
            lines[count] = this.lines[i];
            count++;
        }
        return lines;
    }

    public String getLine(int index) {
        if ((index >= 0) && (index < this.lines.length)) return this.lines[index];
        else return null;
    }

    public void setLine(int index, String line) {
        lines[index] = line;
    }

    public Integer findLine(String line) {
        if (line == null) return null;
        if (lines == null) return null;
        Integer index = null;
        for (int i = 0; i < this.lines.length; i++) {
            if (lines[i].equals(line)) {
                index = i;
                break;
            }
        }
        return index;
    }

    public void reverseLineOrder() {
        if (lines == null) return;
        String[] lines1 = new String[this.lines.length];
        for (int i = 0; i < lines.length; i++) {
            lines1[i] = this.lines[i];
        }

        for (int i = 0; i < lines.length; i++) {
            lines[i] = lines1[lines1.length - i - 1];
        }
    }

    public void reverseLines() {
        if (lines == null) return;
        String[] lines1 = new String[this.lines.length];
        for (int i = 0; i < lines.length; i++) {
            lines1[i] = this.lines[i];
        }

        for (int i = 0; i < lines.length; i++) {
            StringBuilder stringBuilder = new StringBuilder(lines[i]);
            stringBuilder.reverse();
            lines[i] = stringBuilder.toString();
        }

    }

    public void duplicateLines() {
        if (lines == null) return;
        String[] lines1 = new String[lines.length * 2];
        for (int i = 0; i < lines1.length; i = i + 2) {
            lines1[i] = lines[i / 2];
            lines1[i + 1] = lines[i / 2];
        }
        lines = lines1;
    }

    public void removeOddLines() {
        if ((lines == null) || (lines.length == 1)) return;
        int lengthNewArray = 0;
        lengthNewArray = this.lines.length / 2 + this.lines.length % 2;

        String[] lines1 = new String[lengthNewArray];
        for (int i = 0; i < lengthNewArray; i++) {
            lines1[i] = this.lines[i * 2];
        }
        lines = lines1;
    }

    public boolean isSortedDescendant() {
        if (lines == null) return true;
        boolean sorted = true;
        for (int i = 0; i < lines.length - 1; i++) {
            if ((lines[i].compareTo(lines[i + 1])) < 0) {
                sorted = false;
                break;
            }
        }
        return sorted;
    }

    public void moveTo(int x, int y) {
        this.xLeft = x;
        this.yTop = y;
    }

    public void moveTo(Point point) {
        moveTo(point.getX(), point.getY());
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

        if (((x >= xLeft) && (x <= (xLeft + width - 1)) && ((y >= yTop) && (y <= (yTop + height - 1))))) return true;
        else return false;
    }

    public boolean isInside(Point point) {
        if ((xLeft <= point.getX()) && (point.getX() < xLeft + width) && (yTop <= point.getY()) && (point.getY() < yTop + height))
            return true;
        else return false;
    }

    public boolean isIntersects(ListBox listBox) {
        int x1 = xLeft;
        int y1 = yTop;
        int x2 = xLeft + width;
        int y2 = yTop + height;
        int a1 = listBox.xLeft;
        int b1 = listBox.yTop;
        int a2 = listBox.xLeft + listBox.width - 1;
        int b2 = listBox.yTop + listBox.height - 1;

        if ((((a1 <= x1) && (x1 <= a2)) || ((x1 <= a1) && (a1 <= x2))) &&
                (((b1 <= y1) && (y1 <= b2)) || ((y1 <= b1) && (b1 <= y2)))) return true;
        else return false;
    }

    public boolean isInside(ListBox listBox) {
        if (((this.xLeft <= listBox.xLeft) && ((this.xLeft + this.width) >= (listBox.xLeft + listBox.width))) &&
                (((this.yTop <= listBox.yTop) && ((this.yTop + this.height) >= (listBox.yTop + listBox.height)))))
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
        ListBox listBox = (ListBox) o;
        return xLeft == listBox.xLeft &&
                yTop == listBox.yTop &&
                width == listBox.width &&
                height == listBox.height &&
                active == listBox.active &&
                Arrays.equals(lines, listBox.lines);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(xLeft, yTop, width, height, active);
        result = 31 * result + Arrays.hashCode(lines);
        return result;
    }
}
