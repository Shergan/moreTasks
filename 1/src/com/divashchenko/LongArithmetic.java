package com.divashchenko;

import java.math.BigDecimal;

public class LongArithmetic {

    public static String add(String str1, String str2) {
        if (!checkStringForNumbers(str1, str2)) {
            return "Error!";
        }
        return doubleToString(new BigDecimal(str1).add(new BigDecimal(str2)));
    }

    public static String del(String str1, String str2) {
        if (!checkStringForNumbers(str1, str2)) {
            return "Error!";
        }
        return doubleToString(new BigDecimal(str1).subtract(new BigDecimal(str2)));
    }

    public static String division(String str1, String str2) {
        if (!checkStringForNumbers(str1, str2)) {
            return "Error!";
        }
        try {
            if (Double.parseDouble(str2) == 0) {
                throw new Exception("Division is impossible!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return doubleToString(new BigDecimal(str1).divide(new BigDecimal(str2), BigDecimal.ROUND_DOWN));
    }

    public static String multiply(String str1, String str2) {
        if (!checkStringForNumbers(str1, str2)) {
            return "Error!";
        }
        return doubleToString(new BigDecimal(str1).multiply(new BigDecimal(str2)));
    }

    public static String euclideanDivision(String str1, String str2) {
        if (!checkStringForNumbers(str1, str2)) {
            return "Error!";
        }
        BigDecimal left = new BigDecimal(str1);
        BigDecimal right = new BigDecimal(str2);

        BigDecimal[] bigDecimals = left.divideAndRemainder(right);

        return doubleToString(bigDecimals[1]);
    }

    public static String squareRoot(String str) {
        if (!checkStringForNumbers(str)) {
            return "Error!";
        }
        int scale = 50;
        BigDecimal strBig = new BigDecimal(str);
        BigDecimal a = new BigDecimal("0");
        BigDecimal b = new BigDecimal(Math.sqrt(strBig.doubleValue()));
        BigDecimal two = BigDecimal.valueOf(2);

        while (!a.equals(b)) {
            a = b;
            b = strBig.divide(a, scale, BigDecimal.ROUND_HALF_UP);
            b = b.add(a);
            b = b.divide(two, scale, BigDecimal.ROUND_HALF_UP);
        }
        return doubleToString(b);
    }

    public static String exponentiation(String str1, String str2) {
        if (!checkStringForNumbers(str1, str2)) {
            return "Error!";
        }
        if (str2.charAt(0) == '0') {
            return "1";
        } else {
            int tmpInt = Integer.parseInt(str2);
            return doubleToString(new BigDecimal(str1).pow(tmpInt));
        }
    }

    public static String rounding(String str) {
        if (!checkStringForNumbers(str)) {
            return "Error!";
        }
        return doubleToString(new BigDecimal(str).setScale(0, BigDecimal.ROUND_HALF_EVEN));
    }

    private static boolean checkStringForNumbers(String str) {
        try {
            BigDecimal d = new BigDecimal(str);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    private static boolean checkStringForNumbers(String str1, String str2) {
        try {
            BigDecimal dStr1 = new BigDecimal(str1);
            BigDecimal dStr2 = new BigDecimal(str2);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    private static String doubleToString(BigDecimal number) {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("%f", number));

        for (int i = sb.length() - 1; i > 1; i--) {
            if (sb.charAt(i) == '0' && sb.charAt(i - 1) != ',') {
                sb.deleteCharAt(i);
            } else {
                break;
            }
        }

        return sb.toString();
    }
}