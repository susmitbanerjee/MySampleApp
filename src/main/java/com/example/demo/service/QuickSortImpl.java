package com.example.demo.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.stereotype.Service;

@Service
@Qualifier("quickSort")
public class QuickSortImpl implements SortService {
    static void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    static int partition(int[] arr, int low, int high){
        int pivot = arr[high];
        int i=low-1;
        for(int j=low;j<high;j++){
            if(arr[j]<pivot){
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i+1,high);
        return i+1;
    }

    void quickSort(int[] arr, int low, int high){
        if(low<high){
            int pi=partition(arr, low,high);
            quickSort(arr,low,pi-1);
            quickSort(arr, pi+1, high);
        }
    }

    @Override
    public int[] sortArray(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
        return arr;
    }
}
