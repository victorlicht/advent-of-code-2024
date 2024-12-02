package com.victorlicht.day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class HistorianHysteria {
    public void PartOne() {
        try {
            File file = new File("/home/victorlicht/Desktop/Technical/languages-lab/java/advent-of-code-2024/src/main/java/com/victorlicht/day1/input");
            Scanner reader = new Scanner(file);

            int[] rightLocations = new int[6];
            int[] leftLocations = new int[6];

            int sum = 0;
            int i = 0;
            while (reader.hasNextLine()) {

                StringBuilder data = new StringBuilder(reader.nextLine());
                rightLocations[i] = Integer.parseInt(data.substring(4, 5));
                leftLocations[i] = Integer.parseInt(data.substring(0, 1));
                i++;
            }
            reader.close();
            Arrays.sort(rightLocations);
            Arrays.sort(leftLocations);
            for (i = 0; i < rightLocations.length; i++) {
                if (rightLocations[i] > leftLocations[i]) {
                    sum += (rightLocations[i] - leftLocations[i]);
                } else {
                    sum += (leftLocations[i] - rightLocations[i]);
                }
            }
            System.out.println(sum);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    public void PartTwo() {
        try {
            File file = new File("/home/victorlicht/Desktop/Technical/languages-lab/java/advent-of-code-2024/src/main/java/com/victorlicht/day1/input");
            Scanner reader = new Scanner(file);

            int[] rightLocations = new int[1000];
            int[] leftLocations = new int[1000];

            int sum = 0;
            int i = 0;
            while (reader.hasNextLine()) {

                StringBuilder data = new StringBuilder(reader.nextLine());
                rightLocations[i] = Integer.parseInt(data.substring(8, 13));
                leftLocations[i] = Integer.parseInt(data.substring(0, 5));
                i++;
            }
            System.out.println(Arrays.toString(rightLocations) + " -> " + Arrays.toString(leftLocations));
            reader.close();
            Arrays.sort(rightLocations);
            Arrays.sort(leftLocations);
            for (i = 0; i < leftLocations.length; i++) {
                int count = 0;
                for (int num : rightLocations) {
                    if (leftLocations[i] < num) {
                        break;
                    }
                    if (leftLocations[i] == num) count++;
                }
                int product = leftLocations[i] * count;
                sum += product;
            }
            System.out.println(sum);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
