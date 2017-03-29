/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 *
 * @author DattaKrupa
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] Intiger1= {1,2,3,4,5};
    char[] character = {'a','b','c','d','e'};
    float[] float1 ={ 10.0f,20.f,30.0f,40.0f,50.0f};
      
    Forloop fr = new Forloop();
    fr.PrintIntArray(Intiger1);
    fr.PrintIntArray1(character);
    fr.PrintIntArray2(float1);
    
    
    Bank bk = new Bank();
    bk.SetName("abc");
    bk.SetAccno("12345");
    
     Bank bk1 = new Bank();
    bk1.SetName("qqq");
    bk1.SetAccno("12435");
    
     Bank bk2 = new Bank();
    bk2.SetName("www");
    bk2.SetAccno("123454");
    
     Bank[] client = {bk,bk1,bk2};
     Main mn = new Main();
    fr.PrintClient(client);
    }
    
   
    
}
