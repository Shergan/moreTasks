package com.divashchenko;

/*
7. Задан круг с радиусом r с центром в точке (x,y).
Вернуть список точек с целочисленными координатами которые попадают в круг.
*/

import java.util.*;

public class Main {

    public static void main(String[] args) {

        int x = 2;
        int y = 0;
        int radius = 10;

        System.out.println(pointsToString(findPoints(x, y, radius)));

    }

    private static List<int[]> findPoints(int x, int y, int radius) {
        List<int[]> list = new ArrayList<>();

        for (int i = y; i < y + radius; i++) {
            for (int j = x; j < x + radius; j++) {
                int tmp = (int) Math.sqrt((j - x) * (j - x) + (i - y) * (i - y));
                if (tmp < radius) {
                    if (j != 0) {
                        list.add(new int[]{j, i});
                        list.add(new int[]{j - 2 * j, i});
                    }
                    if (i != 0) {
                        list.add(new int[]{j, i - 2 * i});
                        list.add(new int[]{j - 2 * j, i - 2 * i});
                    }
                    if (i == 0 && j == 0) {
                        list.add(new int[]{j, i});
                    }
                } else {
                    break;
                }
            }
        }

        return list;
    }

    private static String pointsToString(List<int[]> list) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < list.size(); i++) {
            sb.append(Arrays.toString(list.get(i)));
            sb.append(", ");
            if (i == list.size() - 2) {
                sb.append(Arrays.toString(list.get(i + 1)));
                sb.append("]");
                break;
            }
        }
        return sb.toString();
    }
}
