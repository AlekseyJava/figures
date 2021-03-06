package net.school.windows.v4;

import net.school.windows.v4.base.RectWindow;
import net.school.windows.v4.base.WindowException;
import net.school.windows.v4.base.WindowState;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestRectWindow {

    @Test
    public void testRectWindow1() throws WindowException {
        Point topLeft = new Point(10, 20);
        Point bottomRight = new Point(30, 40);
        RectWindow rectWindow = new RectButton(topLeft, bottomRight, WindowState.INACTIVE, "OK");
        assertAll(
                () -> Assertions.assertEquals(10, rectWindow.getTopLeft().getX()),
                () -> Assertions.assertEquals(20, rectWindow.getTopLeft().getY()),
                () -> Assertions.assertEquals(30, rectWindow.getBottomRight().getX()),
                () -> Assertions.assertEquals(40, rectWindow.getBottomRight().getY()),
                () -> assertEquals(21, rectWindow.getWidth()),
                () -> assertEquals(21, rectWindow.getHeight())
        );
    }

    @Test
    public void testRectWindow2() throws WindowException {
        Point topLeft = new Point(10, 20);
        Point bottomRight = new Point(30, 40);
        RectWindow rectWindow = new RectButton(topLeft, bottomRight, "INACTIVE", "OK");
        assertAll(
                () -> Assertions.assertEquals(10, rectWindow.getTopLeft().getX()),
                () -> Assertions.assertEquals(20, rectWindow.getTopLeft().getY()),
                () -> Assertions.assertEquals(30, rectWindow.getBottomRight().getX()),
                () -> Assertions.assertEquals(40, rectWindow.getBottomRight().getY()),
                () -> assertEquals(21, rectWindow.getWidth()),
                () -> assertEquals(21, rectWindow.getHeight())
        );
    }

    @Test
    public void testSetRectWindow() throws WindowException {
        RectWindow rectWindow = new RectButton(10, 20, 30, 40, "OK");
        rectWindow.setTopLeft(new Point(0, 0));
        rectWindow.setBottomRight(new Point(200, 100));
        rectWindow.setState(WindowState.INACTIVE);
        assertAll(
                () -> Assertions.assertEquals(0, rectWindow.getTopLeft().getX()),
                () -> Assertions.assertEquals(0, rectWindow.getTopLeft().getY()),
                () -> Assertions.assertEquals(200, rectWindow.getBottomRight().getX()),
                () -> Assertions.assertEquals(100, rectWindow.getBottomRight().getY()),
                () -> assertEquals(201, rectWindow.getWidth()),
                () -> assertEquals(101, rectWindow.getHeight())
        );
    }

    @Test
    public void testMoveToRectWindow1() throws WindowException {
        RectWindow rectWindow = new RectButton(10, 20, 30, 40, "OK");
        rectWindow.moveTo(100, 50);
        assertAll(
                () -> Assertions.assertEquals(100, rectWindow.getTopLeft().getX()),
                () -> Assertions.assertEquals(50, rectWindow.getTopLeft().getY()),
                () -> Assertions.assertEquals(129, rectWindow.getBottomRight().getX()),
                () -> Assertions.assertEquals(89, rectWindow.getBottomRight().getY()),
                () -> assertEquals(30, rectWindow.getWidth()),
                () -> assertEquals(40, rectWindow.getHeight())
        );
    }

    @Test
    public void testMoveToRectWindow2() throws WindowException {
        RectWindow rectWindow = new RectButton(10, 20, 30, 40, "OK");
        rectWindow.moveTo(new Point(100, 50));
        assertAll(
                () -> Assertions.assertEquals(100, rectWindow.getTopLeft().getX()),
                () -> Assertions.assertEquals(50, rectWindow.getTopLeft().getY()),
                () -> Assertions.assertEquals(129, rectWindow.getBottomRight().getX()),
                () -> Assertions.assertEquals(89, rectWindow.getBottomRight().getY()),
                () -> assertEquals(30, rectWindow.getWidth()),
                () -> assertEquals(40, rectWindow.getHeight())
        );
    }

    @Test
    public void testMoveRelRectWindow() throws WindowException {
        RectWindow rectWindow = new RectButton(10, 20, 30, 40, "OK");
        rectWindow.moveRel(100, 50);
        assertAll(
                () -> Assertions.assertEquals(110, rectWindow.getTopLeft().getX()),
                () -> Assertions.assertEquals(70, rectWindow.getTopLeft().getY()),
                () -> Assertions.assertEquals(139, rectWindow.getBottomRight().getX()),
                () -> Assertions.assertEquals(109, rectWindow.getBottomRight().getY()),
                () -> assertEquals(30, rectWindow.getWidth()),
                () -> assertEquals(40, rectWindow.getHeight())
        );
    }

    @Test
    public void testIsPointInsideRectWindow1() throws WindowException {
        RectWindow rectWindow = new RectButton(10, 20, 30, 40, "OK");
        assertAll(
                () -> assertTrue(rectWindow.isInside(20, 30)),
                () -> assertTrue(rectWindow.isInside(10, 30)),
                () -> assertTrue(rectWindow.isInside(30, 30)),
                () -> assertTrue(rectWindow.isInside(10, 59)),
                () -> assertFalse(rectWindow.isInside(10, 60)),
                () -> assertFalse(rectWindow.isInside(0, 0)),
                () -> assertFalse(rectWindow.isInside(10, 100)),
                () -> assertFalse(rectWindow.isInside(-10, 20)),
                () -> assertFalse(rectWindow.isInside(10, -20))
        );
    }

    @Test
    public void testIsPointInsideRectWindow2() throws WindowException {
        RectWindow rectWindow = new RectButton(10, 20, 30, 40, "OK");
        assertAll(
                () -> assertTrue(rectWindow.isInside(new Point(20, 30))),
                () -> assertTrue(rectWindow.isInside(new Point(10, 30))),
                () -> assertTrue(rectWindow.isInside(new Point(30, 30))),
                () -> assertTrue(rectWindow.isInside(new Point(10, 59))),
                () -> assertFalse(rectWindow.isInside(new Point(10, 60))),
                () -> assertFalse(rectWindow.isInside(new Point(0, 0))),
                () -> assertFalse(rectWindow.isInside(new Point(10, 100))),
                () -> assertFalse(rectWindow.isInside(new Point(-10, 20))),
                () -> assertFalse(rectWindow.isInside(new Point(10, -20)))
        );
    }

    @Test
    public void testResizeRectWindow() throws WindowException {
        RectWindow rectWindow1 = new RectButton(10, 20, 30, 40, "OK");
        rectWindow1.resize(2);
        assertAll(
                () -> Assertions.assertEquals(10, rectWindow1.getTopLeft().getX()),
                () -> Assertions.assertEquals(20, rectWindow1.getTopLeft().getY()),
                () -> Assertions.assertEquals(69, rectWindow1.getBottomRight().getX()),
                () -> Assertions.assertEquals(99, rectWindow1.getBottomRight().getY()),
                () -> assertEquals(60, rectWindow1.getWidth()),
                () -> assertEquals(80, rectWindow1.getHeight())
        );
        RectWindow rectWindow2 = new RectButton(10, 20, 30, 40, "OK");
        rectWindow2.resize(0.5);
        assertAll(
                () -> Assertions.assertEquals(10, rectWindow2.getTopLeft().getX()),
                () -> Assertions.assertEquals(20, rectWindow2.getTopLeft().getY()),
                () -> Assertions.assertEquals(24, rectWindow2.getBottomRight().getX()),
                () -> Assertions.assertEquals(39, rectWindow2.getBottomRight().getY()),
                () -> assertEquals(15, rectWindow2.getWidth()),
                () -> assertEquals(20, rectWindow2.getHeight())
        );
        RectWindow rectWindow3 = new RectButton(10, 20, 4, 4, "OK");
        rectWindow3.resize(0.5);
        assertAll(
                () -> Assertions.assertEquals(10, rectWindow3.getTopLeft().getX()),
                () -> Assertions.assertEquals(20, rectWindow3.getTopLeft().getY()),
                () -> Assertions.assertEquals(11, rectWindow3.getBottomRight().getX()),
                () -> Assertions.assertEquals(21, rectWindow3.getBottomRight().getY()),
                () -> assertEquals(2, rectWindow3.getWidth()),
                () -> assertEquals(2, rectWindow3.getHeight())
        );
        RectWindow rectWindow4 = new RectButton(10, 20, 30, 40, "OK");
        rectWindow4.resize(0.01);
        assertAll(
                () -> Assertions.assertEquals(10, rectWindow4.getTopLeft().getX()),
                () -> Assertions.assertEquals(20, rectWindow4.getTopLeft().getY()),
                () -> Assertions.assertEquals(10, rectWindow4.getBottomRight().getX()),
                () -> Assertions.assertEquals(20, rectWindow4.getBottomRight().getY()),
                () -> assertEquals(1, rectWindow4.getWidth()),
                () -> assertEquals(1, rectWindow4.getHeight())
        );
    }

}
