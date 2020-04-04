package net.school.windows.v4;

import net.school.windows.v4.base.RectWindow;
import net.school.windows.v4.base.WindowErrorCode;
import net.school.windows.v4.base.WindowException;
import net.school.windows.v4.base.WindowState;

import java.util.Arrays;

public class ListBox extends RectWindow {
    private String[] lines;

    public ListBox(Point topLeft, Point bottomRight, WindowState state, String[] lines) throws WindowException {
        super(topLeft, bottomRight, state);
        try {
            this.lines = new String[lines.length];
            System.arraycopy(lines, 0, this.lines, 0, lines.length);
        } catch (NullPointerException ex) {
            System.out.println(WindowErrorCode.WRONG_STATE);
        }
    }

    public ListBox(Point topLeft, Point bottomRight, String state, String[] lines) throws WindowException {
        super(topLeft, bottomRight, state);
        try {
            this.lines = new String[lines.length];
            System.arraycopy(lines, 0, this.lines, 0, lines.length);
        } catch (NullPointerException ex) {
            throw new WindowException(WindowErrorCode.WRONG_STATE);
        }
    }

    public ListBox(int xLeft, int yTop, int width, int height, WindowState state, String[] lines) throws WindowException {
        super(xLeft, yTop, width, height, state);
        try {
            this.lines = new String[lines.length];
            System.arraycopy(lines, 0, this.lines, 0, lines.length);
        } catch (NullPointerException ex) {
            throw new WindowException(WindowErrorCode.WRONG_STATE);
        }
    }

    public ListBox(int xLeft, int yTop, int width, int height, String state, String[] lines) throws WindowException {
        super(xLeft, yTop, width, height, state);
        try {
            this.lines = new String[lines.length];
            System.arraycopy(lines, 0, this.lines, 0, lines.length);
        } catch (NullPointerException ex) {
            throw new WindowException(WindowErrorCode.WRONG_STATE);
        }
    }

    public ListBox(Point topLeft, Point bottomRight, String[] lines) throws WindowException {
        super(topLeft, bottomRight);
        try {
            this.lines = new String[lines.length];
            System.arraycopy(lines, 0, this.lines, 0, lines.length);
        } catch (NullPointerException ex) {
            System.out.println(WindowErrorCode.WRONG_STATE);
        }
    }

    public ListBox(int xLeft, int yTop, int width, int height, String[] lines) throws WindowException {
        super(xLeft, yTop, width, height);
        try {
            this.lines = new String[lines.length];
            System.arraycopy(lines, 0, this.lines, 0, lines.length);
        } catch (NullPointerException ex) {
            //throw new WindowException(WindowErrorCode.WRONG_STATE);
            System.out.println(WindowErrorCode.WRONG_STATE);
        }
    }

    public String[] getLines() throws WindowException {
        try {
            return lines;
        } catch (NullPointerException ex) {
            throw new WindowException(WindowErrorCode.EMPTY_ARRAY);
        } catch (IndexOutOfBoundsException ex) {
            throw new WindowException(WindowErrorCode.WRONG_INDEX);
        }
    }

    public void setLines(String[] lines) throws WindowException {
        if (lines == null) this.lines = null;
        else {
            this.lines = new String[lines.length];
            System.arraycopy(lines, 0, this.lines, 0, lines.length);
        }
    }

    public String[] getLinesSlice(int from, int to) throws WindowException {
        String[] lines = new String[to - from];
        if (from > to - 1) {
            throw new WindowException(WindowErrorCode.WRONG_INDEX);
        } else {
            try {
                int count = 0;
                for (int i = from; i < to; i++) {
                    lines[count] = this.lines[i];
                    count++;
                }
            } catch (NullPointerException ex) {
                throw new WindowException(WindowErrorCode.EMPTY_ARRAY);
            } catch (IndexOutOfBoundsException ex) {
                throw new WindowException(WindowErrorCode.WRONG_INDEX);
            }
            return lines;
        }
    }

    public String getLine(int index) throws WindowException {
        try {
            return lines[index];
        } catch (IndexOutOfBoundsException ex) {
            throw new WindowException(WindowErrorCode.WRONG_INDEX);
        } catch (NullPointerException ex) {
            throw new WindowException(WindowErrorCode.EMPTY_ARRAY);
        }
    }

    public void setLine(int index, String line) throws WindowException {
        try {
            lines[index] = line;
        } catch (NullPointerException ex) {
            throw new WindowException(WindowErrorCode.EMPTY_ARRAY);
        } catch (IndexOutOfBoundsException ex) {
            throw new WindowException(WindowErrorCode.WRONG_INDEX);
        }
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ListBox listBox = (ListBox) o;
        return Arrays.equals(lines, listBox.lines);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Arrays.hashCode(lines);
        return result;
    }
}
