package com.company;

import java.io.*;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        boolean sorted = false;
        int[] randomNums = new int[100];
        Random random = new Random();
        for(int i = 1; i < randomNums.length; i++){
            randomNums[i] = random.nextInt(100);
        }
            for (int left = 0; left < randomNums.length; left++) {
                // Вытаскиваем значение элемента
                int value = randomNums[left];
                // Перемещаемся по элементам, которые перед вытащенным элементом
                int i = left - 1;
                for (; i >= 0; i--) {
                    // Если вытащили значение меньшее — передвигаем больший элемент дальше
                    if (value < randomNums[i]) {
                        randomNums[i + 1] = randomNums[i];
                    } else {
                        // Если вытащенный элемент больше — останавливаемся
                        break;
                    }
                }
                // В освободившееся место вставляем вытащенное значение
                randomNums[i + 1] = value;
            }
        for (int i = 0; i < randomNums.length; i++) {
            System.out.println(i+ ": "  + randomNums[i]+" ");
        }

        FileWorker.write("Files\\RandomNums.txt", "");
        FileOutputStream fileOutputStream = new FileOutputStream("Files\\RandomNums.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(randomNums);
        objectOutputStream.close();

    }
}