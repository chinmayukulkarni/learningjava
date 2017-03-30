/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package learn.basic.homework;

/**
 *
 * @author DattaKrupa
 */
public class Forloop {
    
    public void PrintIntArray(int[] array){
        for(int i=0;i< array.length;i++)
            System.out.println(array[i]);
        }
    public void PrintIntArray1(char[] array){
        for(int i=0;i< array.length;i++)
            System.out.println(array[i]);
        }
    public void PrintIntArray2(float[] array){
        for(int i=0;i< array.length;i++)
            System.out.println(array[i]);
        }
    public void PrintClient(Bank[] myclient){
       for(int i=0;i< myclient.length;i++){
           System.out.println(myclient[i].GetName());
           System.out.println(myclient[i].GetAccno());
       }
    }
//    Bank bk = new Bank();
//    Bank bk1 = new Bank();
//    Bank bk2 = new Bank();
    
    
}
