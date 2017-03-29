/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;
//create an array of numbers 1,7,8,9,10,11. Compute Sum and average Add them and display the result.
/**
 *
 * @author DattaKrupa
 */
public class SumAndAverage2 {
 public static void main(String[] args){
     int count=0;
     float sum=0;
     float avg=0;
     int[] array={1,7,8,9,10,11,12};
     
     for(int x=0;x<array.length;x++){
         sum +=array[x];
         count++;
         
     }
      avg = sum/count;
     
     System.out.println("The sum is "+(int)sum);
     System.out.println("The average is "+avg);
 }
}
