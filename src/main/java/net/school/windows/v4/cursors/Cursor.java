package net.school.windows.v4.cursors;

import net.school.windows.v4.iface.Movable;
import net.school.windows.v4.Point;

public class Cursor implements Movable {
    private int x;
    private int y;
    private CursorForm cursorForm;

    public Cursor(int x, int y, CursorForm cursorForm) {
        this.x = x;
        this.y = y;
        this.cursorForm = cursorForm;
    }

    public Cursor(Point point, CursorForm cursorForm) {
        this.x = point.getX();
        this.y = point.getY();
        this.cursorForm = cursorForm;
    }

    public CursorForm getCursorForm() {
        return cursorForm;
    }

    public void setCursorForm(CursorForm cursorForm) {
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
