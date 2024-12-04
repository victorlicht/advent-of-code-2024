package com.victorlicht.day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MullItOver {
    public void partOne() {
        try {
            File file = new File("/home/victorlicht/Desktop/Technical/languages-lab/java/advent-of-code-2024/src/main/java/com/victorlicht/day3/input");
            Scanner reader = new Scanner(file);
            int totalSum = 0;
            while (reader.hasNext()) {
                String text = reader.next();
                String regex = "mul\\((\\d{1,3}),(\\d{1,3})\\)";
                Pattern pattern = Pattern.compile(regex);
                Matcher matcher = pattern.matcher(text);
                while (matcher.find()) {
                    int leftNum = Integer.parseInt(matcher.group(1));
                    int rightNum = Integer.parseInt(matcher.group(2));
                    totalSum += (leftNum * rightNum);
                }
            }
            System.out.println("Total Sum: " + totalSum);
            reader.close();

        }catch (FileNotFoundException e) {
            throw new RuntimeException("Input file not found", e);
        }
    }
    public void partTwo() {

    }
}
