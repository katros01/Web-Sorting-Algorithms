
package com.example.Web.Sorting.Algorithms.Utils;

import com.example.Web.Sorting.Algorithms.Models.Book;

import java.util.List;

public class MergeSort {

    public static void mergeSort(List<Book> books, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;

            mergeSort(books, left, middle);

            mergeSort(books, middle + 1, right);

            merge(books, left, middle, right);
        }
    }

    private static void merge(List<Book> books, int left, int middle, int right) {
        int n1 = middle - left + 1;
        int n2 = right - middle;

        Book[] leftArray = new Book[n1];
        Book[] rightArray = new Book[n2];

        for (int i = 0; i < n1; i++) {
            leftArray[i] = books.get(left + i);
        }
        for (int j = 0; j < n2; j++) {
            rightArray[j] = books.get(middle + 1 + j);
        }


        int i = 0, j = 0;

        int k = left;
        while (i < n1 && j < n2) {
            if (leftArray[i].getName().compareTo(rightArray[j].getName()) <= 0) {
                books.set(k, leftArray[i]);
                i++;
            } else {
                books.set(k, rightArray[j]);
                j++;
            }
            k++;
        }

        while (i < n1) {
            books.set(k, leftArray[i]);
            i++;
            k++;
        }

        while (j < n2) {
            books.set(k, rightArray[j]);
            j++;
            k++;
        }
    }
}