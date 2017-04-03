/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package learn.basic.homework;
//Create an array of 10 random numbers, write a program to find min and max number from the array

/**
 *
 * @author DattaKrupa
 */
public class MinMax {

	public static void main(String[] args) {
		int[] random = { 10, 6, 1, 5, 3, 8, 2, 7, 9, 8, 4 };
		MinMax mm = new MinMax();
		mm.sort(random); 

	}

	public void sort(int[] array) {
		int temp = 0;
		int max = 0;
		int min = 0;
		int temp2 = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] > max) {
				// max = array[i];

				temp2 = array[i];
			}
		}

		for (int i = 0; i < array.length; i++) {
			if (array[i] > max) {
				max = array[i];

				// temp2 = array[i];

			} else {
				if (array[i] < temp2) {
					min = array[i];
					temp2 = array[i];
					System.out.println("min1-->" + temp2);

				} else {
					System.out.println("min2-->" + array[i]);
				}
			}

		}
		if (min == 0) {
			min = array[0];
		}

		System.out.println("Maximum value is :" + max);
		System.out.println("Minimum value is :" + min);
	}
}
