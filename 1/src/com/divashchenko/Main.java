
package com.divashchenko;

/*
1. Написать класс для работы с длинными числами которые заданы как String.
Реализовать оснонвые операции: +,-,/,*,%, корень квадратный, возведение в степень, округление.
Пример:
String result = LongArithmetic.add("234234.45", "-345345345.6756");
*/

public class Main {

    public static void main(String[] args) {

        String result = LongArithmetic.add("234234234234277772385684932579754534234234.45", "-3453123187745452313245345.6756");
        System.out.println(result);

        result = LongArithmetic.del("21241241241241172.8", "-8234634634634691.274");
        System.out.println(result);

        result = LongArithmetic.division("8510214764723.901748", "218878724887874.271");
        System.out.println(result);

        result = LongArithmetic.multiply("34723455323", "2371832.23871");
        System.out.println(result);

        result = LongArithmetic.euclideanDivision("87643646347347332234241298.238", "232453453535276182");
        System.out.println(result);

        result = LongArithmetic.squareRoot("1298374827349861964778263498619364297346872824027.238712");
        System.out.println(result);

        result = LongArithmetic.exponentiation("2512983749232", "5");
        System.out.println(result);

        result = LongArithmetic.rounding("2718872928748462.58261987526958736897432645823626");
        System.out.println(result);

        result = LongArithmetic.add("daf", "2943897257389452513"); // Error!
        System.out.println(result);
    }
}