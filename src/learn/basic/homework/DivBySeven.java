/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;
// Write a program to create an array of numbers divisible by 7 from 1 to 100. Compute their sum.

/**
 *
 * @author DattaKrupa
 */
public class DivBySeven {

    public static void main(String[] args) {
        int counter = 0;
        int p = 0;
        int sum=0;
        for (int i = 0; i < 100; i++) {

            int z = i % 7;
            if (z == 0) {
                counter++;
            }
        }
        int[] seven = new int[counter];
        for (int j = 0; j < 100; j++) {
            int l = j % 7;
            if (l == 0) {
                seven[p] = j;
                p++;
            }
        }

        for (int k = 0; k < seven.length; k++) {
            sum += seven[k];
            System.out.println(seven[k]);
            
        }System.out.println("The sum is:"+sum);

    }
}
