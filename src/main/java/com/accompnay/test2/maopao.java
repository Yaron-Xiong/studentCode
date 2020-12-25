package com.accompnay.test2;

import java.util.Arrays;

public class maopao {
	public static void main(String[] args) {
		//int arr[] = new int[]{7,0, 6, 8, 9, 3, 0};
		int arr[] = new int[]{0, 0};
		int[] ints = sort(arr);
		System.out.println(Arrays.toString(ints));
	}

	public static int[] sort(int[] arr) {
		if (arr == null || arr.length < 2) {
			return arr;
		}
		for (int j = 0; j < arr.length; j++) {
			for (int i = 0; i < arr.length - j - 1; i++) {
				if (arr[i] < arr[i + 1]) {
					swap(arr, i, i + 1);
				}
			}
			
		}
		return arr;

	}

	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
