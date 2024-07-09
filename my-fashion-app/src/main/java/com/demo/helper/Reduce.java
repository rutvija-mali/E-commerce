package com.demo.helper;

public class Reduce {


    public static String reduceDesc(String desc) {
        if (desc == null || desc.isEmpty()) {
            return desc;
        }

        String[] words = desc.split("\\s+");
        if (words.length > 4) {
            StringBuilder res = new StringBuilder();
            for (int i = 0; i < 4; i++) {
                res.append(words[i]).append(" ");
            }
            res.append("...");
            return res.toString().trim();
        } else {
            return desc;
        }
    }
}
