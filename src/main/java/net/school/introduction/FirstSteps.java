package net.school.introduction;

public class FirstSteps {
    public int sum(int x, int y) {
        return (x + y);
    }

    public int mul(int x, int y) {
        return (x * y);
    }

    public int div(int x, int y) {
        return (x / y);
    }

    public int mod(int x, int y) {
        return (x % y);
    }

    public boolean isEqual(int x, int y) {
        return x == y;
    }

    public boolean isGreater(int x, int y) {
        return x > y;
    }

    public boolean isInsideRect(int xLeft, int yTop, int xRight, int yBottom, int x, int y) {
        return (xLeft <= x) && (x <= xRight) && ((yTop <= y) && (y <= yBottom));
    }

    public int sum(int[] array) {
        int sumArray = 0;
        for (int i = 0; i < array.length; i++) {
            sumArray = sumArray + array[i];
        }
        return sumArray;
    }

    public int mul(int[] array) {
        int mulArray = 1;
        for (int i = 0; i < array.length; i++) {
            mulArray = mulArray * array[i];
        }
        if (array.length == 0) mulArray = 0;
        return mulArray;
    }

    public int min(int[] array) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (min > array[i]) min = array[i];
        }
        return min;
    }

    public int max(int[] array) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (max < array[i]) max = array[i];
        }
        return max;
    }

    public double average(int[] array) {
        double average = 0;
        int sumArray = 0;
        for (int i = 0; i < array.length; i++) {
            sumArray = sumArray + array[i];
        }
        average = 1.0 * sumArray / array.length;
        if (array.length == 0) average = 0;
        return average;
    }

    public boolean isSortedDescendant(int[] array) {
        boolean sorted = true;
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] <= array[i + 1]) {
                sorted = false;
                break;
            }
        }
        return sorted;
    }

    public void cube(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = array[i] * array[i] * array[i];
        }
    }

    public boolean find(int[] array, int value) {
        boolean find = false;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                find = true;
                break;
            }
        }
        return find;
    }

    public void reverse(int[] array) {
        int value;
        for (int i = 0; i < array.length / 2; i++) {
            value = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = value;
        }
    }

    public boolean isPalindrome(int[] array) {
        boolean palindrom = true;
        for (int i = 0; i < array.length / 2; i++) {
            if (array[i] != array[array.length - 1 - i]) {
                palindrom = false;
                break;
            }

        }
        return palindrom;
    }

    public int sum(int[][] matrix) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                sum = sum + matrix[i][j];
            }
        }
        return sum;
    }

    public int max(int[][] matrix) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (max < matrix[i][j]) max = matrix[i][j];
            }
        }
        return max;
    }

    public int diagonalMax(int[][] matrix) {
        int diagonalMax = Integer.MIN_VALUE;
        for (int i = 0; i < matrix.length; i++) {
            if (diagonalMax < matrix[i][i]) diagonalMax = matrix[i][i];
        }
        return diagonalMax;
    }

    public boolean isSortedDescendant(int[][] matrix) {

        boolean isSorted = true;
        for (int i = 0; i < matrix.length; i++) {
            if (isSortedDescendant(matrix[i]) == false) {
                isSorted = false;
                break;
            }
        }
        return isSorted;
    }
}
