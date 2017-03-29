/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;
//Modify the program to sum only the odd numbers from 1 to 100, and compute the average.
/**
 *
 * @author DattaKrupa
 */
public class SumAndAverage3 {

    public static void main(String[] args) {

        float avg = 0;
        int count = 0;
        float oddSum = 0;
        for (int x = 0; x < 100; x++) {

            int z = x % 2;
            if (z == 1) {

                oddSum += x;
                count++;
            }
        }
        avg = oddSum / count;
        System.out.println("Sum is" + oddSum);
        System.out.println("Average is" + avg);
    }
}
