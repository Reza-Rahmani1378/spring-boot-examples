package com.hammi.java.binary_search;

import java.util.List;

public class BinarySearch {

    public static void main(String[] args) {
        int key = 10;
        Integer[] list= List.of(
                1,4,5,6,11,14,67,98,111,130,179,190,570
        ).toArray(new Integer[0]);
        System.out.println(list.length);
        System.out.println(binarySearch(list, 570));


    }


    public static int binarySearch(Integer[] list , int key) {
        int low = 0;
        int high = list.length -1 ;
        while (high >= low) {
            int mid = (low + high) / 2;
            if (key == list[mid]) {
                return mid;
            } else if (key < list[mid]) {
                high = mid -1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
