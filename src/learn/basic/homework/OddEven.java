/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;
//Write a program called CheckOddEven which prints "Odd Number" if the int variable “number” is odd, or “Even Number” otherwise. The program shall always print “BYE!” before exiting.
/**
 *
 * @author DattaKrupa
 */
public class OddEven {
    
    public static void main(String[] args){
        int number=0;
        
        int z = number%2;
        if(z == 0){
            System.out.println("Number is Even");
           
        }else
        {
            System.out.println("Number Is odd");
            
        }
            
         System.out.println("BYE!");
    }
}
