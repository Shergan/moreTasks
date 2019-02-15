package com.divashchenko;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("urls.txt")));
            String line;
            while ((line = br.readLine()) != null) {
                String tmp = takeDomain(line);

                if (tmp == null) {
                    continue;
                }

                if (map.containsKey(tmp)) {
                    map.put(tmp, map.get(tmp) + 1);
                } else {
                    map.put(tmp, 1);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        for (int i = 0; i < 10; i++) {
            int max = Collections.max(map.values());
            String key = "";
            int value = 0;
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                if (entry.getValue() == max) {
                    key = entry.getKey();
                    value = entry.getValue();
                    map.remove(entry.getKey());
                    break;
                }
            }

            System.out.println(i + 1 + ". " + key + " = " + value + " times.");
        }


    }

    private static String takeDomain(String url) {
        StringBuilder sb = new StringBuilder(url.replaceFirst("^(http[s]?://www\\.|http[s]?://|www\\.)", "").trim());

        try {
            sb.delete(sb.indexOf("/"), sb.length());
            if (!(sb.charAt(0) >= 'a' && sb.charAt(0) <= 'z')) {
                return sb.toString();
            }

            int firstDot = sb.indexOf(".");
            int lastDot = sb.lastIndexOf(".");

            if (sb.substring(0, firstDot).length() < sb.substring(firstDot, lastDot).length()) {
                sb.delete(0, firstDot + 1);
            }
        } catch (Exception e) {
            return null;
        }
        return sb.toString();
    }
}
