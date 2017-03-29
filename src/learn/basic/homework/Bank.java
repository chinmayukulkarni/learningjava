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
public class Bank {
   public String name;
   public String Accno;
   
   public void SetName(String name){
       this.name=name;
   }
   
   public void SetAccno(String Accno){
       this.Accno=Accno;
   }
           
   public String GetName(){
       return this.name;
   }
   public String GetAccno(){
       return this.Accno;
   }
}
