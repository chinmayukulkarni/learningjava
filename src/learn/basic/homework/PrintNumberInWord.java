/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package learn.basic.homework;
//Write a program called PrintNumberInWord which prints "ONE", "TWO",... , "NINE", "OTHER" if the int variable "number" is 1, 2,... , 9, or other, respectively

import java.util.Scanner;

/**
 *
 * @author DattaKrupa
 */
public class PrintNumberInWord {
    
    public static void main(String[] args){
        int number=5;
        
        if (number == 1){
            System.out.println("ONE");
        }else if(number ==2){
            System.out.println("TWO");            
        }else if(number ==3){
            System.out.println("THREE");            
        }else if(number ==4){
            System.out.println("FOUR");            
        }else if(number ==5){
            System.out.println("FIVE");            
        }else if(number ==6){
            System.out.println("SIX");            
        }else if(number ==7){
            System.out.println("SEVEN");            
        }else if(number ==8){
            System.out.println("EIGHT");            
        }else if(number ==9){
            System.out.println("NINE");            
        }else {
            System.out.println("OTHER");            
        }
        
//        PrintNumberInWord obj = new PrintNumberInWord();
//        // Obj is a variable of type "left" 'PrintNumberInWord' which refers to the object of "right" 'PrintNumberInWord'
//        obj.switchcaseExample();
//        
    }
    
   
    
    }

