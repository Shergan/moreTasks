package com.divashchenko;

/*2. Есть схема:
        dl.dropboxusercontent.com/s/6fnasg6j3o2chdn/crystalcell.png
        На ней 8 точек и 2 красных маркера. Каждый ход каждый из маркеров прыгает на случайную из соседних точек.
        Игра заканчивается когда оба красных маркера оказывается в одной точке.
        Вывести вероятность того что игра закончится на 1, 2...N ходу.*/

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Main {
    private static Random random = new Random();

    public static void main(String[] args) {
        chanceOfTheGame();
    }

    private static int dotGame() {

        String dotA = "twoCenter";
        String dotB = "fourCenter";
        int count = 0;

        while (!dotA.equals(dotB)) {
            dotA = whereIsDot(dotA);
            dotB = whereIsDot(dotB);
            count++;
        }

        return count;
    }

    private static String whereIsDot(String dot) {
        if (dot.equals("oneUp") || dot.equals("oneDown")) {
            return "twoCenter";
        } else if (dot.equals("twoCenter")) {
            int tmp = random.nextInt(4);
            if (tmp == 0) {
                return "oneUp";
            } else if (tmp == 1) {
                return "oneDown";
            } else if (tmp == 2) {
                return "threeUp";
            } else {
                return "threeDown";
            }
        } else if (dot.equals("threeUp") || dot.equals("threeDown")) {
            int tmp = random.nextInt(2);
            if (tmp == 0) {
                return "twoCenter";
            } else {
                return "fourCenter";
            }
        } else if (dot.equals("fourCenter")) {
            int tmp = random.nextInt(4);
            if (tmp == 0) {
                return "fiveUp";
            } else if (tmp == 1) {
                return "fiveDown";
            } else if (tmp == 2) {
                return "threeUp";
            } else {
                return "threeDown";
            }
        } else {
            return "fourCenter";
        }
    }

    private static void chanceOfTheGame() {
        int[] arr = new int[100000];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = dotGame();
        }

        Map<Integer, Integer> counts = new HashMap<>();

        for (int i : arr) {
            if (counts.containsKey(i)) {
                counts.put(i, counts.get(i) + 1);
            } else {
                counts.put(i, 1);
            }
        }

        for (int i : counts.keySet()) {
            System.out.println(i + " - " + (counts.get(i) * 100.0 / arr.length) + "%");
        }
    }
}
