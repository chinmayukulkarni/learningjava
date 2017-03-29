/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;
//Modify the program to sum from 111 to 8899, and compute the average
/**
 *
 * @author DattaKrupa
 */
public class SumAndAverage1 {
     public static void main(String[] args){
      float y=0; 
      float s=0;
      
        for (int x=111;x<=8899;x++) {
            y += x;            
         }
        s=8899-111;
       float z = (y/s*100);
        System.out.println("The sum is "+(int)y);
        System.out.println("The average is "+z);
    }
}
