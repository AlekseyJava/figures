package net.school.windows.v3.cursors;

import net.school.windows.v3.Point;
import net.school.windows.v3.iface.Movable;

public class Cursor implements Movable {
    private int x;
    private int y;
    private int cursorForm;

    public Cursor(int x, int y, int cursorForm) {
        this.x = x;
        this.y = y;
        this.cursorForm = cursorForm;
    }

    public Cursor(Point point, int cursorForm) {
        this.x = point.getX();
        this.y = point.getY();
        this.cursorForm = cursorForm;
    }

    public int getCursorForm() {
        return cursorForm;
    }

    public void setCursorForm(int cursorForm) {
        this.cursorForm = cursorForm;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void moveTo(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void moveTo(Point point) {
        moveTo(point.getX(), point.getY());
    }

    public void moveRel(int dx, int dy) {
        this.x = this.x + dx;
        this.y = this.y + dy;
    }

}
