package com.company;

import java.io.*;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static final String PATH_TO_UNSORTED_FILE = "Files\\UnsortedRandomNums.txt";
    public static final String PATH_TO_SORTED_FILE = "Files\\SortedRandomNums.txt";
    public static void main(String[] args) throws IOException, ClassNotFoundException {
            //enter lenght of array
        /*int lenght = scanner.nextInt();
        int[] randomNums = new int[lenght];
        File sortedFile = new File(PATH_TO_SORTED_FILE);
        File unsortedFile = new File (PATH_TO_UNSORTED_FILE);
        ArrayManager.intArrayRandomNumsFiller(randomNums);*/
        Random random = new Random();
        FileWriter fileWriter = new FileWriter(PATH_TO_UNSORTED_FILE);
        for (int i = 0; i < 10; i++) {
            fileWriter.write(random.nextInt(10)+" ");
        }
        fileWriter.flush();
        fileWriter.close();

        int[] sortBuffer = new int[10];
        int i = 0;
        File unsorted = new File(PATH_TO_UNSORTED_FILE);
        Scanner scanner = new Scanner(unsorted);
        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                sortBuffer[i] = scanner.nextInt();
                System.out.print(sortBuffer[i]+" ");
                i++;
            } else scanner.next();
        }
        scanner.close();

        FileWriter fileWriter1 = new FileWriter(PATH_TO_SORTED_FILE);
        ArrayManager.intArraySorter(sortBuffer);
        for (i = 0; i < sortBuffer.length; i++) {
            fileWriter1.write(sortBuffer[i]+" ");
        }
        fileWriter1.flush();
        fileWriter1.close();

    }
}