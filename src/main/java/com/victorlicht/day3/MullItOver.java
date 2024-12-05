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
            StringBuffer text = new StringBuffer();
            while (reader.hasNext()) {
                text.append(reader.next());
            }

            System.out.println("Total Sum: " + getTheTotalSum(String.valueOf(text)));
            reader.close();

        }catch (FileNotFoundException e) {
            throw new RuntimeException("Input file not found", e);
        }
    }

    // part result was very different from the code and the code is right I use another solutions of another people but it still wrong but I did it with regex101 with patternSafe Regex Good luck
    public void partTwo() {
        try {
            File file = new File("/home/victorlicht/Desktop/Technical/languages-lab/java/advent-of-code-2024/src/main/java/com/victorlicht/day3/input");
            Scanner reader = new Scanner(file);
            StringBuilder safeText = new StringBuilder(); // To accumulate text

            while (reader.hasNextLine()) {
                String text = reader.nextLine();

                // Regex to match "don't()" to "do()" or lines starting with "don't()"
                String regexSafe = "|don't\\(\\).*?\\n";
                Pattern patternSafe = Pattern.compile("don't\\(\\).*?do\\(\\)|don't\\(\\).*", Pattern.DOTALL);
                safeText.append(String.join("", patternSafe.split(text)));

            }


            // Print accumulated safeText
            System.out.println("Safe Text:\n" + safeText);

            // Print the total sum of mul instructions in safeText
            System.out.println("Total Sum: " + getTheTotalSum(String.valueOf(safeText)));

            reader.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Input file not found", e);
        }
    }


    public long getTheTotalSum(String text ){
        long totalSum = 0;
        Pattern pattern = Pattern.compile("mul\\((\\d{1,3}),(\\d{1,3})\\)");
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            long leftNum = Long.parseLong(matcher.group(1));
            long rightNum = Long.parseLong(matcher.group(2));
            totalSum += (leftNum * rightNum);
        }

        return totalSum;
    }
}
