package com.company;

import java.io.*;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static final String PATH_TO_FILE = "Files\\RandomNums.txt";
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Scanner scanner = new Scanner(System.in);
        //enter lenght of array
        int lenght = scanner.nextInt();
        int[] randomNums = new int[lenght];
        ArrayManager.intArraySorter(randomNums);
        Serializer.explicitSerialize(randomNums, PATH_TO_FILE);
        Serializer.decodeSerialized(PATH_TO_FILE, randomNums);
        for (int i = 0; i < randomNums.length; i++) {
            System.out.println(randomNums[i]);
        }

    }
}