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
public class SumAndAverage4 {

    public static void main(String[] args) {

        // Compute the counter with which you will initialize the array.
        // Create an odd number array for numbers between 1 and 100
        // print the odd number array
        // Compute the sum and average of odd number array
        int number = 0;
        int counter = 0;

        for (int j = 0; j < 100; j++) {
            int z = j % 2;
            if (z != 0) {
                counter++;
            }
        }
        int OddArray[] = new int[counter];
        System.out.println(counter);
        // for (int m = 0; m < 100; m++)
        int i=0;
         for (int m = 0; m < 100; m++){
            //for (int i = 0; i < OddArray.length; i++) {
                int d = m % 2;
                if (d != 0) {

                    OddArray[i] = m;
                    i++;

                }
            
        }
         float sum=0;
         float avg=0;
        for (int p = 0; p < OddArray.length; p++) {
            System.out.println(OddArray[p]);
            sum +=OddArray[p];
            avg = sum/OddArray.length;
           
        }
         System.out.println("Odd sum is"+sum);
            System.out.println("Average is"+avg);
        
        
    }
}
