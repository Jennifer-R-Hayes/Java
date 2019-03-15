/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortingalgorithms;

/**
 *
 * @author jenni
 */

//Quick sort
import java.io.*;
import java.util.*;
class quickSort {

    public static void main(String[] args) {
        //Initializing array
        int arr[] = {9, 4, 8, 3, 1, 2, 5};
        System.out.print("Initial Array : ");
        printArray(arr);
        quickSort(arr, 0, arr.length - 1);
    }
    public static void printArray(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println();
    }
    //Sorting in non decreasing order
    private static void quickSort(int[] arr, int i, int j) {
        if(i < j) {
            int pos = partition(arr, i, j);
            quickSort(arr, i, pos - 1);
            quickSort(arr, pos + 1, j);
        }
    }

    private static int partition(int[] arr, int i, int j) {
        int pivot = arr[j];
        int small = i - 1;

        for(int k = i; k < j; k++) {
            if(arr[k] <= pivot) {
                small++;
                swap(arr, k, small);
            }
        }

        swap(arr, j, small + 1);
        System.out.println("Pivot = " + arr[small + 1]);
        printArray(arr);
        return small + 1;
    }

    private static void swap(int[] arr, int k, int small) {
        int temp;
        temp = arr[k];
        arr[k] = arr[small];
        arr[small] = temp;
    }


}
