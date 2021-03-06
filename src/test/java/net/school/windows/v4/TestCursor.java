package net.school.windows.v4;

import net.school.windows.v4.cursors.Cursor;
import net.school.windows.v4.cursors.CursorForm;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestCursor {

    @Test
    public void testCursor1() {
        int x = 10;
        int y = 20;
        Cursor cursor = new Cursor(x, y, CursorForm.ARROW);
        assertAll(
                () -> assertEquals(10, cursor.getX()),
                () -> assertEquals(20, cursor.getY()),
                () -> assertEquals(CursorForm.ARROW, cursor.getCursorForm())
        );
    }

    @Test
    public void testCursor2() {
        Point point = new Point(10, 20);
        Cursor cursor = new Cursor(point, CursorForm.WAIT);
        assertAll(
                () -> assertEquals(10, cursor.getX()),
                () -> assertEquals(20, cursor.getY()),
                () -> assertEquals(CursorForm.WAIT, cursor.getCursorForm())
        );
    }

    @Test
    public void testSetCursor() {
        Point point = new Point(10, 20);
        Cursor cursor = new Cursor(point, CursorForm.CROSS);
        cursor.setX(100);
        cursor.setY(200);
        cursor.setCursorForm(CursorForm.HELP);
        assertAll(
                () -> assertEquals(100, cursor.getX()),
                () -> assertEquals(200, cursor.getY()),
                () -> assertEquals(CursorForm.HELP, cursor.getCursorForm())
        );
    }

    @Test
    public void testSetCursorFormToNull() {
        Point point = new Point(10, 20);
        Cursor cursor = new Cursor(point, CursorForm.UPARROW);
        cursor.setX(100);
        cursor.setY(200);
        cursor.setCursorForm(null);
        assertAll(
                () -> assertEquals(100, cursor.getX()),
                () -> assertEquals(200, cursor.getY()),
                () -> assertNull(cursor.getCursorForm())
        );
    }

    @Test
    public void testMoveCursor() {
        Point point = new Point(10, 20);
        Cursor cursor = new Cursor(point, CursorForm.HELP);
        cursor.moveTo(100, 200);
        assertAll(
                () -> assertEquals(100, cursor.getX()),
                () -> assertEquals(200, cursor.getY()),
                () -> assertEquals(CursorForm.HELP, cursor.getCursorForm())
        );
        cursor.moveTo(point);
        assertAll(
                () -> assertEquals(10, cursor.getX()),
                () -> assertEquals(20, cursor.getY())
        );
        cursor.moveRel(10, 10);
        assertAll(
                () -> assertEquals(20, cursor.getX()),
                () -> assertEquals(30, cursor.getY())
        );

    }
}
