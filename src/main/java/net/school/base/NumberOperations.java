package net.school.base;

import java.math.BigDecimal;
import java.math.BigInteger;

public class NumberOperations {

    public static Integer find(int[] array, int value) {
        Integer firstIndexValue = null;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                firstIndexValue = i;
                break;
            }
        }
        return firstIndexValue;
    }

    public static Integer find(double[] array, double value, double eps) {
        Integer firstIndexValue = null;
        for (int i = 0; i < array.length; i++) {
            if (Math.abs(array[i] - value) <= eps) {
                firstIndexValue = i;
                break;
            }
        }
        return firstIndexValue;
    }

    public static Double calculateDensity(double weight, double volume, double min, double max) {
        Double density = null;
        density = weight / volume;
        if ((density >= min) && (density <= max)) return density;
        else return null;
    }

    public static Integer find(BigInteger[] array, BigInteger value) {
        Integer firstIndexValue = null;
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(value)) {
                firstIndexValue = i;
                break;
            }
        }
        return firstIndexValue;
    }

    public static BigDecimal calculateDensity(BigDecimal weight, BigDecimal volume, BigDecimal min, BigDecimal max) {
        BigDecimal density = null;
        density = weight.divide(volume);
        if ((density.compareTo(min) >= 0) && (density.compareTo(max) <= 0)) return density;
        else return null;
    }

}
