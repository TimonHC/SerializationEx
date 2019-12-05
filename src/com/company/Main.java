package com.company;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
    public static final String PATH_TO_UNSORTED_FILE = "Files\\UnsortedRandomNums.txt";
    public static final String PATH_TO_SORTED_FILE = "Files\\SortedRandomNums.txt";
    public static final String PATH_TO_SERIALIZED_SORTED_FILE = "Files\\SerializedSortedRandomNums.txt";
    public static final String PATH_TO_FILE_TO_REPLACE_SUBSTRINGS = "C:\\Users\\Sweethome\\CarExWithExceptionCheck\\SerializationEx" +
            "\\src\\com\\company\\ArrayManager.java";


    public static void main(String[] args) throws IOException {
        Random random = new Random();
        FileWriter fileWriter = new FileWriter(PATH_TO_UNSORTED_FILE);
        FileWriter fileWriter1 = new FileWriter(PATH_TO_SORTED_FILE);
        File unsorted = new File(PATH_TO_UNSORTED_FILE);
        File sorted = new File(PATH_TO_SORTED_FILE);
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
        //read the text of the java program and all the words "public" replace with "private"
        {
            FileReader fileReader = new FileReader(PATH_TO_FILE_TO_REPLACE_SUBSTRINGS);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String abc = bufferedReader.lines().collect(Collectors.joining("\n"));
            System.out.print(abc.replaceAll("", "I ATE THAT "));}
        Serializer.explicitSerialize(sorted, PATH_TO_SERIALIZED_SORTED_FILE);


    }

}