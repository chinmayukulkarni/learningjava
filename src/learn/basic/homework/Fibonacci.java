/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package learn.basic.homework;
//Write a program called Fibonacci to display the first 20 Fibonacci numbers F(n), where F(n)=F(n–1)+F(n–2) and F(1)=F(2)=1. Also compute their average. The output shall look like:
//The first 20 Fibonacci numbers are:
//1 1 2 3 5 8 13 21 34 55 89 144 233 377 610 987 1597 2584 4181 6765
//The average is 885.5
/**
 *
 * @author DattaKrupa
 */
public class Fibonacci {

    public static void main(String[] args) {
        float avg;
        float sum = 0;
        int count = 0;
        int j;
        int array[] = new int[22];

        for (int i = 2; i < array.length; i++) {
            array[0] = 1;
            if (i != 0) {
                array[i] = array[i - 1] + array[i - 2];
            } else {
                System.out.println("Array out of Bound");
            }

        }
        for (j = 2; j < array.length; j++) {
            System.out.println(array[j]);
        }
        for (int x = 2; x < array.length; x++) {
            sum += array[x];
            count++;

        }
        System.out.println("The Sum is:" + (int) sum);
        avg = sum / count - 2;
        System.out.println("The average is:"+avg);
    }

}
