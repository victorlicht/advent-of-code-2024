package com.victorlicht.day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class RedNosedReports {

    public void partOne() {
        try {
            File file = new File("/home/victorlicht/Desktop/Technical/languages-lab/java/advent-of-code-2024/src/main/java/com/victorlicht/day2/input"); // Adjust the path as needed
            Scanner reader = new Scanner(file);
            int safeReportsCount = 0;

            while (reader.hasNextLine()) {
                String report = reader.nextLine();
                List<Integer> reportList = parseReport(report);
                if (isSafe(reportList)) safeReportsCount++;
            }

            reader.close();
            System.out.println("\nPart One - Total Safe Reports: " + safeReportsCount);
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Input file not found", e);
        }
    }

    public void partTwo() {
        try {
            File file = new File("/home/victorlicht/Desktop/Technical/languages-lab/java/advent-of-code-2024/src/main/java/com/victorlicht/day2/input"); // Adjust the path as needed
            Scanner reader = new Scanner(file);
            int safeReportsCount = 0;

            while (reader.hasNextLine()) {
                String report = reader.nextLine();
                List<Integer> reportList = parseReport(report);
                if (!isSafe(reportList)) {
                    if (isSafeWithOneRemoval(reportList)) safeReportsCount++;
                } else {
                    safeReportsCount++;
                }
            }
            reader.close();
            System.out.println("\nPart Two - Total Safe Reports: " + safeReportsCount);
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Input file not found", e);
        }
    }

    private List<Integer> parseReport(String report) {
        List<Integer> reportList = new ArrayList<>();
        StringTokenizer tokenizer = new StringTokenizer(report);
        while (tokenizer.hasMoreTokens()) {
            reportList.add(Integer.parseInt(tokenizer.nextToken()));
        }
        return reportList;
    }

    private boolean isSafeWithOneRemoval(List<Integer> reportList) {
        int size = reportList.size();

        for (int i = 0; i < size; i++) {
            // Simulate removing the `i`th element by skipping it
            List<Integer> simulatedReport = new ArrayList<>();
            for (int j = 0; j < size; j++) {
                if (j != i) {
                    simulatedReport.add(reportList.get(j));
                }
            }


            if (isSafe(simulatedReport)) {
                return true;
            }
        }

        return false;
    }

    private boolean isSafe(List<Integer> reportList) {
        boolean increasing = false, decreasing = false;
        for (int i = 0; i < reportList.size() - 1; i++) {
            int currentValue = reportList.get(i);
            int nextValue = reportList.get(i + 1);
            int diff = Math.abs(nextValue - currentValue);

            if (diff < 1 || diff > 3) {
                return false; // Invalid difference
            }

            if (currentValue < nextValue) increasing = true;
            if (currentValue > nextValue) decreasing = true;

            if (increasing && decreasing) {
                return false; // Mixed directions
            }
        }
        return true;
    }
}
