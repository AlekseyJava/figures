package net.school.windows.v3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestRectButton {

    @Test
    public void testRectButton1() {
        Point topLeft = new Point(10, 20);
        Point bottomRight = new Point(30, 40);
        RectButton rectButton = new RectButton(topLeft, bottomRight, false, "OK");
        assertAll(
                () -> Assertions.assertEquals(10, rectButton.getTopLeft().getX()),
                () -> Assertions.assertEquals(20, rectButton.getTopLeft().getY()),
                () -> Assertions.assertEquals(30, rectButton.getBottomRight().getX()),
                () -> Assertions.assertEquals(40, rectButton.getBottomRight().getY()),
                () -> Assertions.assertEquals(21, rectButton.getWidth()),
                () -> Assertions.assertEquals(21, rectButton.getHeight()),
                () -> Assertions.assertFalse(rectButton.isActive())
        );
    }

    @Test
    public void testRectButton2() {
        RectButton rectButton = new RectButton(10, 20, 30, 40, false, "OK");
        assertAll(
                () -> Assertions.assertEquals(10, rectButton.getTopLeft().getX()),
                () -> Assertions.assertEquals(20, rectButton.getTopLeft().getY()),
                () -> Assertions.assertEquals(39, rectButton.getBottomRight().getX()),
                () -> Assertions.assertEquals(59, rectButton.getBottomRight().getY()),
                () -> Assertions.assertEquals(30, rectButton.getWidth()),
                () -> Assertions.assertEquals(40, rectButton.getHeight()),
                () -> Assertions.assertFalse(rectButton.isActive())
        );
    }

    @Test
    public void testRectButton3() {
        Point topLeft = new Point(10, 20);
        Point bottomRight = new Point(30, 40);
        RectButton rectButton = new RectButton(topLeft, bottomRight, "OK");
        assertAll(
                () -> Assertions.assertEquals(10, rectButton.getTopLeft().getX()),
                () -> Assertions.assertEquals(20, rectButton.getTopLeft().getY()),
                () -> Assertions.assertEquals(30, rectButton.getBottomRight().getX()),
                () -> Assertions.assertEquals(40, rectButton.getBottomRight().getY()),
                () -> Assertions.assertEquals(21, rectButton.getWidth()),
                () -> Assertions.assertEquals(21, rectButton.getHeight()),
                () -> Assertions.assertTrue(rectButton.isActive()),
                () -> Assertions.assertEquals("OK", rectButton.getText())

        );
    }

    @Test
    public void testRectButton4() {
        RectButton rectButton = new RectButton(10, 20, 30, 40, "OK");
        assertAll(
                () -> Assertions.assertEquals(10, rectButton.getTopLeft().getX()),
                () -> Assertions.assertEquals(20, rectButton.getTopLeft().getY()),
                () -> Assertions.assertEquals(39, rectButton.getBottomRight().getX()),
                () -> Assertions.assertEquals(59, rectButton.getBottomRight().getY()),
                () -> Assertions.assertEquals(30, rectButton.getWidth()),
                () -> Assertions.assertEquals(40, rectButton.getHeight()),
                () -> Assertions.assertTrue(rectButton.isActive()),
                () -> Assertions.assertEquals("OK", rectButton.getText())
        );
    }

    @Test
    public void testSetRectButton() {
        RectButton rectButton = new RectButton(10, 20, 30, 40, "OK");
        rectButton.setTopLeft(new Point(0, 0));
        rectButton.setBottomRight(new Point(200, 100));
        rectButton.setActive(false);
        assertAll(
                () -> Assertions.assertEquals(0, rectButton.getTopLeft().getX()),
                () -> Assertions.assertEquals(0, rectButton.getTopLeft().getY()),
                () -> Assertions.assertEquals(200, rectButton.getBottomRight().getX()),
                () -> Assertions.assertEquals(100, rectButton.getBottomRight().getY()),
                () -> Assertions.assertEquals(201, rectButton.getWidth()),
                () -> Assertions.assertEquals(101, rectButton.getHeight()),
                () -> Assertions.assertFalse(rectButton.isActive()),
                () -> Assertions.assertEquals("OK", rectButton.getText())
        );
    }

    @Test
    public void testMoveToRectButton1() {
        RectButton rectButton = new RectButton(10, 20, 30, 40, "OK");
        rectButton.moveTo(100, 50);
        assertAll(
                () -> Assertions.assertEquals(100, rectButton.getTopLeft().getX()),
                () -> Assertions.assertEquals(50, rectButton.getTopLeft().getY()),
                () -> Assertions.assertEquals(129, rectButton.getBottomRight().getX()),
                () -> Assertions.assertEquals(89, rectButton.getBottomRight().getY()),
                () -> Assertions.assertEquals(30, rectButton.getWidth()),
                () -> Assertions.assertEquals(40, rectButton.getHeight()),
                () -> Assertions.assertEquals("OK", rectButton.getText())
        );
    }

    @Test
    public void testMoveToRectButton2() {
        RectButton rectButton = new RectButton(10, 20, 30, 40, "OK");
        rectButton.moveTo(new Point(100, 50));
        assertAll(
                () -> Assertions.assertEquals(100, rectButton.getTopLeft().getX()),
                () -> Assertions.assertEquals(50, rectButton.getTopLeft().getY()),
                () -> Assertions.assertEquals(129, rectButton.getBottomRight().getX()),
                () -> Assertions.assertEquals(89, rectButton.getBottomRight().getY()),
                () -> Assertions.assertEquals(30, rectButton.getWidth()),
                () -> Assertions.assertEquals(40, rectButton.getHeight()),
                () -> Assertions.assertEquals("OK", rectButton.getText())
        );
    }

    @Test
    public void testMoveRelRectButton() {
        RectButton rectButton = new RectButton(10, 20, 30, 40, "OK");
        rectButton.moveRel(100, 50);
        assertAll(
                () -> Assertions.assertEquals(110, rectButton.getTopLeft().getX()),
                () -> Assertions.assertEquals(70, rectButton.getTopLeft().getY()),
                () -> Assertions.assertEquals(139, rectButton.getBottomRight().getX()),
                () -> Assertions.assertEquals(109, rectButton.getBottomRight().getY()),
                () -> Assertions.assertEquals(30, rectButton.getWidth()),
                () -> Assertions.assertEquals(40, rectButton.getHeight()),
                () -> Assertions.assertEquals("OK", rectButton.getText())
        );
    }

    @Test
    public void testResizeRectButton() {
        RectButton rectButton1 = new RectButton(10, 20, 30, 40, "OK");
        rectButton1.resize(2);
        assertAll(
                () -> Assertions.assertEquals(10, rectButton1.getTopLeft().getX()),
                () -> Assertions.assertEquals(20, rectButton1.getTopLeft().getY()),
                () -> Assertions.assertEquals(69, rectButton1.getBottomRight().getX()),
                () -> Assertions.assertEquals(99, rectButton1.getBottomRight().getY()),
                () -> Assertions.assertEquals(60, rectButton1.getWidth()),
                () -> Assertions.assertEquals(80, rectButton1.getHeight())
        );
        RectButton rectButton2 = new RectButton(10, 20, 30, 40, "OK");
        rectButton2.resize(0.5);
        assertAll(
                () -> Assertions.assertEquals(10, rectButton2.getTopLeft().getX()),
                () -> Assertions.assertEquals(20, rectButton2.getTopLeft().getY()),
                () -> Assertions.assertEquals(24, rectButton2.getBottomRight().getX()),
                () -> Assertions.assertEquals(39, rectButton2.getBottomRight().getY()),
                () -> Assertions.assertEquals(15, rectButton2.getWidth()),
                () -> Assertions.assertEquals(20, rectButton2.getHeight())
        );
        RectButton rectButton3 = new RectButton(10, 20, 4, 4, "OK");
        rectButton3.resize(0.5);
        assertAll(
                () -> Assertions.assertEquals(10, rectButton3.getTopLeft().getX()),
                () -> Assertions.assertEquals(20, rectButton3.getTopLeft().getY()),
                () -> Assertions.assertEquals(11, rectButton3.getBottomRight().getX()),
                () -> Assertions.assertEquals(21, rectButton3.getBottomRight().getY()),
                () -> Assertions.assertEquals(2, rectButton3.getWidth()),
                () -> Assertions.assertEquals(2, rectButton3.getHeight())
        );
        RectButton rectButton4 = new RectButton(10, 20, 30, 40, "OK");
        rectButton4.resize(0.01);
        assertAll(
                () -> Assertions.assertEquals(10, rectButton4.getTopLeft().getX()),
                () -> Assertions.assertEquals(20, rectButton4.getTopLeft().getY()),
                () -> Assertions.assertEquals(10, rectButton4.getBottomRight().getX()),
                () -> Assertions.assertEquals(20, rectButton4.getBottomRight().getY()),
                () -> Assertions.assertEquals(1, rectButton4.getWidth()),
                () -> Assertions.assertEquals(1, rectButton4.getHeight())
        );
    }

    @Test
    public void testIsPointInsideRectButton1() {
        RectButton rectButton = new RectButton(10, 20, 30, 40, "OK");
        assertAll(
                () -> Assertions.assertTrue(rectButton.isInside(20, 30)),
                () -> Assertions.assertTrue(rectButton.isInside(10, 30)),
                () -> Assertions.assertTrue(rectButton.isInside(30, 30)),
                () -> Assertions.assertTrue(rectButton.isInside(10, 59)),
                () -> Assertions.assertFalse(rectButton.isInside(10, 60)),
                () -> Assertions.assertFalse(rectButton.isInside(0, 0)),
                () -> Assertions.assertFalse(rectButton.isInside(10, 100)),
                () -> Assertions.assertFalse(rectButton.isInside(-10, 20)),
                () -> Assertions.assertFalse(rectButton.isInside(10, -20))
        );
    }

    @Test
    public void testIsPointInsideRectButton2() {
        RectButton rectButton = new RectButton(10, 20, 30, 40, "OK");
        assertAll(
                () -> Assertions.assertTrue(rectButton.isInside(new Point(20, 30))),
                () -> Assertions.assertTrue(rectButton.isInside(new Point(10, 30))),
                () -> Assertions.assertTrue(rectButton.isInside(new Point(30, 30))),
                () -> Assertions.assertTrue(rectButton.isInside(new Point(10, 59))),
                () -> Assertions.assertFalse(rectButton.isInside(new Point(10, 60))),
                () -> Assertions.assertFalse(rectButton.isInside(new Point(0, 0))),
                () -> Assertions.assertFalse(rectButton.isInside(new Point(10, 100))),
                () -> Assertions.assertFalse(rectButton.isInside(new Point(-10, 20))),
                () -> Assertions.assertFalse(rectButton.isInside(new Point(10, -20)))
        );
    }

    @Test
    public void testIsIntersectsRectButton() {
        RectButton rectButton = new RectButton(10, 20, 30, 40, "OK");
        assertAll(
                () -> Assertions.assertTrue(rectButton.isIntersects(new RectButton(15, 25, 25, 35, "OK"))),
                () -> Assertions.assertTrue(rectButton.isIntersects(new RectButton(-10, 20, 30, 40, "OK"))),
                () -> Assertions.assertTrue(rectButton.isIntersects(new RectButton(10, 20, 50, 40, "OK"))),
                () -> Assertions.assertTrue(rectButton.isIntersects(new RectButton(-10, 20, 50, 40, "OK"))),
                () -> Assertions.assertTrue(rectButton.isIntersects(new RectButton(10, -20, 30, 41, "OK"))),
                () -> Assertions.assertFalse(rectButton.isIntersects(new RectButton(10, -20, 30, 40, "OK"))),
                () -> Assertions.assertTrue(rectButton.isIntersects(new RectButton(10, 20, 30, 60, "OK"))),
                () -> Assertions.assertTrue(rectButton.isIntersects(new RectButton(-10, -20, 50, 60, "OK"))),
                () -> Assertions.assertTrue(rectButton.isIntersects(new RectButton(0, 10, 20, 30, "OK"))),
                () -> Assertions.assertTrue(rectButton.isIntersects(new RectButton(20, 30, 40, 50, "OK"))),
                () -> Assertions.assertFalse(rectButton.isIntersects(new RectButton(-40, 20, -30, 40, "OK"))),
                () -> Assertions.assertFalse(rectButton.isIntersects(new RectButton(110, 120, 30, 40, "OK"))),
                () -> Assertions.assertFalse(rectButton.isIntersects(new RectButton(10, 120, 30, 40, "OK"))),
                () -> Assertions.assertFalse(rectButton.isIntersects(new RectButton(10, -40, 30, 20, "OK"))),
                () -> Assertions.assertTrue(rectButton.isIntersects(new RectButton(15, 15, 25, 50, "OK")))
        );
    }

    @Test
    public void testIsRectButtonInsideRectButton() {
        RectButton rectButton = new RectButton(10, 20, 30, 40, "OK");
        assertAll(
                () -> Assertions.assertTrue(rectButton.isInside(new RectButton(15, 25, 25, 35, "OK"))),
                () -> Assertions.assertFalse(rectButton.isInside(new RectButton(-40, 20, 30, 40, "OK"))),
                () -> Assertions.assertFalse(rectButton.isInside(new RectButton(110, 120, 130, 140, "OK"))),
                () -> Assertions.assertFalse(rectButton.isInside(new RectButton(10, 120, 30, 40, "OK"))),
                () -> Assertions.assertFalse(rectButton.isInside(new RectButton(10, -40, 30, 20, "OK")))
        );
    }

    @Test
    public void testIsFullyVisibleOnDesktop() {
        Desktop desktop = new Desktop();
        assertAll(
                () -> Assertions.assertTrue(new RectButton(15, 25, 25, 35, "OK").isFullyVisibleOnDesktop(desktop)),
                () -> Assertions.assertTrue(new RectButton(0, 0, 639, 479, "OK").isFullyVisibleOnDesktop(desktop)),
                () -> Assertions.assertFalse(new RectButton(200, 200, 640, 480, "OK").isFullyVisibleOnDesktop(desktop)),
                () -> Assertions.assertFalse(new RectButton(-200, -200, 640, 480, "OK").isFullyVisibleOnDesktop(desktop)),
                () -> Assertions.assertFalse(new RectButton(-1200, 700, 1199, 480, "OK").isFullyVisibleOnDesktop(desktop)),
                () -> Assertions.assertFalse(new RectButton(200, -200, 100, 100, "OK").isFullyVisibleOnDesktop(desktop)),
                () -> Assertions.assertTrue(new RectButton(200, 300, 100, 100, "OK").isFullyVisibleOnDesktop(desktop)),
                () -> Assertions.assertFalse(new RectButton(200, 700, 100, 100, "OK").isFullyVisibleOnDesktop(desktop))
        );
    }

    @Test
    public void testRectButtonsAreEqual() {
        RectButton rectButton1 = new RectButton(10, 20, 30, 40, "OK");
        RectButton rectButton2 = new RectButton(10, 20, 30, 40, "OK");
        RectButton rectButton3 = new RectButton(20, 30, 40, 50, "OK");
        RectButton rectButton4 = new RectButton(20, 30, 40, 50, "Cancel");
        assertNotEquals(rectButton1, null);
        assertEquals(rectButton1, rectButton1);
        assertNotEquals(rectButton1, null);
        assertEquals(rectButton1, rectButton2);
        assertNotEquals(rectButton1, rectButton3);
        assertNotEquals(rectButton1, rectButton4);
    }

    @Test
    public void testRectButtonSetText() {
        RectButton rectButton = new RectButton(10, 20, 30, 40, "OK");
        rectButton.setText("Cancel");
        Assertions.assertEquals("Cancel", rectButton.getText());
    }
}
