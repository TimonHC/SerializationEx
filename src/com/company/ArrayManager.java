package com.company;

import java.util.Random;

public class ArrayManager {
    boolean sorted = false;

    public static int[] intArrayRandomNumsFiller(int[] array){
        Random random = new Random();
        for(int i = 1; i < array.length; i++){
            array[i] = random.nextInt(array.length);
        }return array;
    }
    public static int[] intArraySorter(int [] array){


        for (int left = 0; left < array.length; left++) {
            // Вытаскиваем значение элемента
            int value = array[left];
            // Перемещаемся по элементам, которые перед вытащенным элементом
            int i = left - 1;
            for (; i >= 0; i--) {
                // Если вытащили значение меньшее — передвигаем больший элемент дальше
                if (value < array[i]) {
                    array[i + 1] = array[i];
                } else {
                    // Если вытащенный элемент больше — останавливаемся
                    break;
                }
            }
            // В освободившееся место вставляем вытащенное значение
            array[i + 1] = value;
        }

        return array;
    }

}
