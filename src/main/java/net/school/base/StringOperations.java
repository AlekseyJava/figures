package net.school.base;

public class StringOperations {
    public static int getSummaryLength(String[] strings) {
        int lenght = 0;
        for (String s : strings) {
            lenght = lenght + s.length();
        }
        return lenght;
    }

    public static String getFirstAndLastLetterString(String string) {
        return string.substring(0, 1) + string.substring(string.length() - 1);
    }

    public static boolean isSameCharAtPosition(String string1, String string2, int index) {
        return string1.charAt(index) == string2.charAt(index);
    }

    public static boolean isSameFirstCharPosition(String string1, String string2, char character) {
        return string1.indexOf(character) == string2.indexOf(character);
    }

    public static boolean isSameLastCharPosition(String string1, String string2, char character) {
        return string1.lastIndexOf(character) == string2.lastIndexOf(character);
    }

    public static boolean isSameFirstStringPosition(String string1, String string2, String str) {
        return (string1.indexOf(str)) == (string2.indexOf(str));
    }

    public static boolean isSameLastStringPosition(String string1, String string2, String str) {
        return (string1.lastIndexOf(str) == (string2.lastIndexOf(str)));
    }

    public static boolean isEqual(String string1, String string2) {
        if (string1.equals(string2)) return true;
        else return false;
    }

    public static boolean isEqualIgnoreCase(String string1, String string2) {
        if (string1.toLowerCase().equals(string2.toLowerCase())) return true;
        else return false;
    }

    public static boolean isLess(String string1, String string2) {
        if (string1.compareTo(string2) < 0) return true;
        else return false;
    }

    public static boolean isLessIgnoreCase(String string1, String string2) {
        if (string1.toLowerCase().compareTo(string2.toLowerCase()) < 0) return true;
        else return false;
    }

    public static String concat(String string1, String string2) {
        return string1.concat(string2);
    }

    public static boolean isSamePrefix(String string1, String string2, String prefix) {
        return (string1.indexOf(prefix) == 0) && (string2.indexOf(prefix) == 0);
    }

    public static boolean isSameSuffix(String string1, String string2, String suffix) {
        return (string1.endsWith(suffix)) && (string2.endsWith(suffix));
    }

    public static String getCommonPrefix(String string1, String string2) {
        StringBuilder stringBuilder = new StringBuilder("");
        int length = 0;
        if (string1.length() <= string2.length()) length = string1.length();
        else length = string2.length();
        for (int i = 0; i < length; i++) {
            if (string1.charAt(i) == string2.charAt(i)) {
                stringBuilder.append(string1.charAt(i));
            } else break;
        }
        return stringBuilder.toString();
    }

    public static String reverse(String string) {
        String reverse = new StringBuilder(string).reverse().toString();
        return reverse;
    }

    public static boolean isPalindrome(String string) {
        String reverse = new StringBuilder(string).reverse().toString();
        if (string.equals(reverse)) return true;
        else return false;
    }

    public static boolean isPalindromeIgnoreCase(String string) {
        String reverse = new StringBuilder(string).reverse().toString();
        if (string.toLowerCase().equals(reverse.toLowerCase())) return true;
        else return false;
    }

    public static String getLongestPalindromeIgnoreCase(String[] strings) {
        String MaxPolindrom = "";
        StringBuilder stringBuilder = new StringBuilder("");
        int maxSymbols = 0;
        for (String s : strings) {
            if (isPalindromeIgnoreCase(s)) {
                if (s.length() > maxSymbols) {
                    maxSymbols = s.length();
                    MaxPolindrom = s;
                }
            }
        }
        return MaxPolindrom;
    }

    public static boolean hasSameSubstring(String string1, String string2, int index, int length) {
        if ((string1.length() < (index + length)) || ((string2.length() < (index + length)))) return false;
        return (string1.substring(index, index + length)).equals(string2.substring(index, index + length));
    }

    public static boolean isEqualAfterReplaceCharacters(String string1, char replaceInStr1, char replaceByInStr1, String string2, char replaceInStr2, char replaceByInStr2) {
        return (string1.replace(replaceInStr1, replaceByInStr1)).equals((string2.replace(replaceInStr2, replaceByInStr2)));
    }

    public static boolean isEqualAfterReplaceStrings(String string1, String replaceInStr1, String replaceByInStr1, String string2, String replaceInStr2, String replaceByInStr2) {
        return (string1.replace(replaceInStr1, replaceByInStr1)).equals((string2.replace(replaceInStr2, replaceByInStr2)));
    }

    public static boolean isPalindromeAfterRemovingSpacesIgnoreCase(String string) {

        StringBuilder stringBuilder = new StringBuilder(string.replace(" ", ""));
        StringBuilder reverse = new StringBuilder(stringBuilder);
        reverse.reverse();
        if (stringBuilder.toString().toLowerCase().equals(reverse.toString().toLowerCase())) return true;
        else return false;
    }

    public static boolean isEqualAfterTrimming(String string1, String string2) {
        return (string1.trim()).equals(string2.trim());
    }

    public static String makeCsvStringFromInts(int[] array) {
        StringBuilder stringBuilder = new StringBuilder("");
        if (array.length == 0) return "";
        for (int i = 0; i < array.length - 1; i++) {
            stringBuilder.append(array[i]);
            stringBuilder.append(",");
        }
        stringBuilder.append(array[array.length - 1]);
        return stringBuilder.toString();
    }

    public static String makeCsvStringFromDoubles(double[] array) {
        StringBuilder stringBuilder = new StringBuilder("");
        if (array.length == 0) return "";
        for (int i = 0; i < array.length - 1; i++) {
            stringBuilder.append(String.format("%.2f", array[i]));
            stringBuilder.append(",");
        }
        stringBuilder.append(String.format("%.2f", array[array.length - 1]));
        return stringBuilder.toString();
    }

    public static StringBuilder makeCsvStringBuilderFromInts(int[] array) {
        StringBuilder stringBuilder = new StringBuilder("");
        if (array.length == 0) return stringBuilder;
        for (int i = 0; i < array.length - 1; i++) {
            stringBuilder.append(array[i]);
            stringBuilder.append(",");
        }
        stringBuilder.append(array[array.length - 1]);
        return stringBuilder;
    }

    public static StringBuilder makeCsvStringBuilderFromDoubles(double[] array) {
        StringBuilder stringBuilder = new StringBuilder("");
        if (array.length == 0) return stringBuilder;
        for (int i = 0; i < array.length - 1; i++) {
            stringBuilder.append(String.format("%.2f", array[i]));
            stringBuilder.append(",");
        }
        stringBuilder.append(String.format("%.2f", array[array.length - 1]));
        return stringBuilder;
    }

    public static StringBuilder removeCharacters(String string, int[] positions) {
        StringBuilder stringBuilder = new StringBuilder(string);
        for (int i = positions.length - 1; i >= 0; i--) {
            stringBuilder.deleteCharAt(positions[i]);
        }
        return stringBuilder;
    }

    public static StringBuilder insertCharacters(String string, int[] positions, char[] characters) {
        StringBuilder stringBuilder = new StringBuilder(string);
        for (int i = positions.length - 1; i >= 0; i--) {
            stringBuilder.insert(positions[i], characters[i]);
        }
        return stringBuilder;
    }

}
