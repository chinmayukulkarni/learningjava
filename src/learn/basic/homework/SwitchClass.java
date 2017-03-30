/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package learn.basic.homework;

import java.util.Scanner;

/**
 *
 * @author DattaKrupa
 */
public class SwitchClass {

    public static void main(String[] args) {
       SwitchClass sw = new SwitchClass();
       sw.switchcaseExample();
    }

    private void switchcaseExample() {
        System.out.println("Please enter the number");
        Scanner sc = new Scanner(System.in);
        //System.out.println("Your Number is: "+ sc.next());
        int number = sc.nextInt();
/*If you want to access double from System.in then you use scanner object as : sc.nextdouble()*/
        // String myString  = sc.next();
        // double myDouble = sc.nextDouble();
        switch (number) {
            case 1: {
                System.out.println("ONE");
                break;
            }
            case 2: {
                System.out.println("TWO");
                break;
            }
            case 3: {
                System.out.println("THREE");
                break;
            }
            case 4: {
                System.out.println("FOUR");
                break;
            }
            case 5: {
                System.out.println("FIVE");
                break;
            }
            case 6: {
                System.out.println("SIX");
                break;
            }
            case 7: {
                System.out.println("SEVEN");
                break;
            }
            case 8: {
                System.out.println("EIGHT");
                break;
            }
            case 9: {
                System.out.println("NINE");
                break;
            }
            default: {
                System.out.println("OTHER");
            }
        }

    }
}
