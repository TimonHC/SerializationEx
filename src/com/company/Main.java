package com.company;

import java.io.*;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static final String PATH_TO_UNSORTED_FILE = "Files\\UnsortedRandomNums.txt";
    public static final String PATH_TO_SORTED_FILE = "Files\\SortedRandomNums.txt";
    public static final String PATH_TO_SERIALIZED_SORTED_FILE = "Files\\SerializedSortedRandomNums.txt";

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Random random = new Random();
        FileWriter fileWriter = new FileWriter(PATH_TO_UNSORTED_FILE);
        File unsorted = new File(PATH_TO_UNSORTED_FILE);
        FileWriter fileWriter1 = new FileWriter(PATH_TO_SORTED_FILE);
        Scanner scanner = new Scanner(unsorted);

        for (int i = 0; i < 10; i++) {
            fileWriter.write(random.nextInt(10)+" ");
        }
        fileWriter.flush();
        fileWriter.close();

        int[] sortBuffer = new int[10];
        int i = 0;
        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                sortBuffer[i] = scanner.nextInt();
                i++;
            } else scanner.next();
        }
        scanner.close();

        ArrayManager.intArraySorter(sortBuffer);
        for (i = 0; i < sortBuffer.length; i++) {
            fileWriter1.write(sortBuffer[i]+" ");
        }
        fileWriter1.flush();
        fileWriter1.close();
        File sorted = new File(PATH_TO_SORTED_FILE);
        Serializer.explicitSerialize(sorted, PATH_TO_SERIALIZED_SORTED_FILE);
    }
}