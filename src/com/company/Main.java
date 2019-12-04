package com.company;

import java.io.*;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static final String PATH_TO_UNSORTED_FILE = "Files\\UnsortedRandomNums.txt";
    public static final String PATH_TO_SORTED_FILE = "Files\\SortedRandomNums.txt";
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Scanner scanner = new Scanner(System.in);        //enter lenght of array
        int lenght = scanner.nextInt();
        int[] randomNums = new int[lenght];
        File sortedFile = new File(PATH_TO_SORTED_FILE);
        File unsortedFile = new File (PATH_TO_UNSORTED_FILE);
        ArrayManager.intArrayRandomNumsFiller(randomNums);

        if(unsortedFile.createNewFile()) {
            Serializer.explicitSerialize(randomNums, PATH_TO_UNSORTED_FILE);
        }
        Serializer.decodeSerialized(PATH_TO_UNSORTED_FILE, randomNums);
        //принтим массив
        for (int i = 0; i < randomNums.length; i++) {
            System.out.println(i+1+ ": "  + randomNums[i]+" ");
        }
        ArrayManager.intArraySorter(randomNums);

        if(sortedFile.createNewFile()){
            Serializer.explicitSerialize(randomNums, PATH_TO_SORTED_FILE);
        }
        //принтим массив
        for (int i = 0; i < randomNums.length; i++) {
            System.out.println(i+1+ ": "  + randomNums[i]+" ");
        }

    }
}