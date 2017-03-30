/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package learn.basic.homework;
//Write a program called SumAndAverage to produce the sum of 1, 2, 3, ..., to 100. Also compute and display the average. The output shall look like:
//The sum is 5050
//The average is 50.5
/**
 *
 * @author DattaKrupa
 */
public class SumAndAverage {
    public static void main(String[] args){
      float y=0; 
      
        for (int x=1;x<=100;x++) {
            y += x;            
                     
        }
       float z = (y/100);
        System.out.println("The sum is "+(int)y);
        System.out.println("The average is "+z);
    }
    
}
